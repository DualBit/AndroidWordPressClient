package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

import lombok.Getter;


public class User extends FeaturedObject {

    /**
     * Login name for the user.
     * <p>Context: edit</p>
     */
    @Getter
    String username;

    /**
     * First name for the user.
     * <p>Context: edit</p>
     */
    @Getter
    @SerializedName("first_name")
    String firstName;

    /**
     * Last name for the user.
     * <p>Context: edit</p>
     */
    @Getter
    @SerializedName("last_name")
    String lastName;

    /**
     * The email address for the user.
     * <p>Context: edit</p>
     */
    @Getter
    String email;

    /**
     * URL of the user.
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    String url;

    /**
     * Locale for the user.
     * <p>Context: edit</p>
     * <p>One of: en_US</p>
     */
    @Getter
    String locale;

    /**
     * The nickname for the user.
     * <p>Context: edit</p>
     */
    @Getter
    String nickname;

    /**
     * Registration date for the user.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @Getter
    @SerializedName("registered_date")
    String registeredDate;

    /**
     * Roles assigned to the user.
     * <p>Context: edit</p>
     */
    @Getter
    List<String> roles;

    /**
     * Password for the user (never included).
     */
    @Getter
    String password;

    /**
     * All capabilities assigned to the user.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @Getter
    List<Object> capabilities;

    /**
     * Any extra capabilities assigned to the user.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @Getter
    @SerializedName("extra_capabilities")
    List<Object> extraCapabilities;

    /**
     * Avatar URLs for the user.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    @SerializedName("avatar_urls")
    Map<Integer, String> avatarUrls;
}
