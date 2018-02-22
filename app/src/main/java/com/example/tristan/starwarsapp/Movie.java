package com.example.tristan.starwarsapp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Tristan on 2/17/18.
 */

public class Movie {
    public String title;
    public String imageUrl;
    public String main_characters;
    public String description;
    public String episode_number;
    public String hasSeen;

    public static ArrayList<Movie>getMoviesFromFile(String filename, Context context){
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        try{
            String jsonString = loadJsonFromAsset("movies.json", context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray movies = json.getJSONArray("movies");

            // for loop to go through each recipe in your recipes array

            for (int i = 0; i < movies.length(); i++){
                Movie movie = new Movie();
                movie.title = movies.getJSONObject(i).getString("title");
                movie.description = movies.getJSONObject(i).getString("description");
                movie.imageUrl = movies.getJSONObject(i).getString("poster");
                movie.main_characters = movies.getJSONObject(i).getString("main_characters");
                movie.episode_number = movies.getJSONObject(i).getString("episode_number");

                // add to arraylist
                movieList.add(movie);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movieList;
    }


    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }

}

