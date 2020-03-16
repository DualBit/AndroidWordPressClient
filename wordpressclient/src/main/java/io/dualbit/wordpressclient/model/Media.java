package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;


public class Media extends Creation {

    /**
     * Alternative text to display when resource is not displayed.
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    @SerializedName("alt_text")
    String altText;

    /**
     * The caption for the resource.
     * <p>Context: view, edit</p>
     */
    @Getter
    Rendered caption;

    /**
     * The description for the resource.
     * <p>Context: view, edit</p>
     */
    @Getter
    Rendered description;

    /**
     * Type of resource.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     * <p>One of: image, file</p>
     */
    @Getter
    @SerializedName("media_type")
    String mediaType;

    /**
     * MIME type of resource.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    @SerializedName("mime_type")
    String mimeType;

    /**
     * Details about the resource file, specific to its type.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    @SerializedName("media_details")
    MediaDetails mediaDetails;

    /**
     * The id for the associated post of the resource.
     * <p>Context: view, edit</p>
     */
    @Getter
    Integer post;

    /**
     * URL to the original resource file.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    @SerializedName("source_url")
    String sourceUrl;
}
