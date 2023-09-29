package com.amysoftech.helpdesk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditTicket extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinnerstatus;
    EditText projectEdit;

    ImageView im, chat_image;
    TextView textviewImageName, ticket_id;
    String Image;
    Spinner task;
    String list_type = "";

    RelativeLayout btndecode;
    TextView decodetext, submitbtn;
    TextView textcreate, textcreate1, department, tickettype, assignedname, ticketpriority, or, process, project;
    EditText assignednameedit, organi, processedit, ticketprioedit, departmentedit, editdescription, tickettype1;
    String priority = "";
    String organization = "";
    String ticket_type = "";
    String department_name = "";
    String description_name = "";
    String id = "";
    String ticketid = "";
    String image = "";
    String assigned = "";
    String project1 = "";
    String process1 = "";
    String orgrani = "";
    String processEdit = "";
    String ticketpri = "";
    String depart = "";
    String ticktype = "";
    String assignename = "";
    String status = "";
    String desc = "";
    ImageView back;

    String img = "";

    Button file,dwnldbtn;
    String Spinner_status = "";

    DownloadManager manager;
    ArrayList<String> taskk = new
            ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ticket);
        organi = findViewById(R.id.organi);
        chat_image = findViewById(R.id.chat_image);
        textviewImageName = findViewById(R.id.textviewImageName);
        ticket_id = findViewById(R.id.ticket_id);
        tickettype1 = findViewById(R.id.tickettype);
        dwnldbtn = findViewById(R.id.dwnldbtn);
        departmentedit = findViewById(R.id.departmentedit);
        processedit = findViewById(R.id.processedit);
        back = findViewById(R.id.back1);
        task = findViewById(R.id.task);
        submitbtn = findViewById(R.id.submitbtn);
        projectEdit = findViewById(R.id.projectEdit);
        ticketprioedit = findViewById(R.id.ticketprioedit);
        editdescription = findViewById(R.id.editdescription);
        assignednameedit = findViewById(R.id.assignednameedit);
        projectEdit = findViewById(R.id.projectEdit);
        organization = getIntent().getStringExtra("Organization");
        organi.setText(organization);
        assigned = getIntent().getStringExtra("assigned");
        assignednameedit.setText(assigned);
        process1 = getIntent().getStringExtra("process");
        projectEdit.setText(process1);
        description_name = getIntent().getStringExtra("descrip");
        editdescription.setText(description_name);
        project1 = getIntent().getStringExtra("project");
        projectEdit.setText(project1);
        ticketpri = getIntent().getStringExtra("ticketpriority");
        ticketprioedit.setText(ticketpri);
        depart = getIntent().getStringExtra("department");
        departmentedit.setText(depart);
        processEdit = getIntent().getStringExtra("process");
        processedit.setText(processEdit);
        ticktype = getIntent().getStringExtra("tickettype");
        tickettype1.setText(ticktype);
        img = getIntent().getStringExtra("img");
        textviewImageName.setText(img);
        id = getIntent().getStringExtra("img");
        ticket_id.setText(img);
        ticketid = getIntent().getStringExtra("IncidentId");
        ticket_id.setText(ticketid);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEditTicketRequest();
            }
        });
        if (status.equalsIgnoreCase("Closed By Customer") || status.equalsIgnoreCase("Closed By Staff")) {
            task.setClickable(false);

            submitbtn.setVisibility(View.GONE);
        } else {

            submitbtn.setVisibility(View.VISIBLE);
        }

        if (MyPrefrence.getInstance(EditTicket.this).GETEMPROLE().equalsIgnoreCase("2")) {
            taskk.add(status);
            taskk.add("In-Review");
            taskk.add("Awaiting");
        } else if (MyPrefrence.getInstance(EditTicket.this).GETEMPROLE().equalsIgnoreCase("3")) {
            taskk.add(status);

            taskk.add("Closed By Customer");
            taskk.add("Cancel");
        }
        chat_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(EditTicket.this, ChatActivity.class);
                startActivity(in);
              /*  manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("http://helpdesk.amysoftech.com/aja x.php/upload/1677736380_PHP_TestScenario.pdf");
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                long reference = manager.enqueue(request);*/
            }
        });
        dwnldbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("http://helpdesk.amysoftech.com/aja x.php/upload/1677736380_PHP_TestScenario.pdf");
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                long reference = manager.enqueue(request);
            }
        });
        if (status.equals("Closed By Customer")) {
            task.setEnabled(false);
        } else {

        }


        // decodetext.setText(image);
        task.setOnItemSelectedListener(this);

        // Create the instance of ArrayAdapter
// having the list of courses

        ArrayAdapter ad
                = new ArrayAdapter(
                this,

                android.R.layout.simple_spinner_item,
                taskk);

// set simple layout resource file
// for each item of spinner
        ad.setDropDownViewResource(android.R.layout

                .simple_spinner_dropdown_item);

        task.setAdapter(ad);
    }

    public void sendEditTicketRequest() {
// CustomProgress.showProgress(EditTicket.this);
        ApiServices apiServices = RetrofitHelper.getRetrofitInstance().create(ApiServices.class);
        Log.d("#####", ">> " + ticketid + "	df "
                + Spinner_status);
        try {

            apiServices.sendEditTicketRequest(ticketid, Spinner_status, "")
                    .enqueue(new Callback<updateTicketModel>() {
                        @Override
                        public void onResponse(Call<updateTicketModel> call, Response<updateTicketModel> response) {
                            if (response.body().getStatus().equalsIgnoreCase("1")) {

                                //  Intent in = new Intent(EditTicket.this, SideNavigation.class);

                                //    startActivity(in);
                            } else {

                                Toast.makeText(EditTicket.this, response.body().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<updateTicketModel> call, Throwable t) {

                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
            //CustomProgress.hideProgress();
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}