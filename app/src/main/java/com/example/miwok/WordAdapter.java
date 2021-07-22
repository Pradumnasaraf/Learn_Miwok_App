package com.example.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.util.Log;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
 int BackgroundColor;
    /**
     * This is our Custom Constructor (Doesn't match to Superclass constructor)
     * Taking Two input 1st context and second ArrayList of myWords Objects.
     *
     */
    public WordAdapter(Context context, ArrayList<Word> myWords, int BackgroundColor) {
        super(context,0, myWords);
        this.BackgroundColor=BackgroundColor;
    }

    /**
     * provide a view for an AdapterView (Listview, Gridview, etc)
     *
     * @param position The AdapterView position that is requesting a view
     * @param convertView The recycled to populate
     *                    (Search for "Android view Recycling")
     * @param parent the parent viewGroup that is used for inflation
     * @return the view for the position in the adapter
     */
    @Override
    //
    public View getView(int position, View convertView,  ViewGroup parent) {
        //get the Word object located at this position in the list
       Word CurrentLook= getItem(position);
       // Log.v("NumbersActivity", "Current word: " + CurrentLook.toString());

       // check if the existing view is being reused otherwise inflate the view.
       View listItemView = convertView;
       if (listItemView== null){
           listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
       }

       // Find the TextView in the list_item.xml layout with the ID miwokTextView
       TextView miwokTextView = listItemView.findViewById(R.id.miwokTextView);

       // get the miwoktranslation  from the current word object and set this on text on the
       miwokTextView.setText(CurrentLook.getmMiwokTranslation());

       // Find the TextView in the list_item.xml layout with the ID miwokTextView
       TextView DefaultTextView = listItemView.findViewById(R.id.defaultTextView);


       DefaultTextView.setText(CurrentLook.getmDefaultTranslation());

       ImageView ImageVIew = listItemView.findViewById(R.id.imageview);

       if (CurrentLook.hasImage()){
           ImageVIew.setImageResource(CurrentLook.getImageResourceID());
           // Make the textview visible
           ImageVIew.setVisibility(View.VISIBLE);
       }
       else {
           // Otherwise hide the ImageView
           ImageVIew.setVisibility(View.GONE);
       }
       // Set the theme color for list view
       View layout =listItemView.findViewById(R.id.BackgroundColor);
       // Find the color that the resource ID is map to
       int color = ContextCompat.getColor(getContext(),BackgroundColor);
       // Setting the color
       layout.setBackgroundColor(color);
       return listItemView;


    }
}
