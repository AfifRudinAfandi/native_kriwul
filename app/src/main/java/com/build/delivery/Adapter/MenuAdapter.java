package com.build.delivery.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.build.delivery.Model.Menu;
import com.build.delivery.R;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {


    private ArrayList<Menu> dataList;

    public MenuAdapter(ArrayList<Menu> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.txtMenu.setText(dataList.get(position).getMenu());
        holder.txtPrice.setText(dataList.get(position).getPrice());
        holder.txtRating.setText(dataList.get(position).getRating());
        holder.txtPeople.setText(dataList.get(position).getPeople());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{
        private TextView txtMenu,txtPrice, txtRating, txtPeople;

        public MenuViewHolder(View itemView) {
            super(itemView);
            txtMenu = (TextView) itemView.findViewById(R.id.menu);
            txtPrice = (TextView) itemView.findViewById(R.id.price);
            txtRating = (TextView) itemView.findViewById(R.id.rating);
            txtPeople = (TextView) itemView.findViewById(R.id.people);
        }
    }
}