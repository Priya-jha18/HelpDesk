package com.amysoftech.helpdesk.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.amysoftech.helpdesk.AllTicketPojo;
import com.amysoftech.helpdesk.EditTicket;
import com.amysoftech.helpdesk.R;

import java.util.ArrayList;

public class AllTicketAdapter extends RecyclerView.Adapter<AllTicketAdapter.MyViewHolder> {

    Context context;
    ArrayList<AllTicketPojo> data = new ArrayList<>();

    public AllTicketAdapter(Context context, ArrayList<AllTicketPojo> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_adapter, parent, false);

        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.req_id.setText(data.get(position).getIncidentID());
        holder.createdBy.setText(data.get(position).getCreatedBy());
        holder.createdAt.setText(data.get(position).getCreated_at());


        if (data.get(position).getPriority().equalsIgnoreCase("Severe")) {
            holder.prio_type.setText(data.get(position).getPriority());
            holder.prio_type.setBackgroundResource(R.drawable.severe);
        } else if (data.get(position).getPriority().equalsIgnoreCase("High")) {
            holder.prio_type.setText(data.get(position).getPriority());
            holder.prio_type.setBackgroundResource(R.drawable.high_color);
        } else if (data.get(position).getPriority().equalsIgnoreCase("Medium")) {
            holder.prio_type.setText(data.get(position).getPriority());
            holder.prio_type.setBackgroundResource(R.drawable.medium_backgroung);
        } else if (data.get(position).getPriority().equalsIgnoreCase("Low")) {
            holder.prio_type.setText(data.get(position).getPriority());
            holder.prio_type.setBackgroundResource(R.drawable.low_color_bg);
        }

        holder.cardviewALlTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, EditTicket.class);
                in.putExtra("Organization",data.get(position).getOrganizationName());
                in.putExtra("project",data.get(position).getProjectName());
                in.putExtra("process",data.get(position).getProcessName());
                in.putExtra("ticketpriority",data.get(position).getPriority());
                in.putExtra("department",data.get(position).getDepartmentName());
                in.putExtra("tickettype",data.get(position).getTicketType());
                in.putExtra("assigned",data.get(position).getAssignedName());
                in.putExtra("descrip",data.get(position).getDescription());
                in.putExtra("img",data.get(position).getUrl());
                in.putExtra("IncidentId",data.get(position).getIncidentID());
                context.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView req_id, prio_type, createdBy, createdAt;
        CardView cardviewALlTicket;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            req_id = itemView.findViewById(R.id.req_id);
            prio_type = itemView.findViewById(R.id.prio_type);
            createdBy = itemView.findViewById(R.id.createdBy);
            createdAt = itemView.findViewById(R.id.createdAt);
            cardviewALlTicket = itemView.findViewById(R.id.cardviewALlTicket);
        }
    }
}
