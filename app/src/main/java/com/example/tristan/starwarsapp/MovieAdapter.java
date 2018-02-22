package com.example.tristan.starwarsapp;

/**
 * Created by Tristan on 2/17/18.
 */

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<Movie> mMovieList;
    private LayoutInflater mInflater;

    public MovieAdapter(Context mContext, ArrayList<Movie> mMovieList){

        // initialize instances variables
        this.mContext = mContext;
        this.mMovieList = mMovieList;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    // methods
    // a list of methods we need to override

    // gives you the number of recipes in the data source
    @Override
    public int getCount(){
        return mMovieList.size();
    }

    // returns the item at specific position in the data source

    @Override
    public Object getItem(int position){
        return mMovieList.get(position);
    }

    // returns the row id associated with the specific position in the list
    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;

        // check if the view already exists
        // if yes, you don't need to inflate and findViewbyID again
        if (convertView == null){
            // inflate
            convertView = mInflater.inflate(R.layout.movie_row, parent, false);
            // add the views to the holder
            holder = new ViewHolder();
            // views
            holder.titleTextView = convertView.findViewById(R.id.movie_list_title);
            holder.descriptionTextView = convertView.findViewById(R.id.movie_list_description);
            holder.posterImageView = convertView.findViewById(R.id.movie_poster);
            holder.hasSeenTextView= convertView.findViewById(R.id.has_seen_text);
            holder.charactersTextView=convertView.findViewById(R.id.movie_list_characters);

            // add the holder to the view
            // for future use
            convertView.setTag(holder);
        }
        else{
            // get the view holder from converview
            holder = (ViewHolder)convertView.getTag();
        }
        // get relavate subview of the row view
        TextView titleTextView = holder.titleTextView;
        TextView descriptionTextView = holder.descriptionTextView;
        TextView hasSeenTextView=holder.hasSeenTextView;
        TextView charactersTextView=holder.charactersTextView;
        ImageView posterImageView = holder.posterImageView;

        // get corresonpinding recipe for each row
        Movie movie = (Movie) getItem(position);


        // update the row view's textviews and imageview to display the information

        // titleTextView
        titleTextView.setText(movie.title);
        titleTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
        titleTextView.setTextSize(18);

        // descriptionTextView
        descriptionTextView.setText(movie.description);
       descriptionTextView.setTextSize(14);
       descriptionTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));

       //hasSeenTextView



        //charactersTextView
            char[] array=movie.main_characters.toCharArray();
            int a=0;
            int i=0;
            while(a<3){
                if(array[i]==','){
                    a++;
                }
                i++;
            }

            charactersTextView.setText(movie.main_characters.substring(0,i-1).replace("[", "").replace("]", " ").replace("\"", "").replace(",",", "));
            charactersTextView.setTextSize(14);
            descriptionTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));

        // imageView
        // use Picasso library to load image from the image url
        //Picasso.with(mContext).load(movie.imageUrl).into(posterImageView);
        Picasso.with(mContext).load(movie.imageUrl).into(posterImageView);
        return convertView;
    }

    // viewHolder
    // is used to customize what you want to put into the view
    // it depends on the layout design of your row
    // this will be a private static class you have to define
    private static class ViewHolder{

        public TextView titleTextView;
        public TextView descriptionTextView;
        public TextView charactersTextView;
        public TextView hasSeenTextView;
        public ImageView posterImageView;

    }


    // intent is used to pass information between activities
    // intent -> pacakge
    // sender, receiver
}

