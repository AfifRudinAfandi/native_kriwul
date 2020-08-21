package com.build.delivery.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.build.delivery.R;
import com.build.delivery.activity.DaftarMenu;
import com.build.delivery.adapter.RecyclerViewAdapterMenuBeranda;
import com.build.delivery.adapter.RecyclerViewAdapterMerchants;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private ArrayList<String> mRating = new ArrayList<>();
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);


//        SliderView sliderView = root.findViewById(R.id.imageSlider);
//
//        SliderAdapterExample adapter = new SliderAdapterExample(this);
//
//        sliderView.setSliderAdapter(adapter);
//
//        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
//        sliderView.setIndicatorSelectedColor(Color.WHITE);
//        sliderView.setIndicatorUnselectedColor(Color.GRAY);
//        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :

//        sliderView.startAutoCycle();

        TextView allmenu = root.findViewById(R.id.allmenu);
        allmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DaftarMenu.class);
                startActivity(intent);
            }
        });


        addOutlate();

        addMenu();

        return root;
    }



    private void addOutlate(){
        mImageUrls.add("https://i.ibb.co/6tTxpgd/img5.jpg");
        mNames.add("Ayam Kriwul Sukorejo");
        mRating.add("4,8 (374)");

        mImageUrls.add("https://i.ibb.co/DM1s7F4/img6.jpg");
        mNames.add("Ayam Kriwul Sukorejo");
        mRating.add("4,8 (374)");

        mImageUrls.add("https://i.ibb.co/Zfs8kDw/img7.jpg");
        mNames.add("Ayam Kriwul Sukorejo");
        mRating.add("4,8 (374)");

        mImageUrls.add("https://i.ibb.co/L9KsNQ1/img8.jpg");
        mNames.add("Ayam Kriwul Sukorejo");
        mRating.add("4,8 (374)");

        mImageUrls.add("https://i.ibb.co/6tTxpgd/img5.jpg");
        mNames.add("Ayam Kriwul Sukorejo");
        mRating.add("4,8 (374)");
        outlateRecycle();
    }


    private void addMenu(){
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

        menuRecycle();
    }

    private  void outlateRecycle(){
        RecyclerView recyclerOutlate = root.findViewById(R.id.recycler_outlate);
        recyclerOutlate.setLayoutManager(new LinearLayoutManager(this.getActivity(),LinearLayoutManager.HORIZONTAL,false));
        RecyclerViewAdapterMerchants adapter_outlate = new RecyclerViewAdapterMerchants(this.getActivity(), mNames, mImageUrls, mRating);
        recyclerOutlate.setAdapter(adapter_outlate);
    }
    private void menuRecycle (){
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(),LinearLayoutManager.HORIZONTAL,false));
        RecyclerViewAdapterMenuBeranda adapter = new RecyclerViewAdapterMenuBeranda(this.getActivity(), mNames, mImageUrls, mPrice);
        recyclerView.setAdapter(adapter);
    }
}