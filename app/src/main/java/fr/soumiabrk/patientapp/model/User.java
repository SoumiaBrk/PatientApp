package fr.soumiabrk.patientapp.model;

import com.google.gson.annotations.SerializedName;

public class User {

    public final String token;
    public final int id;
    public final String username;
    @SerializedName("first_name")
    public final String firstName;
    @SerializedName("last_name")
    public final String lastName;
    public final String email;
    @SerializedName("user_type")
    public final String userType;

    public User(String token, int id, String username, String firstName, String lastName, String email, String userType) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userType = userType;
    }
}
