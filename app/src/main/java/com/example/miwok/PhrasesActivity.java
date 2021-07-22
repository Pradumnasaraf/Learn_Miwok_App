 package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;



public class PhrasesActivity extends AppCompatActivity {
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

        ArrayList<Word> mywords = new ArrayList<>();
        mywords.add(new Word("Where are you going?", "Minto Wuksus",R.raw.phrase_where_are_you_going));
        mywords.add(new Word("What is your name?","Tinnә oyaase'nә" ,R.raw.phrase_what_is_your_name));
        mywords.add(new Word("My name is...","oyaaset",R.raw.phrase_my_name_is));
        mywords.add(new Word("How are you feeling?","Michәksәs?",R.raw.phrase_how_are_you_feeling));
        mywords.add(new Word("I’m feeling good.","Kuchi achit",R.raw.phrase_im_feeling_good));
        mywords.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        mywords.add(new Word("Yes, I’m coming.","Hәә’ әәnәm" ,R.raw.phrase_yes_im_coming));
        mywords.add(new Word("I’m coming.","әәnәm",R.raw.phrase_im_coming));
        mywords.add(new Word("Let’s go.","Yoowutis",R.raw.phrase_lets_go));
        mywords.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));

        // Custom Adapter that takes Array list of objects, integer for layout color and context.
        WordAdapter adapter = new WordAdapter(this, mywords,R.color.category_phrases);
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
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmMiwokAudioFileId());

                // Start the Audio File
                mediaPlayer.start();

                // Setup a listener on MediaPlayer, so that we stop and release the
                // media player once the sound ahs finished palying
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }

        });

    }

}