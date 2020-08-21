package com.build.delivery.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.build.delivery.R;
import com.build.delivery.activity.DetailMenu;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapterMenuBeranda extends RecyclerView.Adapter<RecyclerViewAdapterMenuBeranda.ViewHolder>{

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapterMenuBeranda(Context context, ArrayList<String> imageNames, ArrayList<String> images , ArrayList<String> price) {
        mImageNames = imageNames;
        mImages = images;
        mPrice = price;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.imageName.setText(mImageNames.get(position));
        holder.textPrice.setText(mPrice.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, DetailMenu.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mImageNames.get(position));
                intent.putExtra("price", mPrice.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView imageName;
        TextView textPrice;
        CardView parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_beranda_menu);
            imageName = itemView.findViewById(R.id.menu);
            textPrice = itemView.findViewById(R.id.price);
            parentLayout = itemView.findViewById(R.id.parent_menu);
        }
    }
}









