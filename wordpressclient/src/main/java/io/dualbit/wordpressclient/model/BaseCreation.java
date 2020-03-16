package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

import io.dualbit.wordpressclient.util.DateUtils;
import lombok.Getter;


abstract class BaseCreation extends BaseObject {

    /**
     * The ID for the author of the object, if author was a user.
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    Integer author;

    /**
     * A named status for the object.
     * <p>Context: edit</p>
     * <p>One of: publish, future, draft, pending, private</p>
     */
    @Getter
    String status;

    /**
     * Type of Post/Comment for the object.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    String type;

    /**
     * The date the object was published, in the site's timezone. (ISO8601)
     * <p>Context: view, edit, embed</p>
     */
    @SerializedName("date")
    String date;

    /**
     * The date the object was published, as GMT. (ISO8601)
     * <p>Context: view, edit</p>
     */
    @SerializedName("date_gmt")
    String dateGmt;

    /**
     * The date the object was published, in the site’s timezone.
     * @return date or null
     */
    Date getDate() {
        return DateUtils.parseISO8601(date);
    }

    /**
     * The date the object was published, in the site’s timezone.
     * @param date Date
     */
    void setDate(Date date) {
        this.date = DateUtils.parseISO8601(date);
    }

    /**
     * The date the object was published, as GMT.
     * @return Date
     */
    Date getDateGmt() {
        return DateUtils.parseISO8601(dateGmt);
    }

    /**
     * The date the object was published, as GMT.
     * @param dateGmt Date
     */
    void setDateGmt(Date dateGmt) {
        this.dateGmt = DateUtils.parseISO8601(dateGmt);
    }
}
