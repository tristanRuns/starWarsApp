package com.example.tristan.starwarsapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=this;

        final ArrayList<Movie> movieList= Movie.getMoviesFromFile("movies.json", this);

        MovieAdapter adapter=new MovieAdapter(this, movieList);

         mListView=findViewById(R.id.movie_list_view);
         mListView.setAdapter(adapter);

         mListView.setOnItemClickListener( new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id){
                Movie selectedMovie = movieList.get(position);

                // create my intent package
                // add all the information needed for detail page
                // startActivity with that intent

                //explicit
                // from, to
                Intent detailIntent = new Intent(mContext, MovieDetailActivity.class);
                // put title and instruction URL
                // detailIntent.putExtra("title", selectedMovie.title);
                detailIntent.putExtra("title", selectedMovie.title);
                detailIntent.putExtra("description",selectedMovie.description);
                detailIntent.putExtra("poster",selectedMovie.imageUrl);

                startActivity(detailIntent);


            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){



    }
}

