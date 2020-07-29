
package com.project.sahifah.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelUsers implements Serializable, Parcelable
{

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("role")
    @Expose
    private Integer role;
    @SerializedName("nomor_handphone")
    @Expose
    private String nomorHandphone;
    public final static Creator<ModelUsers> CREATOR = new Creator<ModelUsers>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ModelUsers createFromParcel(Parcel in) {
            return new ModelUsers(in);
        }

        public ModelUsers[] newArray(int size) {
            return (new ModelUsers[size]);
        }

    }
    ;
    private final static long serialVersionUID = 976040036413054729L;

    protected ModelUsers(Parcel in) {
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
        this.nama = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.role = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nomorHandphone = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ModelUsers() {
    }

    /**
     * 
     * @param password
     * @param role
     * @param nama
     * @param nomorHandphone
     * @param email
     * @param username
     */
    public ModelUsers(String username, String password, String nama, String email, Integer role, String nomorHandphone) {
        super();
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.email = email;
        this.role = role;
        this.nomorHandphone = nomorHandphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getNomorHandphone() {
        return nomorHandphone;
    }

    public void setNomorHandphone(String nomorHandphone) {
        this.nomorHandphone = nomorHandphone;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(username);
        dest.writeValue(password);
        dest.writeValue(nama);
        dest.writeValue(email);
        dest.writeValue(role);
        dest.writeValue(nomorHandphone);
    }

    public int describeContents() {
        return  0;
    }

}
