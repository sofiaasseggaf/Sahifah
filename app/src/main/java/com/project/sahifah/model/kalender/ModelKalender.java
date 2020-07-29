
package com.project.sahifah.model.kalender;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelKalender implements Serializable, Parcelable
{

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private Data data;
    public final static Creator<ModelKalender> CREATOR = new Creator<ModelKalender>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ModelKalender createFromParcel(Parcel in) {
            return new ModelKalender(in);
        }

        public ModelKalender[] newArray(int size) {
            return (new ModelKalender[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8470137434905064921L;

    protected ModelKalender(Parcel in) {
        this.code = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ModelKalender() {
    }

    /**
     * 
     * @param code
     * @param data
     * @param status
     */
    public ModelKalender(Integer code, String status, Data data) {
        super();
        this.code = code;
        this.status = status;
        this.data = data;
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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(code);
        dest.writeValue(status);
        dest.writeValue(data);
    }

    public int describeContents() {
        return  0;
    }

}
