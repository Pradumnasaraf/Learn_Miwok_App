package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
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

    final private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
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
        mywords.add(new Word("Father", "әpә",R.drawable.family_father, R.raw.family_father));
        mywords.add(new Word("Mother","әṭa",R.drawable.family_mother ,R.raw.family_mother));
        mywords.add(new Word("Son","angsi",R.drawable.family_son ,R.raw.family_son));
        mywords.add(new Word("Daughter","tune",R.drawable.family_daughter ,R.raw.family_daughter));
        mywords.add(new Word("Older brother","taachi",R.drawable.family_older_brother ,R.raw.family_older_brother));
        mywords.add(new Word("Younger brother","chalitti",R.drawable.family_younger_brother ,R.raw.family_younger_brother));
        mywords.add(new Word("Older sister","teṭe",R.drawable.family_older_sister ,R.raw.family_older_sister));
        mywords.add(new Word("Younger sister","kolliti",R.drawable.family_younger_sister ,R.raw.family_younger_sister));
        mywords.add(new Word("Grandmother","ama",R.drawable.family_grandmother ,R.raw.family_grandmother));
        mywords.add(new Word("Grandfather","paapa",R.drawable.family_grandfather ,R.raw.family_grandfather));


        // Custom Adapter that takes Array list of objects, integer for layout color and context.
        WordAdapter adapter = new WordAdapter(this, mywords,R.color.category_family);
        ListView list = findViewById(R.id.ListView);

        //{@Link ListView} will display list item for each {@link Word } in the list.
        list.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Get the {@Link Word } object at the given position the user clicked on
               Word currentPosition = mywords.get(position);

               //Release the media player if it currently exists because we are about
               // to play a different sound file.
               releaseMediaPlayer();

               // Create and Setup the {@link MediaPlayer} for the resources
               mediaPlayer = MediaPlayer.create(FamilyActivity.this, currentPosition.getmMiwokAudioFileId());

               // Start the Audio File
               mediaPlayer.start();

               // Setup a listener on MediaPlayer, so that we stop and release the
               // media player once the sound ahs finished palying
                mediaPlayer.setOnCompletionListener(mCompletionListener);


            }

        });

    }

}