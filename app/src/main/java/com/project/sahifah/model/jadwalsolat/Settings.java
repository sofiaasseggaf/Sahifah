
package com.project.sahifah.model.jadwalsolat;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Settings implements Serializable, Parcelable
{

    @SerializedName("timeformat")
    @Expose
    private String timeformat;
    @SerializedName("school")
    @Expose
    private String school;
    @SerializedName("juristic")
    @Expose
    private String juristic;
    @SerializedName("highlat")
    @Expose
    private String highlat;
    @SerializedName("fajr_angle")
    @Expose
    private Integer fajrAngle;
    @SerializedName("isha_angle")
    @Expose
    private Integer ishaAngle;
    public final static Creator<Settings> CREATOR = new Creator<Settings>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Settings createFromParcel(Parcel in) {
            return new Settings(in);
        }

        public Settings[] newArray(int size) {
            return (new Settings[size]);
        }

    }
    ;
    private final static long serialVersionUID = -5443980728116034152L;

    protected Settings(Parcel in) {
        this.timeformat = ((String) in.readValue((String.class.getClassLoader())));
        this.school = ((String) in.readValue((String.class.getClassLoader())));
        this.juristic = ((String) in.readValue((String.class.getClassLoader())));
        this.highlat = ((String) in.readValue((String.class.getClassLoader())));
        this.fajrAngle = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ishaAngle = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Settings() {
    }

    /**
     * 
     * @param school
     * @param juristic
     * @param timeformat
     * @param fajrAngle
     * @param highlat
     * @param ishaAngle
     */
    public Settings(String timeformat, String school, String juristic, String highlat, Integer fajrAngle, Integer ishaAngle) {
        super();
        this.timeformat = timeformat;
        this.school = school;
        this.juristic = juristic;
        this.highlat = highlat;
        this.fajrAngle = fajrAngle;
        this.ishaAngle = ishaAngle;
    }

    public String getTimeformat() {
        return timeformat;
    }

    public void setTimeformat(String timeformat) {
        this.timeformat = timeformat;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getJuristic() {
        return juristic;
    }

    public void setJuristic(String juristic) {
        this.juristic = juristic;
    }

    public String getHighlat() {
        return highlat;
    }

    public void setHighlat(String highlat) {
        this.highlat = highlat;
    }

    public Integer getFajrAngle() {
        return fajrAngle;
    }

    public void setFajrAngle(Integer fajrAngle) {
        this.fajrAngle = fajrAngle;
    }

    public Integer getIshaAngle() {
        return ishaAngle;
    }

    public void setIshaAngle(Integer ishaAngle) {
        this.ishaAngle = ishaAngle;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(timeformat);
        dest.writeValue(school);
        dest.writeValue(juristic);
        dest.writeValue(highlat);
        dest.writeValue(fajrAngle);
        dest.writeValue(ishaAngle);
    }

    public int describeContents() {
        return  0;
    }

}
