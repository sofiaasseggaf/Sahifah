
package com.project.sahifah.model.kalender;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weekday implements Serializable, Parcelable
{

    @SerializedName("en")
    @Expose
    private String en;
    @SerializedName("ar")
    @Expose
    private String ar;
    public final static Creator<Weekday> CREATOR = new Creator<Weekday>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Weekday createFromParcel(Parcel in) {
            return new Weekday(in);
        }

        public Weekday[] newArray(int size) {
            return (new Weekday[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8063616893050196055L;

    protected Weekday(Parcel in) {
        this.en = ((String) in.readValue((String.class.getClassLoader())));
        this.ar = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Weekday() {
    }

    /**
     * 
     * @param ar
     * @param en
     */
    public Weekday(String en, String ar) {
        super();
        this.en = en;
        this.ar = ar;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(en);
        dest.writeValue(ar);
    }

    public int describeContents() {
        return  0;
    }

}
