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

import com.build.delivery.Adapter.MenuAdapter;
import com.build.delivery.Adapter.OutletAdapter;
import com.build.delivery.Login;
import com.build.delivery.Model.Menu;
import com.build.delivery.Model.Outlet;
import com.build.delivery.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private OutletAdapter adapter;
    private MenuAdapter adaptermenu;
    private ArrayList<Outlet> outletArrayList;
    private ArrayList<Menu> menuArrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


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

        addData();
        addMenu();

        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        adapter = new OutletAdapter(outletArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view_menu);
        adaptermenu = new MenuAdapter(menuArrayList);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager2);
        recyclerView.setAdapter(adaptermenu);




        TextView allmenu = (TextView) root.findViewById(R.id.allmenu);
        allmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        });







        return root;
    }
    void addData(){
        outletArrayList = new ArrayList<>();
        outletArrayList.add(new Outlet("Ayam Kriwul - Sukorejo", "4,5", "(234)"));
        outletArrayList.add(new Outlet("Ayam Kriwul - Jetis", "4,8", "(320)"));
        outletArrayList.add(new Outlet("Ayam Kriwul - Sukorejo", "4,5", "(234)"));
        outletArrayList.add(new Outlet("Ayam Kriwul - Jetis", "4,8", "(320)"));
        outletArrayList.add(new Outlet("Ayam Kriwul - Sukorejo", "4,5", "(234)"));
        outletArrayList.add(new Outlet("Ayam Kriwul - Jetis", "4,8", "(320)"));
    }
    void addMenu(){
        menuArrayList = new ArrayList<>();
        menuArrayList.add(new Menu("Ayam Kriwul Original", "Rp. 10.000,-","4,5", "(234)"));
        menuArrayList.add(new Menu("Ayam Kriwul Sambel Make", "Rp. 15.000,-","4,5", "(234)"));
        menuArrayList.add(new Menu("Ayam Kriwul Original", "Rp. 10.000,-","4,5", "(234)"));
        menuArrayList.add(new Menu("Ayam Kriwul Sambel Make", "Rp. 15.000,-","4,5", "(234)"));
    }
}