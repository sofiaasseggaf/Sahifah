
package com.project.sahifah.model.kalender;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable, Parcelable
{

    @SerializedName("hijri")
    @Expose
    private Hijri hijri;
    @SerializedName("gregorian")
    @Expose
    private Gregorian gregorian;
    public final static Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8969459340686639569L;

    protected Data(Parcel in) {
        this.hijri = ((Hijri) in.readValue((Hijri.class.getClassLoader())));
        this.gregorian = ((Gregorian) in.readValue((Gregorian.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param hijri
     * @param gregorian
     */
    public Data(Hijri hijri, Gregorian gregorian) {
        super();
        this.hijri = hijri;
        this.gregorian = gregorian;
    }

    public Hijri getHijri() {
        return hijri;
    }

    public void setHijri(Hijri hijri) {
        this.hijri = hijri;
    }

    public Gregorian getGregorian() {
        return gregorian;
    }

    public void setGregorian(Gregorian gregorian) {
        this.gregorian = gregorian;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(hijri);
        dest.writeValue(gregorian);
    }

    public int describeContents() {
        return  0;
    }

}
