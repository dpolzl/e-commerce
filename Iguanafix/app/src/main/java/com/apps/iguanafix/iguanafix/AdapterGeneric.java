package com.apps.iguanafix.iguanafix;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.Collections;
import java.util.List;

public class AdapterGeneric extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataGeneric> data = Collections.emptyList();
    DataGeneric current;
    int currentPos = 0;

    public AdapterGeneric(Context context, List<DataGeneric> data){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_generic, parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyHolder myHolder = (MyHolder) holder;
        DataGeneric current = data.get(position);
        myHolder.textfirstName.setText(current.firstName);
        myHolder.textUserId.setText("User ID: " + current.userId);
        myHolder.textCreatedAt.setText("Create at: " + current.createdAt);
        myHolder.textBirthDate.setText("Birth Date: " + current.birthDate);
        myHolder.textBirthDate.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

        Glide.with(context).load("https://private-d0cc1-iguanafixtest.apiary-mock.com/contacts" + current.photoUrl)
                .placeholder(R.drawable.iguanafix)
                .error(R.drawable.iguanafix)
                .into(myHolder.caffeIguanafix);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView textUserId;
        TextView textCreatedAt;
        TextView textBirthDate;
        TextView textfirstName;
        TextView textLastName;
        TextView textPhones;
        TextView textThumb;
        TextView textPhoto;
        ImageView caffeIguanafix;

        public MyHolder(View itemView) {
            super(itemView);
            textfirstName = (TextView) itemView.findViewById(R.id.textfirstName);
            caffeIguanafix = (ImageView) itemView.findViewById(R.id.caffeIguanafix);
            textUserId = (TextView) itemView.findViewById(R.id.textUserId);
            textCreatedAt = (TextView) itemView.findViewById(R.id.textCreatedAt);
            textBirthDate = (TextView) itemView.findViewById(R.id.textBirthDate);
        }

    }

}
