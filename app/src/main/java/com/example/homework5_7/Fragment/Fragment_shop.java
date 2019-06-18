package com.example.homework5_7.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.homework5_7.Adapter.HomeFragmentDishAdapter;
import com.example.homework5_7.R;
import com.example.homework5_7.Util.DataUtil;


public class Fragment_shop extends Fragment {

    TextView textViewWaiDi;
    TextView textViewBenDi;
    TextView textViewMoRen;
    RecyclerView recyclerViewContainer;
    String[] waiDi_Dish;
    String[] benDi_Dish;
    String[] moRen_Dish;
    String[] DishDescripes;
    String[] DishPrices;
    String[] DishNumsofSells;
    int[] Icons;


    //Empty construct()
    public Fragment_shop() {}




    public static Fragment_shop newInstance() {
        Fragment_shop fragment = new Fragment_shop();

        return fragment;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_shop, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setOnListener();
    }



    private void setOnListener() {
        textViewMoRen.setOnClickListener(new Fragment_shop_ClickListener());
        textViewBenDi.setOnClickListener(new Fragment_shop_ClickListener());
        textViewWaiDi.setOnClickListener(new Fragment_shop_ClickListener());
    }

    private void initView() {
        textViewWaiDi = getView().findViewById(R.id.tabs_waidi);
        textViewBenDi = getView().findViewById(R.id.tabs_bendi);
        textViewMoRen = getView().findViewById(R.id.tabs_moren);
        recyclerViewContainer = getView().findViewById(R.id.fragment_shop_recyclerContainer);
        waiDi_Dish = new String[]{"牛排" ,"地三鲜","松仁大虾","冷饮","牛排" ,"地三鲜","松仁大虾","冷饮"};
        benDi_Dish = new String[]{"羊排" ,"海三鲜","松仁玉米","热饮","羊排" ,"海三鲜","松仁玉米","热饮"};
        moRen_Dish = new String[]{"炸鸡" ,"烤串","汉堡","可乐","炸鸡" ,"烤串","汉堡","可乐"};
        DishDescripes =new String[]{"超值单人套餐,三十分钟极速配送","营养搭配，科学饮食更健康！","超值单人套餐,三十分钟极速配送","营养搭配，科学饮食更健康！","海的味道,我知道！","冰霜冷饮吃吃吃！","海的味道,我知道！","冰霜冷饮吃吃吃！"};
        DishPrices = new String[]{"39.3新用户一元抢~！","9.9新用户一元抢~！","19.9新用户一元抢~！","48.5新用户一元抢~！","39.3新用户一元抢~！","9.9新用户一元抢~！","19.9新用户一元抢~！","48.5新用户一元抢~！"};
        DishNumsofSells = new String[]{"已售：20份","已售：30份","已售：20份","已售：40份","已售：20份","已售：30份","已售：20份","已售：40份"};
        Icons =new int[]{R.drawable.pro1,R.drawable.pro1,R.drawable.pro2,R.drawable.product3,R.drawable.pro2,R.drawable.product3,R.drawable.product4,R.drawable.product4};
    }

    private class Fragment_shop_ClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tabs_waidi:
                    textViewWaiDi.setTextColor(Color.parseColor("#FFA500"));
                    textViewBenDi.setTextColor(Color.BLACK);
                    textViewMoRen.setTextColor(Color.BLACK);
                    HomeFragmentDishAdapter waidiAdapter = new HomeFragmentDishAdapter(getActivity(),
                            DataUtil.getHomeFragmentDishList(Icons,waiDi_Dish,DishDescripes,DishPrices, DishNumsofSells));
                    recyclerViewContainer.setAdapter(waidiAdapter);
                    LinearLayoutManager waidi_linearLayoutManager  = new LinearLayoutManager(getActivity());
                    waidi_linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerViewContainer.setLayoutManager(waidi_linearLayoutManager);
                    break;

                case R.id.tabs_bendi:
                    textViewBenDi.setTextColor(Color.parseColor("#FFA500"));
                    textViewWaiDi.setTextColor(Color.BLACK);
                    textViewMoRen.setTextColor(Color.BLACK);
                    HomeFragmentDishAdapter bendiAdapter = new HomeFragmentDishAdapter(getActivity(),
                            DataUtil.getHomeFragmentDishList(Icons,benDi_Dish,DishDescripes,DishPrices, DishNumsofSells));
                    recyclerViewContainer.setAdapter(bendiAdapter);
                    LinearLayoutManager bendi_linearLayoutManager  = new LinearLayoutManager(getActivity());
                    bendi_linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerViewContainer.setLayoutManager(bendi_linearLayoutManager);
                    break;

                case R.id.tabs_moren:
                    textViewMoRen.setTextColor(Color.parseColor("#FFA500"));
                    textViewWaiDi.setTextColor(Color.BLACK);
                    textViewBenDi.setTextColor(Color.BLACK);
                    HomeFragmentDishAdapter morenAdapter = new HomeFragmentDishAdapter(getActivity(),
                            DataUtil.getHomeFragmentDishList(Icons,moRen_Dish,DishDescripes,DishPrices, DishNumsofSells));
                    recyclerViewContainer.setAdapter(morenAdapter);
                    LinearLayoutManager moren_linearLayoutManager  = new LinearLayoutManager(getActivity());
                    moren_linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerViewContainer.setLayoutManager(moren_linearLayoutManager);
                    break;
            }
        }
    }
}
