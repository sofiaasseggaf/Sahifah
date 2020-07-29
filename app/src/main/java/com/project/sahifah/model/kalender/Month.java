
package com.project.sahifah.model.kalender;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Month implements Serializable, Parcelable
{

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("en")
    @Expose
    private String en;
    @SerializedName("ar")
    @Expose
    private String ar;
    public final static Creator<Month> CREATOR = new Creator<Month>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Month createFromParcel(Parcel in) {
            return new Month(in);
        }

        public Month[] newArray(int size) {
            return (new Month[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4734491504203134358L;

    protected Month(Parcel in) {
        this.number = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.en = ((String) in.readValue((String.class.getClassLoader())));
        this.ar = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Month() {
    }

    /**
     * 
     * @param number
     * @param ar
     * @param en
     */
    public Month(Integer number, String en, String ar) {
        super();
        this.number = number;
        this.en = en;
        this.ar = ar;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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
        dest.writeValue(number);
        dest.writeValue(en);
        dest.writeValue(ar);
    }

    public int describeContents() {
        return  0;
    }

}
