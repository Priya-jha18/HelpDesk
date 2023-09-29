package com.amysoftech.helpdesk;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class ChatBotAdapter extends RecyclerView.Adapter<ChatBotAdapter.MyViewHolder> {

    Context context;
    ArrayList<chatpojo> historyViewPojos = new ArrayList<>();


    public ChatBotAdapter(Context context, ArrayList<chatpojo> historyViewPojos) {
        this.context = context;
        this.historyViewPojos = historyViewPojos;

        // this.suggestionListPojos = suggestionListPojos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_bot_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if (historyViewPojos.get(position).getUserID().equalsIgnoreCase(MyPrefrence.getInstance(context).GetUser_ID())) {
            holder.chat_user.setText(historyViewPojos.get(position).Message);
            holder.quetion.setVisibility(View.GONE);
        } else {
            holder.quetion.setText(historyViewPojos.get(position).Message);
            holder.chat_user.setVisibility(View.GONE);
        }


    }


    @Override
    public int getItemCount() {
        return historyViewPojos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView quetion, chat_user;

        CircleImageView char_image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            quetion = itemView.findViewById(R.id.quetion);
            chat_user = itemView.findViewById(R.id.chat_user);
        //    char_image = itemView.findViewById(R.id.char_image);

        }
    }


}
