package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.dualbit.wordpressclient.util.DateUtils;
import lombok.Getter;


abstract class Creation extends BaseCreation {

    /**
     * The globally unique identifier for the object.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    @Getter
    Rendered guid;

    /**
     * The date the object was last modified, in the site’s timezone. (ISO8601)
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    String modified;

    /**
     * The date the object was last modified, as GMT. (ISO8601)
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    @SerializedName("modified_gmt")
    String modifiedGmt;

    /**
     * An alphanumeric identifier for the object unique to its type.
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    String slug;

    /**
     * The title for the object.
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    Rendered title;

    /**
     * Whether or not comments are open on the object.
     * <p>Context: view, edit</p>
     * <p>One of: open, closed</p>
     */
    @Getter
    @SerializedName("comment_status")
    String commentStatus;

    /**
     * Whether or not the object can be pinged.
     * <p>Context: view, edit</p>
     * <p>Context: open, closed</p>
     */
    @Getter
    @SerializedName("ping_status")
    String pingStatus;

    /**
     * The theme file to use to display the object.
     * <p>Context: view, edit</p>
     * <p>One of:</p>
     */
    @Getter
    String template;

    /**
     * The date the object was last modified, in the site’s timezone. <p>Read only</p>
     * @return
     */
    Date getModified() {
        return DateUtils.parseISO8601(modified);
    }

    /**
     * The date the object was last modified, as GMT. <p>Read only</p>
     * @return
     */
    Date getModifiedGmt() {
        return DateUtils.parseISO8601(modifiedGmt);
    }
}
