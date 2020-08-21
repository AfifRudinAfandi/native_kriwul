package com.build.delivery;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.build.delivery.adapter.RecyclerViewAdapterMenu;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailMerchants extends AppCompatActivity {
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_merchants);

        getIncomingIntent();

        initImageBitmaps();

        FrameLayout btnBack = findViewById(R.id.back_detail_outlate);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initImageBitmaps(){


        mImageUrls.add("https://i.ibb.co/6tTxpgd/img5.jpg");
        mNames.add("Kriwul Sambel");
        mPrice.add("Rp 16k");

        mImageUrls.add("https://i.ibb.co/DM1s7F4/img6.jpg");
        mNames.add("Kriwul Geprek");
        mPrice.add("Rp 8k-10k");

        mImageUrls.add("https://i.ibb.co/Zfs8kDw/img7.jpg");
        mNames.add("Es Lemon Tea");
        mPrice.add("Rp 5k");

        mImageUrls.add("https://i.ibb.co/L9KsNQ1/img8.jpg");
        mNames.add("Kriwul Original");
        mPrice.add("Rp 14k");

        mImageUrls.add("https://i.ibb.co/6tTxpgd/img5.jpg");
        mNames.add("Kriwul Sambel");
        mPrice.add("Rp 16k");

        mImageUrls.add("https://i.ibb.co/DM1s7F4/img6.jpg");
        mNames.add("Kriwul Geprek");
        mPrice.add("Rp 8k-10k");

        mImageUrls.add("https://i.ibb.co/Zfs8kDw/img7.jpg");
        mNames.add("Es Lemon Tea");
        mPrice.add("Rp 5k");

        mImageUrls.add("https://i.ibb.co/L9KsNQ1/img8.jpg");
        mNames.add("Kriwul Original");
        mPrice.add("Rp 14k");

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_recommend);
        RecyclerViewAdapterMenu adapter = new RecyclerViewAdapterMenu(this, mNames, mImageUrls, mPrice);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name") && getIntent().hasExtra("rating")){

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String ratingCount = getIntent().getStringExtra("rating");

            setImage(imageUrl, imageName, ratingCount);
        }
    }


    private void setImage(String imageUrl, String imageName, String ratingCount){

        TextView name = findViewById(R.id.image_description_outlate);
        name.setText(imageName);
        TextView rating = findViewById(R.id.detail_rating);
        rating.setText(ratingCount);

        ImageView image = findViewById(R.id.image_detail_outlate);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}