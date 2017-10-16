package com.example.jsondata;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jsondata.model.User;

import java.util.ArrayList;

/**
 * Created by 정인섭 on 2017-10-16.
 */

public class MyAdapter extends RecyclerView.Adapter<Holder>{
    ArrayList<User> list;
    Context context;
    public MyAdapter(ArrayList<User> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tvLogin.setText(list.get(position).getLogin());
        holder.tvID.setText(list.get(position).getId()+"");
        Glide.with(context).load(list.get(position).getAvatar_url()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

}

class Holder extends RecyclerView.ViewHolder{
    TextView tvID, tvLogin;
    ImageView imageView;

    public Holder(View view) {
        super(view);
        tvID = view.findViewById(R.id.tvID);
        tvLogin = view.findViewById(R.id.tvLogin);
        imageView = view.findViewById(R.id.imageView);
    }
}
