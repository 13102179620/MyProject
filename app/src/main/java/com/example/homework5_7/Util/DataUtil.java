package com.example.homework5_7.Util;

import com.example.homework5_7.Entity.City;
import com.example.homework5_7.Entity.HomeFragmentDIsh;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    public static List<HomeFragmentDIsh> getHomeFragmentDishList(int[] Icons, String[] DishNames , String[] DishDiscrips , String[] DishPrices , String[] DishNumsofSells){
        /**
         * @Author SYT
         * @Description 为HomeFragment的dish RecyclerView的适配器创建所需的List
         * @Date 23:31 2019/6/11
         * @Param * @param Icons
         * @param DishNames
         * @param DishDiscrips
         * @param DishPrices
         * @param DishNumsofSells
         * @return java.util.List<com.example.homework5_7.Entity.HomeFragmentDIsh>
         **/

        List<HomeFragmentDIsh> res = new ArrayList<>();
        for (int i = 0; i < Icons.length ; i++) {
            HomeFragmentDIsh hfd = new HomeFragmentDIsh(Icons[i],DishNames[i],DishDiscrips[i],DishPrices[i],DishNumsofSells[i]);
            res.add(hfd);
        }
        return res;
    }


    public static List<City> getCityList(String[] cityNames){
        List<City> res = new ArrayList<>();
        for (int i = 0; i < cityNames.length ; i++) {
            res.add(new City(cityNames[i]));
        }
        return res;
    }

}
