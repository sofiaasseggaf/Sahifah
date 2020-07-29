
package com.project.sahifah.model.jadwalsolat;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location implements Serializable, Parcelable
{

    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("elevation")
    @Expose
    private Integer elevation;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("local_offset")
    @Expose
    private Integer localOffset;
    public final static Creator<Location> CREATOR = new Creator<Location>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        public Location[] newArray(int size) {
            return (new Location[size]);
        }

    }
    ;
    private final static long serialVersionUID = 1447318069939130867L;

    protected Location(Parcel in) {
        this.latitude = ((Double) in.readValue((Double.class.getClassLoader())));
        this.longitude = ((Double) in.readValue((Double.class.getClassLoader())));
        this.elevation = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.countryCode = ((String) in.readValue((String.class.getClassLoader())));
        this.timezone = ((String) in.readValue((String.class.getClassLoader())));
        this.localOffset = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param elevation
     * @param country
     * @param city
     * @param countryCode
     * @param timezone
     * @param latitude
     * @param localOffset
     * @param longitude
     */
    public Location(Double latitude, Double longitude, Integer elevation, String city, String country, String countryCode, String timezone, Integer localOffset) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
        this.city = city;
        this.country = country;
        this.countryCode = countryCode;
        this.timezone = timezone;
        this.localOffset = localOffset;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getElevation() {
        return elevation;
    }

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getLocalOffset() {
        return localOffset;
    }

    public void setLocalOffset(Integer localOffset) {
        this.localOffset = localOffset;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(latitude);
        dest.writeValue(longitude);
        dest.writeValue(elevation);
        dest.writeValue(city);
        dest.writeValue(country);
        dest.writeValue(countryCode);
        dest.writeValue(timezone);
        dest.writeValue(localOffset);
    }

    public int describeContents() {
        return  0;
    }

}
