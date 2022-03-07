package com.example.video4u;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataPersistencyHelper
{

    public static Context Context;

    public static void StoreData(List<Video> VideoList)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        SharedPreferences.Editor editor = sp.edit();
        String json = new Gson().toJson(VideoList);
        editor.putString("VideoList", json);
        editor.commit();
    }

    public static List<Video> LoadData()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Context);
        String json = sp.getString("VideoList", null);
        if (json != null) {
            Type type = new TypeToken<List<Video>>() {}.getType();
            return new Gson().fromJson(json, type);
        }
        else
        {
            List<Video> VideoList = new ArrayList<Video>();
            VideoList.add(new Video(R.drawable.video1, "Yotam Gos", "PS4", "God Of War", "2018", "50$"));
            VideoList.add(new Video(R.drawable.video2, "Dekel Vaknin", "PS4", "Spider-Man", "2017", "30$"));
            VideoList.add(new Video(R.drawable.video3, "Nir Mascit", "PS4", "Guardians Of The Galaxy", "2018", "40$"));
            VideoList.add(new Video(R.drawable.video4, "Bar Chen", "PS4", "Crash Bandicoot", "2018", "30$"));
            VideoList.add(new Video(R.drawable.video5, "Mor Levi", "PS4", "Fortnite", "2016", "20$"));
            VideoList.add(new Video(R.drawable.video6, "Or Dov", "PS4", "Marvel Avengers", "2021", "60$"));
            VideoList.add(new Video(R.drawable.video7, "Eden Maor", "PS4 ", "Jumanji", "2020", "55$"));
            VideoList.add(new Video(R.drawable.video8, "Yuval Coseff", "PS4", "Fast and Furious", "2017", "30$"));

            return VideoList;
        }
    }

}
