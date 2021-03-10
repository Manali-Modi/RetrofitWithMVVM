package com.example.retrofitwithmvvm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitwithmvvm.databinding.DataRowBinding;
import com.example.retrofitwithmvvm.model.Data;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
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
        Data data = dataList.get(position);
        holder.getBinding().setVariable(BR.user_data,data);
        holder.getBinding().setAvatar(data.getAvatar());
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder{

        private final DataRowBinding binding;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public DataRowBinding getBinding(){
            return binding;
        }
    }
}
