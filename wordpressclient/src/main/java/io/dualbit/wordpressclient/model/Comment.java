package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

import lombok.Getter;


public class Comment extends BaseCreation {

    /**
     * The content for the object.
     * <p>Context: view, edit</p>
     */
    @Getter
    Object content;

    /**
     * Email address for the object author.
     * <p>Context: edit</p>
     */
    @Getter
    @SerializedName("author_email")
    String authorEmail;

    /**
     * IP address for the object author.
     * <p>Context: edit</p>
     */
    @Getter
    @SerializedName("author_ip")
    String authorIp;

    /**
     * Display name for the object author.
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    @SerializedName("author_name")
    String authorName;

    /**
     * URL for the object author.
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    @SerializedName("author_url")
    String authorUrl;

    /**
     * User agent for the object author.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @Getter
    @SerializedName("author_user_agent")
    String authorUserAgent;

    /**
     * Karma for the object.
     * <p>Context: edit</p>
     */
    @Getter
    Integer karma;

    /**
     * The id for the parent of the object.
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    Integer parent;

    /**
     * The id of the associated post object.
     * <p>Context: view, edit</p>
     */
    @Getter
    Integer post;

    /**
     * Avatar URLs for the object author.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    @SerializedName("author_avatar_urls")
    Map<Integer, String> authorAvatarUrls;
}
