
package com.project.sahifah.model.jadwalsolat;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results implements Serializable, Parcelable
{

    @SerializedName("datetime")
    @Expose
    private List<Datetime> datetime = null;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("settings")
    @Expose
    private Settings settings;
    public final static Creator<Results> CREATOR = new Creator<Results>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        public Results[] newArray(int size) {
            return (new Results[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4744932443431335204L;

    protected Results(Parcel in) {
        in.readList(this.datetime, (Datetime.class.getClassLoader()));
        this.location = ((Location) in.readValue((Location.class.getClassLoader())));
        this.settings = ((Settings) in.readValue((Settings.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Results() {
    }

    /**
     * 
     * @param settings
     * @param datetime
     * @param location
     */
    public Results(List<Datetime> datetime, Location location, Settings settings) {
        super();
        this.datetime = datetime;
        this.location = location;
        this.settings = settings;
    }

    public List<Datetime> getDatetime() {
        return datetime;
    }

    public void setDatetime(List<Datetime> datetime) {
        this.datetime = datetime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(datetime);
        dest.writeValue(location);
        dest.writeValue(settings);
    }

    public int describeContents() {
        return  0;
    }

}
