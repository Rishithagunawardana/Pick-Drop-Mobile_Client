package com.example.pickdrop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<User> list;


    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v  = LayoutInflater.from(context).inflate(R.layout.activity_item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user = list.get(position);
        holder.Passenger_name.setText(user.getPassenger_name());
        holder.Trip_Status.setText(user.getTrip_Status());
        holder.Vehicle_Type.setText(user.getVehicle_Type());
        holder.Fee.setText(user.getFee());
        holder.Driver_Name.setText(user.getDriver_Name());
        holder.Driver_Mobile_No.setText(user.getDriver_Mobile_No());





        holder.PAY.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent start = new Intent(context,payment.class);
                context.startActivity(start);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView  Passenger_name,Trip_Status,Vehicle_Type,Fee,Driver_Name,Driver_Mobile_No;
        Button PAY;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           Passenger_name  = itemView.findViewById(R.id.pname);
           Trip_Status  = itemView.findViewById(R.id.ststus);
            Vehicle_Type = itemView.findViewById(R.id.vtype);
            Fee = itemView.findViewById(R.id.fee);
            Driver_Name = itemView.findViewById(R.id.Dname);
            Driver_Mobile_No= itemView.findViewById(R.id.Dmobile);
            PAY = itemView.findViewById(R.id.pay);
        }
    }

}
