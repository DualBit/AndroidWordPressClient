package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;


abstract class Entry extends Creation {

    /**
     * The content for the object.
     * <p>Context: view, edit</p>
     */
    @Getter
    Rendered content;

    /**
     * The excerpt for the object.
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    Rendered excerpt;

    /**
     * The ID of the featured media for the object.
     * <p>Context: view, edit</p>
     */
    @Getter
    @SerializedName("featured_media")
    Integer featuredMedia;
}
