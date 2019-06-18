package com.example.homework5_7.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.homework5_7.Entity.City;
import com.example.homework5_7.Fragment.Fragment_CitySelect;
import com.example.homework5_7.R;

import java.util.List;

public class itemRecyclerViewAdapter_CitySelec extends RecyclerView.Adapter<itemRecyclerViewAdapter_CitySelec.itemRecyclerAdapterHolder> {

    Context context;
    List<City> cityName;
    OnRecyclerCityItemClickListener onRecyclerCityItemClickListener;



    //定义一个自定义接口，又来暴露给外部fragment_main
    public interface OnRecyclerCityItemClickListener{
        public void oncityItemClick(View view , int position);
    }



    //定义一个public方法，将该接口暴露给外部
    public void setOnRecyclerCityItemClickListener(OnRecyclerCityItemClickListener onRecyclerCityItemClickListener) {
        this.onRecyclerCityItemClickListener = onRecyclerCityItemClickListener;//初始化接口
    }



    //construct()
    public itemRecyclerViewAdapter_CitySelec(Context context, List<City> cityName) {
        this.context = context;
        this.cityName = cityName;
    }




    @NonNull
    @Override
    public itemRecyclerAdapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.city_select_layout, null);

        //将外部实现类传给Holder,因为Holder实才真正接受用户的点击事件
        return new itemRecyclerAdapterHolder(view,onRecyclerCityItemClickListener);
    }



    @Override
    public void onBindViewHolder(@NonNull itemRecyclerAdapterHolder itemRecyclerAdapterHolder, int i) {
            itemRecyclerAdapterHolder.textViewCityName.setText(cityName.get(i).CityName);
    }




    @Override
    public int getItemCount() {
        return cityName!=null ?cityName.size() :0 ;
    }




    //内部类Holder ，实现Listener接口
    class itemRecyclerAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewCityName;
        View rootView;
        OnRecyclerCityItemClickListener mlistener;

        //construct()
        public itemRecyclerAdapterHolder(@NonNull View itemView , OnRecyclerCityItemClickListener mlistener) {
            //这里的mlistner参数 由Adapter中传入，是Adapter中的onRecyclerCityItemClickListener（orc），而这个orc是由外部实现类传入的实例

            super(itemView);
            this.mlistener = mlistener;
            itemView.setOnClickListener(this); //这里也是一个回调，回调了改Holder类下的onClick方法
            textViewCityName =(TextView) itemView.findViewById(R.id.RecyclerView_item_textView_city_name);
        }


        @Override
        public void onClick(View v) {
/*            这里的View v 是上面Holder构造器中的itemView, 所以它是一个线性布局
            一旦Recycler中的元素被点击,将会回调到mlistener所指的（fragment_CitySelect）类的方法（onCityItemClick）*/
            if(mlistener!=null){
                mlistener.oncityItemClick(v,getAdapterPosition());
            }
        }
    }



}




