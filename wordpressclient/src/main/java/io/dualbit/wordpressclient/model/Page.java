package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;


public class Page extends Entry {

    /**
     * The id for the parent of the object.
     * <p>Context: view, edit</p>
     */
    @Getter
    Integer parent;

    /**
     * The order of the object in relation to other object of its type.
     * <p>Context: view, edit</p>
     */
    @Getter
    @SerializedName("menu_order")
    Integer menuOrder;
}
