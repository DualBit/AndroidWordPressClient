package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;


abstract class BaseObject {

    /**
     * Unique identifier for the object.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    Integer id;

    /**
     * URL of the object.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    String link;

    /**
     * Meta fields.
     * <p>Context: view, edit</p>
     */
    @Getter
    List<Rendered> meta; // todo test if it is indeed list of meta objects

    @Getter
    @SerializedName("_links")
    Links links;
}
