package com.example.homework5_7;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.homework5_7.Fragment.Fragment_CitySelect;
import com.example.homework5_7.Fragment.Fragment_main;
import com.example.homework5_7.Fragment.Fragment_me;
import com.example.homework5_7.Fragment.Fragment_shop;

public class MainActivity extends AppCompatActivity {
    private ViewPager fragmentContainer;
    private TabLayout tabs ;
    private Fragment_main fragment_main;
    private Fragment_shop fragment_shop;
    private Fragment_me fragment_me;
    private Fragment_CitySelect fragment_citySelect;
    Button btn_CitySelect;

    @Override
    protected void onStart() {
        super.onStart();

        //初始化fragment_main中的组件
        initFragmentView();

    }

    private void initFragmentView() {
        //城市选择按钮
        // TODO: 2019/6/13  这里的返回值一直为空，且在调试过程中发现onStart方法先于fragment.onActivitycreate()方法执行,这是不符合加载顺序的，请问这是为什么
        // TODO: 2019/6/13  虽然有其他方法完成城市选择页面的功能实现，但是还是想弄清楚上述问题的原因！
//        btn_CitySelect = fragment_main.getView().findViewById(R.id.btn_selecCity);
//        btn_CitySelect = fragment_main.getBtn_CitySelect();
//        btn_CitySelect.setOnClickListener(new Fragment_main_listener());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initView();
        setOnListener();

    }

    private void setOnListener() {

        //tabs 与 viewpager建立关联
        fragmentContainer.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(fragmentContainer));

        


    }

    private void initView() {

        fragmentContainer = findViewById(R.id.container);
        tabs = findViewById(R.id.tabs);
        fragment_me = Fragment_me.newInstance();
        fragment_main = Fragment_main.newInstance();
        fragment_shop = Fragment_shop.newInstance();


        final Fragment[] fragmentsList = new Fragment[]{fragment_main,fragment_shop,fragment_me};
        fragmentContainer.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentsList[i];
            }

            @Override
            public int getCount() {
                return fragmentsList.length;
            }
        });

    }



/*    private class Fragment_main_listener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_selecCity:
                    fragment_main.getFragmentManager().beginTransaction().hide(fragment_main);
                    fragment_main.getChildFragmentManager().beginTransaction()
                            .add(R.id.main_fragment_main_menu, fragment_citySelect).commit();

            }
        }
    }*/


}
