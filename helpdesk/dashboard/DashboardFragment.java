package com.amysoftech.helpdesk.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


import com.amysoftech.helpdesk.AllTicketList;
import com.amysoftech.helpdesk.ApiServices;
import com.amysoftech.helpdesk.CreateTicket;
import com.amysoftech.helpdesk.R;
import com.amysoftech.helpdesk.RetrofitHelper;
import com.amysoftech.helpdesk.dashboard.dashboard_model.DashboardModel;
import com.amysoftech.helpdesk.dashboard.pojo.DashboardPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {
    String auth = "";
    ImageView ticketImage;
    ArrayList<DashboardPojo> data = new ArrayList<>();
    TextView sever_count, high_count, medium_count, low_count, all_ticket_count, in_review_count,
            created_count, awaiting_client_count, closed_by_cust_count, closed_by_suppo_count;
    LinearLayout linear_Severe, linear_high, linear_medium, linear_low;
    CardView all_ticket_CardView, in_review_card, created_card, awaiting_client_cardView,
            closed_by_suppo_cardView, closed_by_cust_cardView;
    RelativeLayout relativeCreateTicket;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.dashboard_fragment, container, false);

        sever_count = root.findViewById(R.id.sever_count);
        high_count = root.findViewById(R.id.high_count);
        medium_count = root.findViewById(R.id.medium_count);
        ticketImage = root.findViewById(R.id.ticketImage);
        low_count = root.findViewById(R.id.low_count);
        all_ticket_count = root.findViewById(R.id.all_ticket_count);
        in_review_count = root.findViewById(R.id.in_review_count);
        created_count = root.findViewById(R.id.created_count);
        relativeCreateTicket=root.findViewById(R.id.relativeCreateTicket);
        awaiting_client_count = root.findViewById(R.id.awaiting_client_count);
        closed_by_cust_count = root.findViewById(R.id.closed_by_cust_count);
        closed_by_suppo_count = root.findViewById(R.id.closed_by_suppo_count);
        linear_Severe = root.findViewById(R.id.linear_Severe);
        linear_high = root.findViewById(R.id.linear_high);
        linear_medium = root.findViewById(R.id.linear_medium);
        linear_low = root.findViewById(R.id.linear_low);
        all_ticket_CardView = root.findViewById(R.id.all_ticket_CardView);
        in_review_card = root.findViewById(R.id.in_review_card);
        created_card = root.findViewById(R.id.created_card);
        awaiting_client_cardView = root.findViewById(R.id.awaiting_client_cardView);
        closed_by_suppo_cardView = root.findViewById(R.id.closed_by_suppo_cardView);
        closed_by_cust_cardView = root.findViewById(R.id.closed_by_cust_cardView);
        auth = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMTIzNDU2Nzg5Iiwicm9sZSI6ImFhYWFhYWFhYWFhYWFhYWFhYSIsImV4cCI6MTY4MzEwOTk0OX0.Q8g55vg4mF7njqb2sNaPgzI39Tu-c_VeJH1wmNMUwZk";
        relativeCreateTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), CreateTicket.class);
                startActivity(i);
            }
        });

        linear_Severe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), AllTicketList.class);
                in.putExtra("ticket_type", "Severe");
                startActivity(in);
            }
        });

        linear_high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), AllTicketList.class);
                in.putExtra("ticket_type", "High");
                startActivity(in);
            }
        });
        linear_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), AllTicketList.class);
                in.putExtra("ticket_type", "Medium");
                startActivity(in);
            }
        });
        linear_low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), AllTicketList.class);
                in.putExtra("ticket_type", "Low");
                startActivity(in);
            }
        });
        all_ticket_CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), AllTicketList.class);
                in.putExtra("ticket_type", "");

                startActivity(in);
            }
        });
        in_review_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), AllTicketList.class);
                in.putExtra("ticket_type", "In-Review");

                startActivity(in);
            }
        });
        created_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), AllTicketList.class);
                in.putExtra("ticket_type", "Created");
                startActivity(in);
            }
        });
        awaiting_client_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), AllTicketList.class);
                in.putExtra("ticket_type", "Awaiting By Client");
                startActivity(in);
            }
        });
        closed_by_suppo_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), AllTicketList.class);
                in.putExtra("ticket_type", "Closed By Support");
                startActivity(in);
            }
        });
        closed_by_cust_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), AllTicketList.class);
                in.putExtra("ticket_type", "Closed By Customer");
                startActivity(in);
            }
        });
        getDashboard();

        return root;
    }


    void getDashboard() {
        ApiServices apiServices = RetrofitHelper.getRetrofitInstance().create(ApiServices.class);

        try {
            apiServices.getDashboard("2", "3", auth)
                    .enqueue(new Callback<DashboardModel>() {
                        @Override
                        public void onResponse(Call<DashboardModel> call, Response<DashboardModel> response) {
                            if (response.body().getStatus().equalsIgnoreCase("1")) {

                                data = response.body().getDashboardStatusList();
                                sever_count.setText(data.get(0).getKeyCount());
                                high_count.setText(data.get(1).getKeyCount());
                                medium_count.setText(data.get(2).getKeyCount());
                                low_count.setText(data.get(3).getKeyCount());
                                all_ticket_count.setText(data.get(4).getKeyCount());
                                in_review_count.setText(data.get(5).getKeyCount());
                                created_count.setText(data.get(6).getKeyCount());
                                awaiting_client_count.setText(data.get(7).getKeyCount());
                                closed_by_suppo_count.setText(data.get(8).getKeyCount());
                                closed_by_cust_count.setText(data.get(9).getKeyCount());
                                Log.d("#############", "hds" + data.get(0).getKeyName());
                               /* for (int i = 0; i < data.size(); i++) {

                                }*/

                            }
                        }

                        @Override
                        public void onFailure(Call<DashboardModel> call, Throwable t) {

                        }
                    });
        } catch (Exception e) {

        }
    }
}
