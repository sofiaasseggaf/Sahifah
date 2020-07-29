
package com.project.sahifah.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelQuran implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("suraId")
    @Expose
    private String suraId;
    @SerializedName("verseID")
    @Expose
    private String verseID;
    @SerializedName("ayahText")
    @Expose
    private String ayahText;
    @SerializedName("indoText")
    @Expose
    private String indoText;
    @SerializedName("readText")
    @Expose
    private String readText;
    public final static Creator<ModelQuran> CREATOR = new Creator<ModelQuran>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ModelQuran createFromParcel(Parcel in) {
            return new ModelQuran(in);
        }

        public ModelQuran[] newArray(int size) {
            return (new ModelQuran[size]);
        }

    }
    ;
    private final static long serialVersionUID = 3138837818041987756L;

    protected ModelQuran(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.suraId = ((String) in.readValue((String.class.getClassLoader())));
        this.verseID = ((String) in.readValue((String.class.getClassLoader())));
        this.ayahText = ((String) in.readValue((String.class.getClassLoader())));
        this.indoText = ((String) in.readValue((String.class.getClassLoader())));
        this.readText = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ModelQuran() {
    }

    /**
     * 
     * @param verseID
     * @param ayahText
     * @param readText
     * @param id
     * @param indoText
     * @param suraId
     */
    public ModelQuran(String id, String suraId, String verseID, String ayahText, String indoText, String readText) {
        super();
        this.id = id;
        this.suraId = suraId;
        this.verseID = verseID;
        this.ayahText = ayahText;
        this.indoText = indoText;
        this.readText = readText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSuraId() {
        return suraId;
    }

    public void setSuraId(String suraId) {
        this.suraId = suraId;
    }

    public String getVerseID() {
        return verseID;
    }

    public void setVerseID(String verseID) {
        this.verseID = verseID;
    }

    public String getAyahText() {
        return ayahText;
    }

    public void setAyahText(String ayahText) {
        this.ayahText = ayahText;
    }

    public String getIndoText() {
        return indoText;
    }

    public void setIndoText(String indoText) {
        this.indoText = indoText;
    }

    public String getReadText() {
        return readText;
    }

    public void setReadText(String readText) {
        this.readText = readText;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(suraId);
        dest.writeValue(verseID);
        dest.writeValue(ayahText);
        dest.writeValue(indoText);
        dest.writeValue(readText);
    }

    public int describeContents() {
        return  0;
    }

}
