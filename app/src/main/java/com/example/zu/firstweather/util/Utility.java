package com.example.zu.firstweather.util;

import android.text.TextUtils;

import com.example.zu.firstweather.db.FirstWeatherDB;
import com.example.zu.firstweather.model.City;
import com.example.zu.firstweather.model.County;
import com.example.zu.firstweather.model.Province;

/**
 * Created by zu on 2015/7/9.
 */
public class Utility
{
    public synchronized static boolean handleProvinceResponse(FirstWeatherDB db,String response)
    {
        if(!TextUtils.isEmpty(response))
        {
            String[] allProvinces=response.split(",");
            if(allProvinces!=null&&allProvinces.length>0)
            {
                for(String p:allProvinces)
                {
                    String[] array=p.split("\\|");
                    Province province=new Province();
                    province.setCode(array[0]);
                    province.setName(array[1]);
                    db.saveProvince(province);
                }
                return true;
            }

        }
        return false;
    }

    public static boolean handleCitiesResponse(FirstWeatherDB db,String response,int provinceId)
    {
        if(!TextUtils.isEmpty(response))
        {
            String[] allCities=response.split(",");
            if(allCities!=null&&allCities.length>0)
            {
                for(String c:allCities)
                {
                    String[] array=c.split("\\|");
                    City city=new City();
                    city.setCode(array[0]);
                    city.setName(array[1]);
                    city.setProvinceId(provinceId);
                    db.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean handleCountiesResponse(FirstWeatherDB db,String response,int cityId)
    {
        if(!TextUtils.isEmpty(response))
        {
            String[] allCounties=response.split(",");
            if(allCounties!=null&&allCounties.length>0)
            {
                for(String c:allCounties)
                {
                    String[] array=c.split("\\|");
                    County county=new County();
                    county.setCode(array[0]);
                    county.setName(array[1]);
                    county.setCityId(cityId);
                    db.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }
}
