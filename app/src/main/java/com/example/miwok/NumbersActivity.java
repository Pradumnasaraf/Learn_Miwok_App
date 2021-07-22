

package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
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
        final ArrayList<Word> mywords = new ArrayList<>();
        mywords.add(new Word("One", "Lutti",R.drawable.number_one,R.raw.number_one));
        mywords.add(new Word("Two","otiko", R.drawable.number_two,R.raw.number_two));
        mywords.add(new Word("Three","tolookosu", R.drawable.number_three ,R.raw.number_three));
        mywords.add(new Word("Four","oyyisa", R.drawable.number_four ,R.raw.number_four));
        mywords.add(new Word("Five","massokka", R.drawable.number_five ,R.raw.number_five));
        mywords.add(new Word("Six","temmokka", R.drawable.number_six ,R.raw.number_six));
        mywords.add(new Word("Seven","kenekaku", R.drawable.number_seven ,R.raw.number_seven));
        mywords.add(new Word("Eight","kawinta", R.drawable.number_eight ,R.raw.number_eight));
        mywords.add(new Word("Nine","wo'e", R.drawable.number_nine ,R.raw.number_nine));
        mywords.add(new Word("Ten","na'aacha", R.drawable.number_ten ,R.raw.number_ten));

        // Custom Adapter that takes Array list of objects, integer for layout color and context.
        WordAdapter adapter = new WordAdapter(this, mywords,R.color.category_numbers);
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
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmMiwokAudioFileId());

                // Start the Audio File
                mediaPlayer.start();

                // Setup a listener on MediaPlayer, so that we stop and release the
                // media player once the sound ahs finished palying
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }

        });

    }


}


         /*
            // Finding a liner Layout by Find method
            LinearLayout rootView = findViewById(R.id.rootView);
            for(int i =0 ; i<words.size(); i++){
            // Creating A TextView Object
            TextView wordView  = new TextView(this);
            // Setting The text on TextView by help of ArrayList index
            wordView.setText(words.get(i));
            // Adding a Child View To Root View by method "addView()"
            rootView.addView(wordView);
        }
        */
