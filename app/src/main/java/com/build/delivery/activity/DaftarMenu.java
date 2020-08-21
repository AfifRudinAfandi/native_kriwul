package com.build.delivery.activity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.build.delivery.R;
import com.build.delivery.adapter.RecyclerViewAdapterMenu;

import java.util.ArrayList;

public class DaftarMenu extends AppCompatActivity {

    private Button btnSemua,btnMakanan,btnMinuman,btnLain;

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_menu);

        changeColor(R.color.colorWhite);
        FrameLayout back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initComponent();
        initImageBitmaps();

    }

    public void changeColor(int resourseColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), resourseColor));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    private void initComponent() {
        btnSemua = findViewById(R.id.filter_semua);
        btnMakanan = findViewById(R.id.filter_makanan);
        btnMinuman = findViewById(R.id.filter_minuman);
        btnLain = findViewById(R.id.filter_lainnya);

        actionClickButton(btnSemua);

        btnSemua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionClickButton(v);
            }
        });
        btnMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionClickButton(v);
            }
        });
        btnMinuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionClickButton(v);
            }
        });
        btnLain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionClickButton(v);
            }
        });
    }

    private void actionClickButton(View view){
        // reset all
        btnSemua.setSelected(false);
        btnMakanan.setSelected(false);
        btnMinuman.setSelected(false);
        btnLain.setSelected(false);
        selectedButton(btnSemua);
        selectedButton(btnMakanan);
        selectedButton(btnMinuman);
        selectedButton(btnLain);

        // set one selected
        view.setSelected(true);
        selectedButton(view);
    }

    public void selectedButton(View view) {
        if (view instanceof Button) {
            Button b = (Button) view;
            if (b.isSelected()) {
                b.setTextColor(this.getResources().getColor(R.color.colorRed_2));
                b.getBackground().setColorFilter(Color.parseColor("#FFDEE3"), PorterDuff.Mode.SRC_ATOP);
            } else {
                b.setTextColor(this.getResources().getColor(R.color.colorGray));
                b.getBackground().setColorFilter(Color.parseColor("#E9E9E9"), PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    private void initImageBitmaps(){


        mImageUrls.add("https://i.ibb.co/5FwxsW2/img.jpg");
        mNames.add("Kriwul Sambel");
        mPrice.add("Rp 16k");

        mImageUrls.add("https://i.ibb.co/FzbXnFH/img2.jpg");
        mNames.add("Kriwul Geprek");
        mPrice.add("Rp 8k-10k");

        mImageUrls.add("https://i.ibb.co/zSSM7cf/img3.jpg");
        mNames.add("Es Lemon Tea");
        mPrice.add("Rp 5k");

        mImageUrls.add("https://i.ibb.co/j8vzGJR/img4.jpg");
        mNames.add("Kriwul Original");
        mPrice.add("Rp 14k");

        mImageUrls.add("https://i.ibb.co/5FwxsW2/img.jpg");
        mNames.add("Kriwul Sambel");
        mPrice.add("Rp 16k");

        mImageUrls.add("https://i.ibb.co/FzbXnFH/img2.jpg");
        mNames.add("Kriwul Geprek");
        mPrice.add("Rp 8k-10k");

        mImageUrls.add("https://i.ibb.co/zSSM7cf/img3.jpg");
        mNames.add("Es Lemon Tea");
        mPrice.add("Rp 5k");

        mImageUrls.add("https://i.ibb.co/j8vzGJR/img4.jpg");
        mNames.add("Kriwul Original");
        mPrice.add("Rp 14k");

        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapterMenu adapter = new RecyclerViewAdapterMenu(this, mNames, mImageUrls, mPrice);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }


}