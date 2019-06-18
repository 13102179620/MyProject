package com.example.homework5_7.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.homework5_7.Adapter.itemRecyclerViewAdapter_CitySelec;
import com.example.homework5_7.R;
import com.example.homework5_7.Util.DataUtil;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_CitySelect.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_CitySelect#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_CitySelect extends Fragment implements  itemRecyclerViewAdapter_CitySelec.OnRecyclerCityItemClickListener{


    Button btn_beijing ;
    Button btn_tianjin;
    Button btn_shanghai;
    Button btn_nanjing;
    Button btn_suzhou;
    Button btn_wuhan;
    Button btn_guangzhou;
    Button btn_harbin;
    RecyclerView cityRecyclerView;
    String[] cityNamesArray;
    itemRecyclerViewAdapter_CitySelec citySelecAdapter ;
    private OnCitySelectListener mListener;




    //empty construct()
    public Fragment_CitySelect() {}





    // 返回实例
    public static Fragment_CitySelect newInstance() {
        Fragment_CitySelect fragment = new Fragment_CitySelect();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__city_select, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setListener();
        setAdapter();
    }


    //绑定适配器
    private void setAdapter() {

        cityRecyclerView.setAdapter(citySelecAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cityRecyclerView.setLayoutManager(linearLayoutManager);
    }


    //绑定监听器
    private void setListener() {
        btn_tianjin.setOnClickListener(new myListener(){});
        btn_beijing.setOnClickListener(new myListener(){});
        btn_shanghai.setOnClickListener(new myListener(){});
        btn_nanjing.setOnClickListener(new myListener(){});
        btn_suzhou.setOnClickListener(new myListener(){});
        btn_wuhan.setOnClickListener(new myListener(){});
        btn_guangzhou.setOnClickListener(new myListener(){});
        btn_harbin.setOnClickListener(new myListener(){});

        citySelecAdapter.setOnRecyclerCityItemClickListener(this);


    }


    //初始化组件
    private void initView() {
        btn_beijing = getView().findViewById(R.id.btn_beijing);
        btn_tianjin = getView().findViewById(R.id.btn_tianjin);
        btn_shanghai = getView().findViewById(R.id.btn_shanghai);
        btn_nanjing = getView().findViewById(R.id.btn_najing);
        btn_suzhou = getView().findViewById((R.id.btn_suzhou));
        btn_guangzhou = getView().findViewById(R.id.btn_guangzhou);
        btn_wuhan = getView().findViewById(R.id.btn_wuhan);
        btn_harbin = getView().findViewById(R.id.btn_harbin);
        cityNamesArray = getActivity().getResources().getStringArray(R.array.city_names);
        cityRecyclerView = getView().findViewById(R.id.recyclerView_selecCity_item_layout);
        citySelecAdapter = new itemRecyclerViewAdapter_CitySelec(getActivity(), DataUtil.getCityList(cityNamesArray));//初始化适配器

    }






    //Interface 回调method: 城市选择页面adapter中的自定义接口，用于将点击事件传递到fragment_main 实现对城市标签的修改
    @Override
    public void oncityItemClick(View view , int position) {
        /**
         * @Param view  position: 由itemRecyclerViewAdapter_CitySelec 类中的 onClick(View v , int position) 传入 ，代表被点击的组件(LinearLayout),以及其对应的位置
         **/

        //获取LinearLayout组件中的TextView 中的点击城市信息 ，通过实现上层接口的mListener（这里被赋值成了fragment_main）
        //传递回fragment_main
        TextView textView = ((LinearLayout)view).requireViewById(R.id.RecyclerView_item_textView_city_name);
        mListener.onCitySelectClick(textView.getText().toString());
        this.onDestroy();

    }




    //定义接口，用于与父fragment通信
    public interface OnCitySelectListener {
        void onCitySelectClick(String CityName);
    }






    //将接口暴露给外部（父fragment）
    public void setOnCitySelectListener(OnCitySelectListener onCitySelectListener){
        // 外部父 fragment_main 将作为onCitySelecListner对象传入，mListner就指向了fragment_main
        mListener = onCitySelectListener;
    }






    //自定义事件监听类，fragment_cityselect 中的所有按键（Button）的监听事件有改监听类分发任务
    private class myListener implements View.OnClickListener{

        /**
         * @ClassName: myListener
         * @Author SYT
         * @Description 城市选择页面中，城市按钮的监听类
         * @Date 16:28 2019/6/13
         **/


/*        这里的mListener一般情况是父fragment_main的引用（mlistener = mListener = onCitySelectListener）,
         在这里点击事件被回调到fragment_main(因为调用了fragment_main中的onClick方法)*/
        @Override
        public void onClick(View v) {
            if (mListener!=null){
                switch (v.getId()){
                    case R.id.btn_beijing:
                        mListener.onCitySelectClick("北京");
                        break;

                    case R.id.btn_tianjin:
                        mListener.onCitySelectClick("天津");
                        break;

                    case R.id.btn_najing:
                        mListener.onCitySelectClick("南京");
                        break;

                    case R.id.btn_shanghai:
                        mListener.onCitySelectClick("上海");
                        break;

                    case R.id.btn_suzhou:
                        mListener.onCitySelectClick("苏州");
                        break;

                    case R.id.btn_guangzhou:
                        mListener.onCitySelectClick("广州");
                        break;

                    case R.id.btn_wuhan:
                        mListener.onCitySelectClick("武汉");
                        break;

                    case R.id.btn_harbin:
                        mListener.onCitySelectClick("哈尔滨");
                        break;

                    default:
                        mListener.onCitySelectClick("北京");
                }
            }
        }




    }

}
