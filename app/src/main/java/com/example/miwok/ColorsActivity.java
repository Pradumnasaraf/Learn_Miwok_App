package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    /**
     * Clean up the media player by releasing its resources.
     */


    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, the media player get released
        // because we won't be playing any more sounds.
        releaseMediaPlayer();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Create a list of Words
        ArrayList<Word> mywords = new ArrayList<>();
        mywords.add(new Word("Red", "Weṭeṭṭi",R.drawable.color_red,R.raw.color_black));
        mywords.add(new Word("Green","Chokokki",R.drawable.color_green,R.raw.color_green));
        mywords.add(new Word("Brown","Takaakki",R.drawable.color_brown,R.raw.color_brown));
        mywords.add(new Word("Gray","Topoppi",R.drawable.color_gray,R.raw.color_gray));
        mywords.add(new Word("Black","Kululli",R.drawable.color_black,R.raw.color_black));
        mywords.add(new Word("White","Kelelli",R.drawable.color_white,R.raw.color_white));
        mywords.add(new Word("Dusty yellow","Topiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        mywords.add(new Word("Mustard yellow","Chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        // Custom Adapter that takes Array list of objects, integer for layout color and context.
        WordAdapter adapter = new WordAdapter(this, mywords,R.color.category_colors);
        ListView list = findViewById(R.id.ListView);

        //{@Link ListView} will display list item for each {@link Word } in the list.
        list.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the {@Link Word } object at the given position the user clicked on
                Word word= mywords.get(position);

                //Release the media player if it currently exists because we are about
                // to play a different sound file.
                releaseMediaPlayer();

                // Create and Setup the {@link MediaPlayer} for the resources
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmMiwokAudioFileId());

                // Start the Audio File
                mediaPlayer.start();

                // Setup a listener on MediaPlayer, so that we stop and release the
                // media player once the sound ahs finished palying
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }

        });

    }


}