package com.example.retrofitwithmvvm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitwithmvvm.model.Data;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder> {

    Context ctx;
    List<Data> dataList;

    public DataAdapter(Context ctx, List<Data> dataList) {
        this.ctx = ctx;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DataAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataHolder(LayoutInflater.from(ctx).inflate(R.layout.data_row,null));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DataAdapter.DataHolder holder, int position) {
        holder.txtName.setText(dataList.get(position).getFirst_name() + " " + dataList.get(position).getLast_name());
        holder.txtEmailId.setText(dataList.get(position).getEmail() + " " + dataList.get(position).getId());
        Glide.with(ctx).load(Uri.parse(dataList.get(position).getAvatar())).into(holder.imgAvatar);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder{

        TextView txtName, txtEmailId;
        ImageView imgAvatar;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtEmailId = itemView.findViewById(R.id.txt_email_id);
            imgAvatar = itemView.findViewById(R.id.img_avatar);
        }
    }
}
