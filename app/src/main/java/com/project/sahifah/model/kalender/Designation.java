
package com.project.sahifah.model.kalender;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Designation implements Serializable, Parcelable
{

    @SerializedName("abbreviated")
    @Expose
    private String abbreviated;
    @SerializedName("expanded")
    @Expose
    private String expanded;
    public final static Creator<Designation> CREATOR = new Creator<Designation>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Designation createFromParcel(Parcel in) {
            return new Designation(in);
        }

        public Designation[] newArray(int size) {
            return (new Designation[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8165690150776553827L;

    protected Designation(Parcel in) {
        this.abbreviated = ((String) in.readValue((String.class.getClassLoader())));
        this.expanded = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Designation() {
    }

    /**
     * 
     * @param expanded
     * @param abbreviated
     */
    public Designation(String abbreviated, String expanded) {
        super();
        this.abbreviated = abbreviated;
        this.expanded = expanded;
    }

    public String getAbbreviated() {
        return abbreviated;
    }

    public void setAbbreviated(String abbreviated) {
        this.abbreviated = abbreviated;
    }

    public String getExpanded() {
        return expanded;
    }

    public void setExpanded(String expanded) {
        this.expanded = expanded;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(abbreviated);
        dest.writeValue(expanded);
    }

    public int describeContents() {
        return  0;
    }

}
