package com.example.homework5_7.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.homework5_7.Entity.HomeFragmentDIsh;
import com.example.homework5_7.R;

import java.util.List;

public class HomeFragmentDishAdapter extends RecyclerView.Adapter<HomeFragmentDishViewHolder> {

    Context context;
    List<HomeFragmentDIsh> ItemList;

    public HomeFragmentDishAdapter(Context context, List<HomeFragmentDIsh> itemList) {
        this.context = context;
        ItemList = itemList;
    }

    @NonNull
    @Override
    public HomeFragmentDishViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_fragment_dish, viewGroup,false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new HomeFragmentDishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFragmentDishViewHolder homeFragmentDishViewHolder, int i) {
        homeFragmentDishViewHolder.Icon.setImageResource(ItemList.get(i).Icon);
        homeFragmentDishViewHolder.DishName.setText(ItemList.get(i).DishName);
        homeFragmentDishViewHolder.DishDiscripe.setText(ItemList.get(i).DishPrice);
        homeFragmentDishViewHolder.DishPrice.setText(ItemList.get(i).DishPrice);
        homeFragmentDishViewHolder.DishNumsofSells.setText(ItemList.get(i).DishNumsOfSell );
    }

    @Override
    public int getItemCount() {

        return ItemList!=null ? ItemList.size() : 0;
    }



}

class HomeFragmentDishViewHolder extends RecyclerView.ViewHolder{
    ImageView Icon;
    TextView DishName;
    TextView DishDiscripe;
    TextView DishPrice;
    TextView DishNumsofSells;

    public HomeFragmentDishViewHolder(@NonNull View itemView){
        super(itemView);
        Icon = (ImageView)itemView.findViewById(R.id.imageView);
        DishName = (TextView) itemView.findViewById(R.id.textView_DishName);
        DishDiscripe = (TextView) itemView.findViewById(R.id.textView_DishDiscripe);
        DishPrice = (TextView) itemView.findViewById(R.id.textView_DishPrice);
        DishNumsofSells = (TextView) itemView.findViewById(R.id.textView_NumofSell);
    }

}