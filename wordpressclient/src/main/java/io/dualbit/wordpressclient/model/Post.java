package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;


public class Post extends Entry {

    /**
     * A password to protect access to the content and excerpt.
     * <p>Context: edit</p>
     */
    @Getter
    String password;

    /**
     * The format for the object.
     * <p>Context: view, edit</p>
     * <p>One of: standard</p>
     */
    @Getter
    String format;

    /**
     * Whether or not the object should be treated as sticky.
     * <p>Context: view, edit</p>
     */
    @Getter
    Boolean sticky;

    /**
     * The terms assigned to the object in the category taxonomy.
     * <p>Context: view, edit</p>
     */
    @Getter
    List<Integer> categories;

    /**
     * The terms assigned to the object in the post_tag taxonomy.
     * <p>Context: view, edit</p>
     */
    @Getter
    List<Integer> tags;

    /**
     * The number of Liveblog Likes the post has.
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    @SerializedName("liveblog_likes")
    Integer liveblogLikes;
}
