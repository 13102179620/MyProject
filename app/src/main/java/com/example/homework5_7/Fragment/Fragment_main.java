package com.example.homework5_7.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.homework5_7.Adapter.HomeFragmentDishAdapter;
import com.example.homework5_7.Adapter.itemRecyclerViewAdapter_CitySelec;
import com.example.homework5_7.R;
import com.example.homework5_7.Util.DataUtil;


public class Fragment_main extends Fragment implements Fragment_CitySelect.OnCitySelectListener  {

    /**
     * @ClassName: Fragment_main
     * @Author SYT
     * @Description  main——activity中viewpager的第一个fragment，其中又包含一个子fragment fragment_city_select;
     * @Date 17:05 2019/6/13
     **/


    int[] Icons;
    String[] DishNames;
    String[] DishDescripes;
    String[] DishPrices;
    String[] DishNumsofSells;
    RecyclerView RecyclerViewMainFragmentDish;
    Fragment_CitySelect fragment_citySelect;
    Button btn_CitySelect;
    TextView textView_CityName;



    //empty construct()
    private Fragment_main() {
        // Required empty public constructor
    }




    //单例模式内部类
    private static  class Fragment_mainHolder{
        //静态内部类单例模式

        private static final Fragment_main instance = new Fragment_main();
    }

    //返回单例
    public static Fragment_main newInstance() {

        return Fragment_mainHolder.instance;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_main, container, false);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setOnListener();
        setAdapter();
    }


    //设置适配器
    private void setAdapter() {
        RecyclerViewMainFragmentDish.setAdapter(new HomeFragmentDishAdapter(getActivity(), DataUtil.getHomeFragmentDishList(Icons, DishNames, DishDescripes, DishPrices, DishNumsofSells)));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerViewMainFragmentDish.setLayoutManager(linearLayoutManager);
    }


    //绑定事件监视器
    private void setOnListener() {
        btn_CitySelect.setOnClickListener(new Fragment_main_listener());
        fragment_citySelect.setOnCitySelectListener(this);


    }



    //初始化组件
    private void initView() {
        Icons =new int[]{R.drawable.pro1,R.drawable.pro2,R.drawable.product3,R.drawable.product4,R.drawable.pro1,R.drawable.pro2,R.drawable.product3,R.drawable.product4};
        DishNames = new String[]{"牛排","地三鲜","松仁大虾","冷饮","羊排","海三鲜","松仁玉米","可乐"};
        DishDescripes =new String[]{"超值单人套餐,三十分钟极速配送","营养搭配，科学饮食更健康！","海的味道,我知道！","冰霜冷饮吃吃吃！","超值单人套餐,三十分钟极速配送","营养搭配，科学饮食更健康！","海的味道,我知道！","冰霜冷饮吃吃吃！"};
        DishPrices = new String[]{"39.3新用户一元抢~！","9.9新用户一元抢~！","19.9新用户一元抢~！","48.5新用户一元抢~！","39.3新用户一元抢~！","9.9新用户一元抢~！","19.9新用户一元抢~！","48.5新用户一元抢~！"};
        DishNumsofSells = new String[]{"已售：20份","已售：30份","已售：20份","已售：40份","已售：20份","已售：30份","已售：20份","已售：40份"};
        RecyclerViewMainFragmentDish = getView().findViewById(R.id.recyclerView_dish);
        fragment_citySelect = Fragment_CitySelect.newInstance();//城市选择界面（fragment）
        btn_CitySelect = getView().findViewById(R.id.btn_selecCity);
        textView_CityName = getView().findViewById(R.id.textView_slectCity);
        //将子fragment cityselect加入manager并隐藏
        getChildFragmentManager().beginTransaction().add(R.id.main_fragment_container, fragment_citySelect).hide(fragment_citySelect).commit();

    }




    // TODO: 2019/6/13  不起作用
    public Button getBtn_CitySelect() {
        return btn_CitySelect;
    }





    //Interface 回调method: 城市选择fragment内部接口，将点击事件返回，实现对城市标签的修改
    @Override
    public void onCitySelectClick(String CityName) {
        /**
         * @Author SYT
         * @Description fragment_citySelec中的回调接口方法实现，点击fragment_citySelec中的城市按钮后，回调该fragment中的此方法
         * @Date 15:48 2019/6/13
         * @Param  CityName: 有fragment_CitySelec中的自定义监听类中的onCitySelectClick传回参数
         * @return void
         **/

        //设置城市图标以及关闭选择fragment
        textView_CityName.setText(CityName);
        getChildFragmentManager().beginTransaction().hide(fragment_citySelect).commit();
    }









    //自定义事件监听类，fragment_main 中（不包括子fragment）的所有组件的监听事件有改监听类分发任务
    private class Fragment_main_listener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_selecCity:
                    getChildFragmentManager().beginTransaction().show(fragment_citySelect).commit();

            }
        }
    }
}
