package com.example.zu.firstweather.util;

/**
 * Created by zu on 2015/7/9.
 */
public interface HttpCallbackListener
{
    void onFinish(String response);
    void onError(Exception e);
}
