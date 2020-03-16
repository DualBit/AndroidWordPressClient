package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;


public class PostStatus extends SlugObject {

    /**
     * Whether posts with this resource should be private.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @Getter
    @SerializedName("private")
    Boolean isPrivate;

    /**
     * Whether posts with this resource should be protected.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @Getter
    @SerializedName("protected")
    Boolean isProtected;

    /**
     * Whether posts of this resource should be shown in the front end of the site.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    @Getter
    @SerializedName("public")
    Boolean isPublic;

    /**
     * Whether posts with this resource should be publicly-queryable.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    @Getter
    Boolean queryable;

    /**
     * Whether to include posts in the edit listing for their post type.
     * <p>Read only</p>
     * <p>Context: edit
     */
    @Getter
    @SerializedName("show_in_list")
    Boolean showInList;
}
