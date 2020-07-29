
package com.project.sahifah.model.doa;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail implements Serializable, Parcelable
{

    @SerializedName("doa_header")
    @Expose
    private String doaHeader;
    @SerializedName("arab")
    @Expose
    private String arab;
    @SerializedName("latin")
    @Expose
    private String latin;
    @SerializedName("terjemahan")
    @Expose
    private String terjemahan;
    public final static Creator<Detail> CREATOR = new Creator<Detail>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Detail createFromParcel(Parcel in) {
            return new Detail(in);
        }

        public Detail[] newArray(int size) {
            return (new Detail[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8779682462450796141L;

    protected Detail(Parcel in) {
        this.doaHeader = ((String) in.readValue((String.class.getClassLoader())));
        this.arab = ((String) in.readValue((String.class.getClassLoader())));
        this.latin = ((String) in.readValue((String.class.getClassLoader())));
        this.terjemahan = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Detail() {
    }

    /**
     * 
     * @param doaHeader
     * @param latin
     * @param terjemahan
     * @param arab
     */
    public Detail(String doaHeader, String arab, String latin, String terjemahan) {
        super();
        this.doaHeader = doaHeader;
        this.arab = arab;
        this.latin = latin;
        this.terjemahan = terjemahan;
    }

    public String getDoaHeader() {
        return doaHeader;
    }

    public void setDoaHeader(String doaHeader) {
        this.doaHeader = doaHeader;
    }

    public String getArab() {
        return arab;
    }

    public void setArab(String arab) {
        this.arab = arab;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public String getTerjemahan() {
        return terjemahan;
    }

    public void setTerjemahan(String terjemahan) {
        this.terjemahan = terjemahan;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(doaHeader);
        dest.writeValue(arab);
        dest.writeValue(latin);
        dest.writeValue(terjemahan);
    }

    public int describeContents() {
        return  0;
    }

}
