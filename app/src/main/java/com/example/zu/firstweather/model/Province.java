package com.example.zu.firstweather.model;

/**
 * Created by zu on 2015/7/9.
 */
//the basic class which is the parent class of Province,City and County
public class Province
{
    protected int id;
    protected String name;
    protected String code;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id=id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code=code;
    }
}
