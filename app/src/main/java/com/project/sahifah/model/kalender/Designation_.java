
package com.project.sahifah.model.kalender;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Designation_ implements Serializable, Parcelable
{

    @SerializedName("abbreviated")
    @Expose
    private String abbreviated;
    @SerializedName("expanded")
    @Expose
    private String expanded;
    public final static Creator<Designation_> CREATOR = new Creator<Designation_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Designation_ createFromParcel(Parcel in) {
            return new Designation_(in);
        }

        public Designation_[] newArray(int size) {
            return (new Designation_[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3868477454391198865L;

    protected Designation_(Parcel in) {
        this.abbreviated = ((String) in.readValue((String.class.getClassLoader())));
        this.expanded = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Designation_() {
    }

    /**
     * 
     * @param expanded
     * @param abbreviated
     */
    public Designation_(String abbreviated, String expanded) {
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
