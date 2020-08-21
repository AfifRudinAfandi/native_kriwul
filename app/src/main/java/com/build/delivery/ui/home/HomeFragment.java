package com.build.delivery.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.build.delivery.R;
import com.build.delivery.activity.DaftarMenu;
import com.build.delivery.adapter.RecyclerViewAdapterMenuBeranda;
import com.build.delivery.adapter.RecyclerViewAdapterMerchants;
import com.build.delivery.model.Image;
import com.build.delivery.utils.Tools;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private ViewPager viewPager;
    private LinearLayout layout_dots;
    private AdapterImageSlider adapterImageSlider;
    private Runnable runnable = null;
    private Handler handler = new Handler();

    private static int[] array_image_place = {
            R.drawable.banner,
            R.drawable.banner,
            R.drawable.banner,
    };

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private ArrayList<String> mRating = new ArrayList<>();
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);


        TextView allmenu = root.findViewById(R.id.allmenu);
        allmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DaftarMenu.class);
                startActivity(intent);
            }
        });
        initComponent();

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




    private void initComponent() {
        layout_dots = (LinearLayout) root.findViewById(R.id.layout_dots);
        viewPager = (ViewPager) root.findViewById(R.id.pager);
        adapterImageSlider = new AdapterImageSlider(this.getActivity(), new ArrayList<Image>());

        final List<Image> items = new ArrayList<>();
        for (int i = 0; i < array_image_place.length; i++) {
            Image obj = new Image();
            obj.image = array_image_place[i];
            obj.imageDrw = getResources().getDrawable(obj.image);
            items.add(obj);
        }

        adapterImageSlider.setItems(items);
        viewPager.setAdapter(adapterImageSlider);

        // displaying selected image first
        viewPager.setCurrentItem(0);
        addBottomDots(layout_dots, adapterImageSlider.getCount(), 0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int pos, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int pos) {
                addBottomDots(layout_dots, adapterImageSlider.getCount(), pos);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        startAutoSlider(adapterImageSlider.getCount());
    }

    private void addBottomDots(LinearLayout layout_dots, int size, int current) {
        ImageView[] dots = new ImageView[size];

        layout_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this.getActivity());
            int width_height = 30;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(10, 0, 10, 0);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.shape_circle);
            dots[i].setColorFilter(ContextCompat.getColor(this.getActivity(), R.color.colorRed_0_3), PorterDuff.Mode.SRC_ATOP);
            layout_dots.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[current].setImageResource(R.drawable.shape_circle);
            dots[current].setColorFilter(ContextCompat.getColor(this.getActivity(), R.color.colorRed_2), PorterDuff.Mode.SRC_ATOP);
        }
    }

    private void startAutoSlider(final int count) {
        runnable = new Runnable() {
            @Override
            public void run() {
                int pos = viewPager.getCurrentItem();
                pos = pos + 1;
                if (pos >= count) pos = 0;
                viewPager.setCurrentItem(pos);
                handler.postDelayed(runnable, 4000);
            }
        };
        handler.postDelayed(runnable, 4000);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().finish();
        } else {
        }
        return super.onOptionsItemSelected(item);
    }


    private static class AdapterImageSlider extends PagerAdapter {

        private Activity act;
        private List<Image> items;

        private AdapterImageSlider.OnItemClickListener onItemClickListener;

        private interface OnItemClickListener {
            void onItemClick(View view, Image obj);
        }

        public void setOnItemClickListener(AdapterImageSlider.OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        // constructor
        private AdapterImageSlider(Activity activity, List<Image> items) {
            this.act = activity;
            this.items = items;
        }

        @Override
        public int getCount() {
            return this.items.size();
        }

        public Image getItem(int pos) {
            return items.get(pos);
        }

        public void setItems(List<Image> items) {
            this.items = items;
            notifyDataSetChanged();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            final Image o = items.get(position);
            LayoutInflater inflater = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.item_slider_image, container, false);

            ImageView image = (ImageView) v.findViewById(R.id.image);
            Tools.displayImageOriginal(act, image, o.image);

            ((ViewPager) container).addView(v);

            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((RelativeLayout) object);

        }

    }

    @Override
    public void onDestroy() {
        if (runnable != null) handler.removeCallbacks(runnable);
        super.onDestroy();
    }
}