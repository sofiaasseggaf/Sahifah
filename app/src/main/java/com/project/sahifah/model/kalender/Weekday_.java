
package com.project.sahifah.model.kalender;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weekday_ implements Serializable, Parcelable
{

    @SerializedName("en")
    @Expose
    private String en;
    public final static Creator<Weekday_> CREATOR = new Creator<Weekday_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Weekday_ createFromParcel(Parcel in) {
            return new Weekday_(in);
        }

        public Weekday_[] newArray(int size) {
            return (new Weekday_[size]);
        }

    }
    ;
    private final static long serialVersionUID = 1172653336993249218L;

    protected Weekday_(Parcel in) {
        this.en = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Weekday_() {
    }

    /**
     * 
     * @param en
     */
    public Weekday_(String en) {
        super();
        this.en = en;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(en);
    }

    public int describeContents() {
        return  0;
    }

}
