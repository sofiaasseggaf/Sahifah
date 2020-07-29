
package com.project.sahifah.model.jadwalsolat;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datetime implements Serializable, Parcelable
{

    @SerializedName("times")
    @Expose
    private Times times;
    @SerializedName("date")
    @Expose
    private Date date;
    public final static Creator<Datetime> CREATOR = new Creator<Datetime>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Datetime createFromParcel(Parcel in) {
            return new Datetime(in);
        }

        public Datetime[] newArray(int size) {
            return (new Datetime[size]);
        }

    }
    ;
    private final static long serialVersionUID = -2700368957250451761L;

    protected Datetime(Parcel in) {
        this.times = ((Times) in.readValue((Times.class.getClassLoader())));
        this.date = ((Date) in.readValue((Date.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datetime() {
    }

    /**
     * 
     * @param date
     * @param times
     */
    public Datetime(Times times, Date date) {
        super();
        this.times = times;
        this.date = date;
    }

    public Times getTimes() {
        return times;
    }

    public void setTimes(Times times) {
        this.times = times;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(times);
        dest.writeValue(date);
    }

    public int describeContents() {
        return  0;
    }

}
