
package com.project.sahifah.model.jadwalsolat;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Times implements Serializable, Parcelable
{

    @SerializedName("Imsak")
    @Expose
    private String imsak;
    @SerializedName("Sunrise")
    @Expose
    private String sunrise;
    @SerializedName("Fajr")
    @Expose
    private String fajr;
    @SerializedName("Dhuhr")
    @Expose
    private String dhuhr;
    @SerializedName("Asr")
    @Expose
    private String asr;
    @SerializedName("Sunset")
    @Expose
    private String sunset;
    @SerializedName("Maghrib")
    @Expose
    private String maghrib;
    @SerializedName("Isha")
    @Expose
    private String isha;
    @SerializedName("Midnight")
    @Expose
    private String midnight;
    public final static Creator<Times> CREATOR = new Creator<Times>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Times createFromParcel(Parcel in) {
            return new Times(in);
        }

        public Times[] newArray(int size) {
            return (new Times[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5353123365750345603L;

    protected Times(Parcel in) {
        this.imsak = ((String) in.readValue((String.class.getClassLoader())));
        this.sunrise = ((String) in.readValue((String.class.getClassLoader())));
        this.fajr = ((String) in.readValue((String.class.getClassLoader())));
        this.dhuhr = ((String) in.readValue((String.class.getClassLoader())));
        this.asr = ((String) in.readValue((String.class.getClassLoader())));
        this.sunset = ((String) in.readValue((String.class.getClassLoader())));
        this.maghrib = ((String) in.readValue((String.class.getClassLoader())));
        this.isha = ((String) in.readValue((String.class.getClassLoader())));
        this.midnight = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Times() {
    }

    /**
     * 
     * @param asr
     * @param sunrise
     * @param isha
     * @param midnight
     * @param imsak
     * @param sunset
     * @param dhuhr
     * @param fajr
     * @param maghrib
     */
    public Times(String imsak, String sunrise, String fajr, String dhuhr, String asr, String sunset, String maghrib, String isha, String midnight) {
        super();
        this.imsak = imsak;
        this.sunrise = sunrise;
        this.fajr = fajr;
        this.dhuhr = dhuhr;
        this.asr = asr;
        this.sunset = sunset;
        this.maghrib = maghrib;
        this.isha = isha;
        this.midnight = midnight;
    }

    public String getImsak() {
        return imsak;
    }

    public void setImsak(String imsak) {
        this.imsak = imsak;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getFajr() {
        return fajr;
    }

    public void setFajr(String fajr) {
        this.fajr = fajr;
    }

    public String getDhuhr() {
        return dhuhr;
    }

    public void setDhuhr(String dhuhr) {
        this.dhuhr = dhuhr;
    }

    public String getAsr() {
        return asr;
    }

    public void setAsr(String asr) {
        this.asr = asr;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMaghrib() {
        return maghrib;
    }

    public void setMaghrib(String maghrib) {
        this.maghrib = maghrib;
    }

    public String getIsha() {
        return isha;
    }

    public void setIsha(String isha) {
        this.isha = isha;
    }

    public String getMidnight() {
        return midnight;
    }

    public void setMidnight(String midnight) {
        this.midnight = midnight;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(imsak);
        dest.writeValue(sunrise);
        dest.writeValue(fajr);
        dest.writeValue(dhuhr);
        dest.writeValue(asr);
        dest.writeValue(sunset);
        dest.writeValue(maghrib);
        dest.writeValue(isha);
        dest.writeValue(midnight);
    }

    public int describeContents() {
        return  0;
    }

}
