package com.example.miwok;

public class Word extends Throwable {

    //  Default Translation for The word
    private String mDefaultTranslation;

    // Miwok Translation  For The Word
    private String mMiwokTranslation;

    // Image Resource id  For The Word
    private int mImageResourceID = NO_IMAGE;

    // Creating a Constant Value
    private final static int NO_IMAGE =-1;

    // Miwok Translation  For The Word
    private int mMiwokAudioFileId;

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceID=" + mImageResourceID +
                ", mMiwokAudioFileId=" + mMiwokAudioFileId +
                '}';
    }

    /**
     * Create a new Word Class Object 2 input
     *
     * @param EnglishInput is the word in language user is already familiar with
     * @param MiwokInput is the word in the Miwok Language
     * @param AudioTranslation is the resource is file for the miwok audio
     */
    public Word(String EnglishInput, String MiwokInput, int AudioTranslation){
       mMiwokTranslation = EnglishInput;
       mDefaultTranslation = MiwokInput;
       mMiwokAudioFileId = AudioTranslation;

    }
    /**
     * Create a new Word Class Object with 3 input
     *
     * @param EnglishInput is the word in language user is already familiar with
     * @param MiwokInput is the word in the Miwok Language
     * @param ImageResourceID is the resource id for the iamge
     * @param AudioTranslation is the resource is file for the miwok audio
     */
    public Word(String EnglishInput, String MiwokInput, int ImageResourceID, int AudioTranslation){
        mMiwokTranslation = EnglishInput;
        mDefaultTranslation = MiwokInput;
        mImageResourceID = ImageResourceID;
        mMiwokAudioFileId = AudioTranslation;
    }
    /**
     * Returns the Default Translation
     */
    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Returns the Miwok Translation
     */

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }
    /**
     * Returns the Miwok audio file
     */

    public int getmMiwokAudioFileId() {
        return mMiwokAudioFileId;
    }

    /**
     * Returns the Image Resource Id.
     */

    public int getImageResourceID(){
        return  mImageResourceID;
    }

    /**
     * Returns whether ot not there is Image for this word
     */
    public boolean hasImage(){
        return mImageResourceID!= NO_IMAGE;
    }

}

