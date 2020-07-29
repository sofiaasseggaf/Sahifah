
package com.project.sahifah.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelOase implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("group_id")
    @Expose
    private String groupId;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    public final static Creator<ModelOase> CREATOR = new Creator<ModelOase>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ModelOase createFromParcel(Parcel in) {
            return new ModelOase(in);
        }

        public ModelOase[] newArray(int size) {
            return (new ModelOase[size]);
        }

    }
    ;
    private final static long serialVersionUID = 6079080482257854836L;

    protected ModelOase(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.groupId = ((String) in.readValue((String.class.getClassLoader())));
        this.content = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.createdDate = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ModelOase() {
    }

    /**
     * 
     * @param image
     * @param createdDate
     * @param groupId
     * @param id
     * @param title
     * @param content
     */
    public ModelOase(String id, String title, String groupId, String content, String image, String createdDate) {
        super();
        this.id = id;
        this.title = title;
        this.groupId = groupId;
        this.content = content;
        this.image = image;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(groupId);
        dest.writeValue(content);
        dest.writeValue(image);
        dest.writeValue(createdDate);
    }

    public int describeContents() {
        return  0;
    }

}
