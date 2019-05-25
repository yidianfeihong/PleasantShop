package com.example.ming.pleasantshop;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.ming.pleasantshop.bean.Tab;
import com.example.ming.pleasantshop.fragment.CartFragment;
import com.example.ming.pleasantshop.fragment.CategoryFragment;
import com.example.ming.pleasantshop.fragment.HomeFragment;
import com.example.ming.pleasantshop.fragment.HotFragment;
import com.example.ming.pleasantshop.fragment.MineFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {


    private LayoutInflater mLayoutInflater;
    private com.example.ming.pleasantshop.widge.FragmentTabHost mTabHost;
    private ArrayList<Tab> mTabs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
    }

    private void initTab() {

        Tab homeTab = new Tab(R.drawable.selector_icon_home, R.string.home, HomeFragment.class);
        Tab hotTab = new Tab(R.drawable.selector_icon_hot, R.string.hot, HotFragment.class);
        Tab categoryTab = new Tab(R.drawable.selector_icon_category, R.string.catagory, CategoryFragment.class);
        Tab cartTab = new Tab(R.drawable.selector_icon_cart, R.string.cart, CartFragment.class);
        Tab mineTab = new Tab(R.drawable.selector_icon_mine, R.string.mine, MineFragment.class);

        mTabs.add(homeTab);
        mTabs.add(hotTab);
        mTabs.add(categoryTab);
        mTabs.add(cartTab);
        mTabs.add(mineTab);

        mLayoutInflater = LayoutInflater.from(this);
        mTabHost = findViewById(R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.real_content);


        for (Tab tab : mTabs) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicators(tab));
            mTabHost.addTab(tabSpec, tab.getFragment(), null);
        }
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabHost.setCurrentTab(0);

    }

    private View buildIndicators(Tab tab) {
        View view = mLayoutInflater.inflate(R.layout.tab_indicator, null);
        ImageView icon = view.findViewById(R.id.icon_tab);
        TextView title = view.findViewById(R.id.txt_indicator);
        icon.setImageResource(tab.getIcon());
        title.setText(tab.getTitle());
        return view;
    }

}
