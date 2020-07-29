
package com.project.sahifah.model.jadwalsolat;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelJadwalSolat implements Serializable, Parcelable
{

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private Results results;
    public final static Creator<ModelJadwalSolat> CREATOR = new Creator<ModelJadwalSolat>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ModelJadwalSolat createFromParcel(Parcel in) {
            return new ModelJadwalSolat(in);
        }

        public ModelJadwalSolat[] newArray(int size) {
            return (new ModelJadwalSolat[size]);
        }

    }
    ;
    private final static long serialVersionUID = 8035544492622521296L;

    protected ModelJadwalSolat(Parcel in) {
        this.code = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.results = ((Results) in.readValue((Results.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ModelJadwalSolat() {
    }

    /**
     * 
     * @param code
     * @param results
     * @param status
     */
    public ModelJadwalSolat(Integer code, String status, Results results) {
        super();
        this.code = code;
        this.status = status;
        this.results = results;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(code);
        dest.writeValue(status);
        dest.writeValue(results);
    }

    public int describeContents() {
        return  0;
    }

}
