package com.amysoftech.helpdesk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* for Ticket Creation
Created by Priya Jha(12/4/23)*/
public class CreateTicket extends AppCompatActivity {
    ImageView im;
    Spinner pro, proc, tick;
    EditText orgranization, textcreatetask, descrip;
    EditText title1;
    ImageView uploadfile;
    //TextView txtbt; Spinner tick; ImageView setImg; Spinner ticktype;
    TextView SubmitbtnCreateTicket;
    String[] pri = {"Please select", "Severe", "High", "Medium", "Low"};
    String[] ticktype1 = {"Please select", "Change Request", "New Development", "Support"};
    private File finalfile;
    TextView setImg;

    ArrayList<processPojo> data = new ArrayList<>();
    ArrayList<projectpojo> data1 = new ArrayList<>();
    Spinner ticktype;
    String project_id = "", process_id = "", tick_prio = "", tick_type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_ticket);
        im = findViewById(R.id.im);
        // ticktype = findViewById(R.id.spinnertickettype);
        //textcreatetask = findViewById(R.id.textcreatetask);
        orgranization = findViewById(R.id.organization);
        descrip = findViewById(R.id.editdescription);
        pro = findViewById(R.id.spinnerproject);
        proc = findViewById(R.id.spinnerprocess);
        title1 = findViewById(R.id.title);
        setImg = findViewById(R.id.setImg);
        uploadfile = findViewById(R.id.uploadfile);
        tick = findViewById(R.id.ticketprio);
        ticktype = findViewById(R.id.spinnertickettype);
        SubmitbtnCreateTicket = findViewById(R.id.SubmitbtnCreateTicket);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        SubmitbtnCreateTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validation()) {
                    try {

                        sendCreateTicketRequest();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }

        });

        orgranization.setText(MyPrefrence.getInstance(CreateTicket.this).GETOrganization());
        uploadfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDialog();
               /* if (ContextCompat.checkSelfPermission(CreateTicket.this,

                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(CreateTicket.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,

                            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1);
                } else {

                }*/
            }

        });

        tick.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tick_prio = pri[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ticktype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tick_type = ticktype1[position];

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter ad = new ArrayAdapter(this,

                android.R.layout.simple_spinner_item, pri);
        ad.setDropDownViewResource(android.R.layout

                .simple_spinner_dropdown_item);
        tick.setAdapter(ad);
        ArrayAdapter ad1 = new ArrayAdapter(this,

                android.R.layout.simple_spinner_item, ticktype1);
        ad.setDropDownViewResource(android.R.layout

                .simple_spinner_dropdown_item);
        ticktype.setAdapter(ad1);

        proc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    process_id = data.get(position - 1).getProcessName();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        sendprocessRequest();

        pro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    project_id = data1.get(position - 1).getProjectID();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sendprojectRequest();

        setImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(CreateTicket.this,

                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(CreateTicket.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,

                            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1);

                } else {

                }
            }


        });

    }

    private void startDialog() {
        AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(CreateTicket.this);
        myAlertDialog.setTitle("Upload Pictures Option");
        myAlertDialog.setMessage("How do you want to set your picture?");
        myAlertDialog.setPositiveButton("Gallery", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto, 0);

            }
        });

        myAlertDialog.setNegativeButton("Camera", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(cameraIntent, 1);
            }
        });
        myAlertDialog.show();
    }


    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();

        inImage.compress(Bitmap.CompressFormat.PNG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        String path = "";
        if (CreateTicket.this.getContentResolver() != null) {
            Cursor cursor = CreateTicket.this.getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                path = cursor.getString(idx);
                cursor.close();
            }
        }
        return path;
    }

    public boolean validation() {

        if (title1.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(CreateTicket.this, "Title can't be empty", Toast.LENGTH_SHORT).show();
            return false;
        } else if (pro.getSelectedItem().toString().trim().equals("Please select")) {
            Toast.makeText(CreateTicket.this, "Please select project", Toast.LENGTH_SHORT).show();
            return false;
        } else if (proc.getSelectedItem().toString().trim().equals("Please select")) {
            Toast.makeText(CreateTicket.this, "Please select process", Toast.LENGTH_SHORT).show();
            return false;
        } else if (tick.getSelectedItem().toString().trim().equals("Please select")) {
            Toast.makeText(CreateTicket.this, "Please select ticket priority", Toast.LENGTH_SHORT).show();
            return false;
        } else if (ticktype.getSelectedItem().toString().trim().equals("Please select")) {
            Toast.makeText(CreateTicket.this, "Please select ticket type", Toast.LENGTH_SHORT).show();
            return false;
        } else if (textcreatetask.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(CreateTicket.this, "Description can't be empty", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


    @SuppressLint("MissingSuperCall")
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {

            case 0:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();

                    uploadfile.setImageURI(selectedImage);
                    finalfile = new File(getRealPathFromURI(selectedImage));

                    setImg.setVisibility(View.VISIBLE);

                }

                break;
            case 1:
                if (resultCode == RESULT_OK) {

                    Bitmap photo = (Bitmap) data.getExtras().get("data");

                    uploadfile.setImageBitmap(photo);
                    Uri tempUri = getImageUri(CreateTicket.this, photo);
                    finalfile = new File(getRealPathFromURI(tempUri));
                    uploadfile.setImageBitmap(photo);
                    setImg.setVisibility(View.VISIBLE);
                }
                break;

        }
    }

    //API Implementation for Create ticket using Multipart
    public void sendCreateTicketRequest() throws FileNotFoundException {

        final RequestParams params = new RequestParams();
        params.put("customer_id", "4");
        params.put("subject", title1.getText().toString().trim());
        params.put("organization", MyPrefrence.getInstance(CreateTicket.this).GETOrganization());
        params.put("project", project_id);
        params.put("process", process_id);
        params.put("priority", tick_prio);
        params.put("ticket_type", tick_type);

        params.put("description", textcreatetask.getText().toString());
        if (finalfile != null) {
            params.put("img", finalfile);
            params.put("type", "image");
        } else {
            params.put("img", "");
        }

        Log.e("ParmaCreate", ">>>>" + params);

        webServices.post("Mobapp_API.php?action=CREATE_TICKET", params, new JsonHttpResponseHandler() {
            @Override
            public void onStart() {

                super.onStart();

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.e("create", ">>>>" + response);

                try {
                    JSONObject obj = new JSONObject(String.valueOf(response));
                    String msg = obj.getString("Message");
                    String status = obj.getString("Status");
                    if (status.equalsIgnoreCase("1")) {


                        Toast.makeText(CreateTicket.this, msg, Toast.LENGTH_LONG).show();
                        // Intent in = new Intent(CreateTicket.this, SideNavigation.class
                        //);
                        //startActivity(in);
                    } else {

                        Toast.makeText(CreateTicket.this, msg, Toast.LENGTH_LONG).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFinish() {

                super.onFinish();


            }
        });

    }

    //Implemetation of Process API
    public void sendprocessRequest() {

//CustomProgress.showProgress(Createticket.th is);
        ApiServices apiServices = RetrofitHelper.getRetrofitInstance().create(ApiServices.class);

        try {

            apiServices.sendProcessData("2", "3", MyPrefrence.getInstance(CreateTicket.this).GetAccessToken()).enqueue(new retrofit2.Callback<processmodel>() {
                @Override
                public void onResponse(Call<processmodel> call, Response<processmodel> response) {
                    ArrayList<String> expen_name = new ArrayList<>();

                    if (response.body().getStatus().equalsIgnoreCase("1")) {
                        data = response.body().getAssignDataList();

                        expen_name.add("Please select");
                        for (int i = 0; i < data.size(); i++) {

                            expen_name.add(response.body().getAssignDataList().get(i).getProcessName());
                        }

                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(CreateTicket.this, android.R.layout.simple_spinner_item, expen_name);

                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        proc.setAdapter(spinnerArrayAdapter);

//
                        data = response.body().getAssignDataList();
//   recyclepriority.setAdapter(new prioritydashboardAdapter(data, Createticket.this));

                    } else {
                        expen_name.add("No Data");
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(CreateTicket.this, android.R.layout.simple_spinner_item, expen_name);

                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        proc.setAdapter(spinnerArrayAdapter);

//
                        //    CustomProgress.hideProgress();
                    }

                }

                @Override
                public void onFailure(Call<processmodel> call, Throwable t) {

                }
            });


        } catch (Exception e) {
            e.printStackTrace();
// CustomProgress.hideProgress();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

        } else {
// Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    public void sendprojectRequest() {
        //CustomProgress.showProgress(Createticket.this);
        ApiServices apiServices = RetrofitHelper.getRetrofitInstance().create(ApiServices.class);
        try {
            apiServices.sendProjectData("4", "3", MyPrefrence.getInstance(CreateTicket.this).GetAccessToken()).enqueue(new Callback<projectmodel>() {
                @Override
                public void onResponse(Call<projectmodel> call, Response<projectmodel> response) {
                    ArrayList<String> expen_name1 = new ArrayList<>();
                    if (response.body().getStatus().equalsIgnoreCase("1")) {
                        data1 = response.body().getAssignDataList();

                        expen_name1.add("Please select");
                        for (int i = 0; i < data1.size(); i++) {

                            expen_name1.add(response.body().getAssignDataList().get(i).getProjectName());
                        }

                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(CreateTicket.this, android.R.layout.simple_spinner_item, expen_name1);

                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        pro.setAdapter(spinnerArrayAdapter);

//
                        data1 = response.body().getAssignDataList();
// recyclepriority.setAdapter(new prioritydashboardAdapter(data, Createticket.this));

                    } else {
                        expen_name1.add("No Data");
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(CreateTicket.this, android.R.layout.simple_spinner_item, expen_name1);

                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        pro.setAdapter(spinnerArrayAdapter);

//CustomProgress.hideProgress();
                    }
                }


                @Override
                public void onFailure(Call<projectmodel> call, Throwable t) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            //CustomProgress.hideProgress();
        }


    }


}

