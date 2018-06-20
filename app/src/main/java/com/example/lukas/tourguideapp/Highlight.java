package com.example.lukas.tourguideapp;

/**
 * {@link Highlight} represents a highlight of the city word that the user might want to see.
 */
public class Highlight {

    /**
     * Constant value that represents no image was provided for this highlight
     */
    private static final int NO_OPEN_PROVIDED = -1;

    /**
     * String resource ID for the name of the attration
     */
    private int mNameId;

    /**
     * String resource ID for location of the highlight
     */
    private int mLocationId;

    /**
     * String resource ID for telephone number of the highlight
     */
    private int mTelephoneId;

    /**
     * String resource ID for opening hours of the highlight
     */
    private int mOpenId = NO_OPEN_PROVIDED;

    /**
     * Audio resource ID for the highlight
     */
    private int mAudioResourceId;

    /**
     * Image resource ID for the highlight
     */
    private int mImageResourceId;

    /**
     * Create a new Word object.
     *
     * @param nameId          is the string resource ID for name of the highlight
     * @param locationId      is the string resource Id for the location of the highlight
     * @param telephoneId     is the resource ID for the telephone number of the highlight
     * @param openId          is the resource ID for the opening hours of the highlight
     * @param imageResourceId is the resource ID for the picture of the highlight
     */
    public Highlight(int nameId, int locationId, int telephoneId, int openId, int imageResourceId) {
        mNameId = nameId;
        mLocationId = locationId;
        mTelephoneId = telephoneId;
        mOpenId = openId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Word object.
     *
     * @param nameId          is the string resource ID for name of the highlight
     * @param locationId      is the string resource Id for the location of the highlight
     * @param telephoneId     is the resource ID for the telephone number of the highlight
     * @param imageResourceId is the resource ID for the picture of the highlight
     */
    public Highlight(int nameId, int locationId, int telephoneId, int imageResourceId) {
        mNameId = nameId;
        mLocationId = locationId;
        mTelephoneId = telephoneId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the string resource ID for the name of the highlight
     */
    public int getNameId() {
        return mNameId;
    }

    /**
     * Get the string resource ID for the location of the highlight
     */
    public int getLocationId() {
        return mLocationId;
    }

    /**
     * Get the string resource ID for the telephone number of the highlight
     */
    public int getTelephoneId() {
        return mTelephoneId;
    }

    /**
     * Get the string resource ID for the opening hours of the highlight
     */
    public int getOpenId() {
        return mOpenId;
    }

    /**
     * Return the image resource ID of the highlight
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this highlight
     */
    public boolean hasOpen() {
        return mOpenId != NO_OPEN_PROVIDED;
    }

    /**
     * Return the audio resource ID of the highlight
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
