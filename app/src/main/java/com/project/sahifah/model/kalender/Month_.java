
package com.project.sahifah.model.kalender;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Month_ implements Serializable, Parcelable
{

    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("en")
    @Expose
    private String en;
    public final static Creator<Month_> CREATOR = new Creator<Month_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Month_ createFromParcel(Parcel in) {
            return new Month_(in);
        }

        public Month_[] newArray(int size) {
            return (new Month_[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2193178448854779165L;

    protected Month_(Parcel in) {
        this.number = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.en = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Month_() {
    }

    /**
     * 
     * @param number
     * @param en
     */
    public Month_(Integer number, String en) {
        super();
        this.number = number;
        this.en = en;
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(number);
        dest.writeValue(en);
    }

    public int describeContents() {
        return  0;
    }

}
