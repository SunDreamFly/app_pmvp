package com.example.app_pmvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app_pmvp.R;
import com.example.app_pmvp.bean.HomeBean;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    private ArrayList<HomeBean.DataDTO> list;
    private Context context;

    public HomeAdapter(ArrayList<HomeBean.DataDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        holder.tv.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getPic()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder{
        TextView tv;
        ImageView iv;
        public HomeHolder(@NonNull View itemView) {
            super(itemView);
             tv = itemView.findViewById(R.id.tv_home);
             iv = itemView.findViewById(R.id.iv_home);
        }
    }
}
