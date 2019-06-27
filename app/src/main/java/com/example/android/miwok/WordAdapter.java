package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColor = 0;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param word           A List of Word objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<Word> word, int color)
    {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, word);
        mColor = color;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);


        // MiWiok text
        TextView nameTextView = listItemView.findViewById(R.id.miwok_text_view);
        nameTextView.setText(currentWord.getMiwokTranslation());

        // Default (English) text
        TextView numberTextView = listItemView.findViewById(R.id.default_text_view);
        numberTextView.setText(currentWord.getDefaultTranslation());

        // Image
        ImageView image = listItemView.findViewById(R.id.image_view);
        if (currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageResourceID());
            image.setVisibility(View.VISIBLE);
        }
        else {
            image.setVisibility(View.GONE);
        }

        if (currentWord.hasAudio()){

        }


        // Set the Color of teh background
        View textContainer = listItemView.findViewById(R.id.text_container);
        int backgroundColor = ContextCompat.getColor(getContext(), mColor);
        textContainer.setBackgroundColor(backgroundColor);


        return listItemView;
    }
}
