
package com.project.sahifah.model.kalender;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hijri implements Serializable, Parcelable
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
    private Weekday weekday;
    @SerializedName("month")
    @Expose
    private Month month;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("designation")
    @Expose
    private Designation designation;
    @SerializedName("holidays")
    @Expose
    private List<Object> holidays = null;
    public final static Creator<Hijri> CREATOR = new Creator<Hijri>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Hijri createFromParcel(Parcel in) {
            return new Hijri(in);
        }

        public Hijri[] newArray(int size) {
            return (new Hijri[size]);
        }

    }
    ;
    private final static long serialVersionUID = -3151252031345681986L;

    protected Hijri(Parcel in) {
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.format = ((String) in.readValue((String.class.getClassLoader())));
        this.day = ((String) in.readValue((String.class.getClassLoader())));
        this.weekday = ((Weekday) in.readValue((Weekday.class.getClassLoader())));
        this.month = ((Month) in.readValue((Month.class.getClassLoader())));
        this.year = ((String) in.readValue((String.class.getClassLoader())));
        this.designation = ((Designation) in.readValue((Designation.class.getClassLoader())));
        in.readList(this.holidays, (Object.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Hijri() {
    }

    /**
     * 
     * @param date
     * @param month
     * @param holidays
     * @param year
     * @param format
     * @param weekday
     * @param designation
     * @param day
     */
    public Hijri(String date, String format, String day, Weekday weekday, Month month, String year, Designation designation, List<Object> holidays) {
        super();
        this.date = date;
        this.format = format;
        this.day = day;
        this.weekday = weekday;
        this.month = month;
        this.year = year;
        this.designation = designation;
        this.holidays = holidays;
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

    public Weekday getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public List<Object> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Object> holidays) {
        this.holidays = holidays;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(date);
        dest.writeValue(format);
        dest.writeValue(day);
        dest.writeValue(weekday);
        dest.writeValue(month);
        dest.writeValue(year);
        dest.writeValue(designation);
        dest.writeList(holidays);
    }

    public int describeContents() {
        return  0;
    }

}
