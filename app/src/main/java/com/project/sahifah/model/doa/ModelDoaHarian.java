
package com.project.sahifah.model.doa;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelDoaHarian implements Serializable, Parcelable
{

    @SerializedName("detail")
    @Expose
    private List<Detail> detail = null;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("penjelasan")
    @Expose
    private String penjelasan;
    @SerializedName("id_header")
    @Expose
    private String idHeader;
    public final static Creator<ModelDoaHarian> CREATOR = new Creator<ModelDoaHarian>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ModelDoaHarian createFromParcel(Parcel in) {
            return new ModelDoaHarian(in);
        }

        public ModelDoaHarian[] newArray(int size) {
            return (new ModelDoaHarian[size]);
        }

    }
    ;
    private final static long serialVersionUID = 1860732567692193910L;

    protected ModelDoaHarian(Parcel in) {
        in.readList(this.detail, (Detail.class.getClassLoader()));
        this.judul = ((String) in.readValue((String.class.getClassLoader())));
        this.penjelasan = ((String) in.readValue((String.class.getClassLoader())));
        this.idHeader = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ModelDoaHarian() {
    }

    /**
     * 
     * @param penjelasan
     * @param detail
     * @param judul
     * @param idHeader
     */
    public ModelDoaHarian(List<Detail> detail, String judul, String penjelasan, String idHeader) {
        super();
        this.detail = detail;
        this.judul = judul;
        this.penjelasan = penjelasan;
        this.idHeader = idHeader;
    }

    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public String getIdHeader() {
        return idHeader;
    }

    public void setIdHeader(String idHeader) {
        this.idHeader = idHeader;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(detail);
        dest.writeValue(judul);
        dest.writeValue(penjelasan);
        dest.writeValue(idHeader);
    }

    public int describeContents() {
        return  0;
    }

}
