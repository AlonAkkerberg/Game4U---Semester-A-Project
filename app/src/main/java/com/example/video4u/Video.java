package com.example.video4u;

import java.io.Serializable;

public class Video implements Serializable {
    private int Photo;
    private String uri;
    private String FullName;
    private String Console;
    private String GameName;
    private String Year;
    private String Price;

    public Video(int photo, String fullname, String console, String gamename, String year, String price)
    {
        Photo = photo;
        FullName = fullname;
        Console = console;
        GameName = gamename;
        Year = year;
        Price = price;
        this.uri = null;

    }

    public int getPhoto()
    {
        return Photo;
    }

    public String getYear()
    {
        return Year;
    }

    public String getFullName()
    {
        return FullName ;
    }

    public String getConsole()
    {
        return Console;
    }

    public String getPrice()
    {
        return Price;
    }

    public String getGameName(){return GameName;}

    public String getUri() {
        return uri;
    }

}
