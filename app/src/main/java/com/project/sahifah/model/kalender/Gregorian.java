
package com.project.sahifah.model.kalender;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gregorian implements Serializable, Parcelable
{

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("weekday")
    @Expose
    private Weekday_ weekday;
    @SerializedName("month")
    @Expose
    private Month_ month;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("designation")
    @Expose
    private Designation_ designation;
    public final static Creator<Gregorian> CREATOR = new Creator<Gregorian>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Gregorian createFromParcel(Parcel in) {
            return new Gregorian(in);
        }

        public Gregorian[] newArray(int size) {
            return (new Gregorian[size]);
        }

    }
    ;
    private final static long serialVersionUID = 1997289175110141832L;

    protected Gregorian(Parcel in) {
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.format = ((String) in.readValue((String.class.getClassLoader())));
        this.day = ((String) in.readValue((String.class.getClassLoader())));
        this.weekday = ((Weekday_) in.readValue((Weekday_.class.getClassLoader())));
        this.month = ((Month_) in.readValue((Month_.class.getClassLoader())));
        this.year = ((String) in.readValue((String.class.getClassLoader())));
        this.designation = ((Designation_) in.readValue((Designation_.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Gregorian() {
    }

    /**
     * 
     * @param date
     * @param month
     * @param year
     * @param format
     * @param weekday
     * @param designation
     * @param day
     */
    public Gregorian(String date, String format, String day, Weekday_ weekday, Month_ month, String year, Designation_ designation) {
        super();
        this.date = date;
        this.format = format;
        this.day = day;
        this.weekday = weekday;
        this.month = month;
        this.year = year;
        this.designation = designation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Weekday_ getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday_ weekday) {
        this.weekday = weekday;
    }

    public Month_ getMonth() {
        return month;
    }

    public void setMonth(Month_ month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Designation_ getDesignation() {
        return designation;
    }

    public void setDesignation(Designation_ designation) {
        this.designation = designation;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(date);
        dest.writeValue(format);
        dest.writeValue(day);
        dest.writeValue(weekday);
        dest.writeValue(month);
        dest.writeValue(year);
        dest.writeValue(designation);
    }

    public int describeContents() {
        return  0;
    }

}
