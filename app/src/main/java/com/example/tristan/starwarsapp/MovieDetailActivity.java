package com.example.tristan.starwarsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

import static com.example.tristan.starwarsapp.R.id.posterView;
import static com.example.tristan.starwarsapp.R.id.submitButton;

/**
 * Created by Tristan on 2/19/18.
 */

public class MovieDetailActivity extends AppCompatActivity {

    private TextView mTextView;
    private TextView hasSeen;
    //private Context mContext;
    private ImageView mImageView;
    private TextView titleTextView;
    private Button submit;

    private Context mContext;
    private boolean yesSeen;
    private boolean noSeen;
    private boolean notLike;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detailed_activity);
        mContext=this;
        submit=findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                // construct intent
               /* radioBoxIntent.putExtra("Already Seen", yesSeen);
                radioBoxIntent.putExtra("Want to See", noSeen);
                radioBoxIntent.putExtra("Do not Like", notLike);*/
               // setResult(RESULT_OK, radioBoxIntent);
                finish();


            }
        });



        String title = this.getIntent().getExtras().getString("title");

        String description = this.getIntent().getExtras().getString("description");

        String poster = this.getIntent().getExtras().getString("poster");

        setTitle(title);

        mImageView=findViewById(R.id.posterView);
        mTextView=findViewById(R.id.textViewPage);
        titleTextView=findViewById(R.id.title_text_view);
        mTextView.setText(description);
        titleTextView.setText(title);
        titleTextView.setTextSize(30);
        titleTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
        Picasso.with(mContext).load(poster).into(mImageView);








    }


}