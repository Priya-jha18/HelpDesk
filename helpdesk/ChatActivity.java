package com.amysoftech.helpdesk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {
    ImageView ImgBack, send_icon;
    TextView assignedname, tickedit;
    TextView assignedname1,ticketidd;

    String id = "";
    String assigned = "";
    String ticketid = "";
    String message = "";
    String image = "";
    CircleImageView attachment;
    String url = "";
    EditText edit_msg;
    RecyclerView chatboatRecy;
    ArrayList<chatpojo> data1 = new ArrayList<>();
    private File finalfile;
    String status = "";
    LinearLayout chatlinear;

    @Override
    protected void onCreate(Bundle
                                    savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chat);
        ImgBack = findViewById(R.id.ImgBack);
        attachment =
                findViewById(R.id.attachment);
        send_icon = findViewById(R.id.send_icon);
        chatlinear = findViewById(R.id.chatlinear);
        chatboatRecy = findViewById(R.id.chatboatRecy);
        edit_msg = findViewById(R.id.edit_msg);
        ticketidd = findViewById(R.id.ticketidd);
        assignedname1=findViewById(R.id.assignedname1);
        chatboatRecy.setHasFixedSize(true);
        status =
                getIntent().getStringExtra("Status");

        id = getIntent().getStringExtra("Incidentid");
        Log.d("####", "" + id);
        tickedit.setText(id);
        ticketid = getIntent().getStringExtra("id");
        message = getIntent().getStringExtra("Description");
        image = getIntent().getStringExtra("image");
        attachment.setOnClickListener(new
                                              View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View v) {

                                                  }
                                              });
// Log.e("###","<<"+id);
        assigned = getIntent().getStringExtra("assignedby");
        assignedname.setText(assigned);
        ImgBack.setOnClickListener(new
                                           View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {

                                                   onBackPressed();
                                               }
                                           });
      /*  if (status.equalsIgnoreCase("Closed By Customer") || status.equalsIgnoreCase("Closed")
        ) {

            chatlinear.setVisibility(View.GONE);
        } else {

            chatlinear.setVisibility(View.VISIBLE);
        }*/
        send_icon.setOnClickListener(new
                                             View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     try {
                                                         sendChatRequest();
                                                     } catch
                                                     (FileNotFoundException e) {
                                                         e.printStackTrace();
                                                     }
                                                 }
                                             });
        new Handler().postDelayed(new


                                          Runnable() {
                                              @Override
                                              public void run() {

                                              }

                                          }, 2000);
        try {
            sendChatRequest();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(ChatActivity.this,

                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ChatActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

                } else {
                    // startDialog();
                }
            }

        });
    }


    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case 0:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage =
                            data.getData();
//
                  /*  setImg.setImageURI(selectedImage);

                    finalfile = new
                            File(getRealPathFromURI(selectedImage));*/
// setImg.setVisibility(View.VISIBLE);
                    try {
                        sendChatRequest();
                    } catch
                    (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }

                break;
            case 1:
                if (resultCode == RESULT_OK) {

                    Bitmap photo = (Bitmap) data.getExtras().get("data");
// setImg.setImageBitmap(photo);
                  /*  Uri tempUri = getImageUri(ChatActivity.this, photo);
                    finalfile = new
                            File(getRealPathFromURI(tempUri));

                    Log.d("#####", "file1 " +
                            finalfile);*/
                    try {
                        sendChatRequest();
                    } catch
                    (FileNotFoundException e) {
                        e.printStackTrace();
                    }
// setImg.setImageBitmap(photo);
// setImg.setVisibility(View.VISIBLE);

                }
                break;

        }
    }

    public void sendChatRequest() throws
            FileNotFoundException {

        final RequestParams params = new
                RequestParams();

        params.put("comment", edit_msg.getText().toString());
        params.put("user_id", MyPrefrence.getInstance(ChatActivity.this).GetUser_ID());
        params.put("user_type", MyPrefrence.getInstance(ChatActivity.this).GETEMPROLE());
        params.put("ticket_id", "1");
        if (finalfile != null) {
            params.put("img", finalfile);
        } else {
            params.put("img", "");
        }


        Log.e("ParmaCreate", ">>>>" + params);
        webServices.post("Mobapp_API.php?action=CHAT_HISTORY", params, new JsonHttpResponseHandler() {
                    @Override
                    public void onStart() {

                        super.onStart();

                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode,
                                headers, response);
                        Log.e("create", ">>>>" +
                                response);

                        try {
                            JSONObject obj = new
                                    JSONObject(String.valueOf(response));

                            String status = obj.getString("Status");

                            if
                            (status.equalsIgnoreCase("1")) {

                                JSONArray array = obj.getJSONArray("TicketLogHistory");
                                data1.clear();
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject object =
                                            array.getJSONObject(i);
                                    chatpojo pojo =
                                            new chatpojo();

                                    pojo.setUserType(object.getString("UserType"));
                                    pojo.setMessage(object.getString("Message"));
                                    pojo.setImage(object.getString("Image"));
                                    pojo.setId(object.getString("id"));
                                    pojo.setUserID(object.getString("UserID"));
                                    data1.add(pojo);
                                    edit_msg.setText("");
                                    finalfile = null;

                                    LinearLayoutManager
                                            layoutManager = new
                                            LinearLayoutManager(getApplicationContext(),
                                            LinearLayoutManager.VERTICAL, false);
// layoutManager.setStackFromEnd(true);
                                    layoutManager.setStackFromEnd(true);
                                    chatboatRecy.setLayoutManager(layoutManager);
                                    chatboatRecy.setAdapter(new
                                            ChatBotAdapter(ChatActivity.this, data1));

                                }

                            } else {
                                String msg = obj.getString("Message");

                                Toast.makeText(ChatActivity.this, msg, Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();

                            Toast.makeText(ChatActivity.this, "catch", Toast.LENGTH_SHORT).show();
                        }

                    }


                }
        );
    }


}
