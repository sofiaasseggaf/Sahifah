
package com.project.sahifah.model.jadwalsolat;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Date extends java.util.Date implements Serializable, Parcelable
{

    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("gregorian")
    @Expose
    private String gregorian;
    @SerializedName("hijri")
    @Expose
    private String hijri;
    public final static Creator<Date> CREATOR = new Creator<Date>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Date createFromParcel(Parcel in) {
            return new Date(in);
        }

        public Date[] newArray(int size) {
            return (new Date[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3243726495140361657L;

    protected Date(Parcel in) {
        this.timestamp = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.gregorian = ((String) in.readValue((String.class.getClassLoader())));
        this.hijri = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Date() {
    }

    /**
     * 
     * @param hijri
     * @param gregorian
     * @param timestamp
     */
    public Date(Integer timestamp, String gregorian, String hijri) {
        super();
        this.timestamp = timestamp;
        this.gregorian = gregorian;
        this.hijri = hijri;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getGregorian() {
        return gregorian;
    }

    public void setGregorian(String gregorian) {
        this.gregorian = gregorian;
    }

    public String getHijri() {
        return hijri;
    }

    public void setHijri(String hijri) {
        this.hijri = hijri;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(timestamp);
        dest.writeValue(gregorian);
        dest.writeValue(hijri);
    }

    public int describeContents() {
        return  0;
    }

}
