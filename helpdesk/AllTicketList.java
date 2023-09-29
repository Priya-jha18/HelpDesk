package com.amysoftech.helpdesk;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.amysoftech.helpdesk.adapter.AllTicketAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllTicketList extends AppCompatActivity {

    RecyclerView list_recy;
    String ticket_type = "";
    ArrayList<AllTicketPojo> data = new ArrayList<>();
    String auth = "";
    ImageView back_images;
    TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_ticket_list_);
        back_images = findViewById(R.id.back_images);
        title = findViewById(R.id.title);
        list_recy = findViewById(R.id.list_recy);
        list_recy.setHasFixedSize(true);
        list_recy.setLayoutManager(new LinearLayoutManager(AllTicketList.this));
        list_recy.setItemAnimator(new DefaultItemAnimator());
        auth = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMTIzNDU2Nzg5Iiwicm9sZSI6ImFhYWFhYWFhYWFhYWFhYWFhYSIsImV4cCI6MTY4MzEwOTk0OX0.Q8g55vg4mF7njqb2sNaPgzI39Tu-c_VeJH1wmNMUwZk";
        ticket_type = getIntent().getStringExtra("ticket_type");

        if (ticket_type.equalsIgnoreCase("")){
            title.setText("All Ticket");
        }else {
            title.setText(ticket_type+" Ticket");
        }
        getTicketList();

        back_images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    public void getTicketList() {
        ApiServices apiServices = RetrofitHelper.getRetrofitInstance().create(ApiServices.class);

        try {
            apiServices.getTicketList("2", "3", ticket_type, auth)
                    .enqueue(new Callback<AllTicketModel>() {
                        @Override
                        public void onResponse(Call<AllTicketModel> call, Response<AllTicketModel> response) {
                            if (response.body().getStatus().equalsIgnoreCase("1")) {
                                data = response.body().getAllTicketList();
                                Log.d("######", ">>>>>>" + data.get(0).getIncidentID());
                                list_recy.setAdapter(new AllTicketAdapter(AllTicketList.this, data));
                            }
                        }

                        @Override
                        public void onFailure(Call<AllTicketModel> call, Throwable t) {

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
