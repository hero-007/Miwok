package com.example.android.miwok;

/**
 * Created by HP on 4/24/2017.
 */

public class Word {
    private String defaultTranslation, miwokTranslation;
    private int resourceId = HASIMAGE;
    private int soundId ;
    private static final int HASIMAGE = -1;

    // it is a default constructor which initializes the variable with default values
    public Word() {
        defaultTranslation = "";
        miwokTranslation = "";
    }

    // this constructor when called initializes the variable of the word class with input parameters as passed by the user
    public Word(String A, String B, int C) {
        defaultTranslation = A;
        miwokTranslation = B;
        soundId = C;
    }

    // this constructor is used when we need image in our activity
    public Word(String A, String B, int C, int D){
        defaultTranslation = A;
        miwokTranslation = B;
        resourceId = C;
        soundId = D;
    }
    //this method return the current value of miwokTranslation to the user when called
    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    // this method returns the current value of the defaultTranslation when called
    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    //this method returns the image id
    public int getImageResourceId() {
        return resourceId;
    }

    //this method check whether a view has an image associated with it or not

    public boolean hasImage(){
        return (resourceId!=HASIMAGE);
    }

    //this method is used to return the audio Id
    public int getSoundId() { return soundId; }
}
