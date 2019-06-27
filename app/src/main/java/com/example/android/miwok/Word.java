package com.example.android.miwok;

import android.media.Image;

public class Word {

    // String
    private String mDefaultTranslation;
    private String mMiwokTranslation;

    // Image
    private static int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    // Audio
    private static int NO_AUDIO_PROVIDED = -1;
    private int mAudioFile;

    public Word(String defaultTranslation, String miwokTrabslation, int audioID)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTrabslation;
        mAudioFile = audioID;
    }

    public Word(String defaultTranslation, String miwokTrabslation, int imageResourceID, int audioID)
    {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTrabslation;
        mImageResourceID = imageResourceID;
        mAudioFile = audioID;
    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public int getImageResourceID()
    {
        return mImageResourceID;
    }

    public int getAudioID(){ return mAudioFile; }
    

    public boolean hasImage()
    {
       return mImageResourceID != NO_IMAGE_PROVIDED;
    }

    public boolean hasAudio()
    {
        return  mAudioFile != NO_AUDIO_PROVIDED;
    }
}
