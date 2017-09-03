package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word("what is your name?", "tinne oyaase'ne", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is..", "oyaaset..", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michekses?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "eenes'aa", R.raw.phrase_are_you_coming));
        words.add(new Word("yes, I'm coming.", "hee'eenem", R.raw.phrase_yes_im_coming));
        words.add(new Word("i'm coming", "eenem", R.raw.phrase_im_coming));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        //setting up an onItemClickListener that would respond to the click in the ListView Item
        // and play the particular sound associated with that listView Item

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word wrd = words.get(position);
                int rr = wrd.getSoundId();
                mp=MediaPlayer.create(PhrasesActivity.this, rr);
                mp.start();

                //setting up an Async Call back so that MediaPlayer notify us when it has stopped playing the sound
                //and meanwhile we can do something else in the app
                //like scrolling up and down
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer(mp);
                    }
                });
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer(mp);

    }
    private void releaseMediaPlayer(MediaPlayer mpl) {

        if (mpl != null) {
            mpl.release();
            mpl = null;
        }

    }

}
