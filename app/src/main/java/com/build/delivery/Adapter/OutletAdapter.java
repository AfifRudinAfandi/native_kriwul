package com.build.delivery.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.build.delivery.Model.Outlet;
import com.build.delivery.R;

import java.util.ArrayList;

public class OutletAdapter extends RecyclerView.Adapter<OutletAdapter.OutletViewHolder> {


    private ArrayList<Outlet> dataList;

    public OutletAdapter(ArrayList<Outlet> dataList) {
        this.dataList = dataList;
    }

    @Override
    public OutletViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_outlate, parent, false);
        return new OutletViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OutletViewHolder holder, int position) {
        holder.txtOutlate.setText(dataList.get(position).getOutlate());
        holder.txtRating.setText(dataList.get(position).getRating());
        holder.txtPeople.setText(dataList.get(position).getPeople());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class OutletViewHolder extends RecyclerView.ViewHolder{
        private TextView txtOutlate, txtRating, txtPeople;

        public OutletViewHolder(View itemView) {
            super(itemView);
            txtOutlate = (TextView) itemView.findViewById(R.id.outlate);
            txtRating = (TextView) itemView.findViewById(R.id.rating);
            txtPeople = (TextView) itemView.findViewById(R.id.people);
        }
    }
}