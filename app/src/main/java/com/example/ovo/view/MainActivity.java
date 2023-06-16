package com.example.ovo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.load.engine.Resource;
import com.example.ovo.R;
import com.example.ovo.adapter.ChipAdapter;
import com.example.ovo.adapter.FragmentAdapter;
import com.example.ovo.adapter.MenuFinanceAdapter;
import com.example.ovo.adapter.SliderPagerAdapter;
import com.example.ovo.databinding.ActivityMainBinding;
import com.example.ovo.helper.BannerSlider;
import com.example.ovo.helper.SliderIndicator;
import com.example.ovo.model.MenuItem;
import com.example.ovo.view.fragment.FragmentSlider;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView chipView;
    private ViewPager2 viewPager;
    private FragmentAdapter fragmentAdapter;

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private LinearLayout mLinearLayout;


    private BannerSlider bannerSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        bannerSlider = findViewById(R.id.sliderView);
        mLinearLayout = findViewById(R.id.pagesContainer);
        setupSlider();

        RecyclerView recyclerView = binding.recyclerviewFinance;
        chipView = binding.mainMenu;
        viewPager = binding.viewPager;

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<MenuItem> data = new ArrayList<>();
        data.add(new MenuItem("Top Up", R.drawable.baseline_blur_circular_24));
        data.add(new MenuItem("Transfer", R.drawable.baseline_blur_circular_24));
        data.add(new MenuItem("Tarik Tunai", R.drawable.baseline_blur_circular_24));
        data.add(new MenuItem("History", R.drawable.baseline_blur_circular_24));

        MenuFinanceAdapter adapter = new MenuFinanceAdapter(this, data);
        recyclerView.setAdapter(adapter);

        recyclerView.post(() -> adapter.justifyItems(recyclerView));

        String[] itemList = {"Favorit", "Pilihan Lain", "Grab", "Finansial"};

        ChipAdapter chipAdapter = new ChipAdapter(itemList, viewPager);
        chipView.setAdapter(chipAdapter);
        LinearLayoutManager chipManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        chipView.setLayoutManager(chipManager);

        fragmentAdapter = new FragmentAdapter(this, itemList.length);
        viewPager.setAdapter(fragmentAdapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                chipAdapter.setSelectedItem(position);
                chipView.smoothScrollToPosition(position);
            }
        });
    }
    private void setupSlider() {
        bannerSlider.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();

        //link image
        fragments.add(FragmentSlider.newInstance("https://ecs7.tokopedia.net/img/banner/2020/4/19/85531617/85531617_17b56894-2608-4509-a4f4-ad86aa5d3b62.jpg"));
        fragments.add(FragmentSlider.newInstance("https://ecs7.tokopedia.net/img/banner/2020/4/19/85531617/85531617_7da28e4c-a14f-4c10-8fec-845578f7d748.jpg"));
        fragments.add(FragmentSlider.newInstance("https://ecs7.tokopedia.net/img/banner/2020/4/18/85531617/85531617_87a351f9-b040-4d90-99f4-3f3e846cd7ef.jpg"));
        fragments.add(FragmentSlider.newInstance("https://ecs7.tokopedia.net/img/banner/2020/4/20/85531617/85531617_03e76141-3faf-45b3-8bcd-fc0962836db3.jpg"));

        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        bannerSlider.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, bannerSlider, R.drawable.indicator);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}

