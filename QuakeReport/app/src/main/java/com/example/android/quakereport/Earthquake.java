package com.example.android.quakereport;

public class Earthquake {
    private Double mMagnitude;
    private String mLocation;
    private Long mTimeInMilliseconds;

    public Earthquake(Double mMagnitude, String mLocation, Long mTimeInMilliseconds) {
        this.mMagnitude = mMagnitude;
        this.mLocation = mLocation;
        this.mTimeInMilliseconds = mTimeInMilliseconds;
    }

    public Double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public Long getDate() {
        return mTimeInMilliseconds;
    }
}
