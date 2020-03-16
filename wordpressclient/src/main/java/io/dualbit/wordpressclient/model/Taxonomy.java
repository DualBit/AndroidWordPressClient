package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;


public class Taxonomy extends BasePostType {

    /**
     * Whether or not the term cloud should be displayed.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @Getter
    @SerializedName("show_cloud")
    Boolean showCloud;

    /**
     * Types associated with the taxonomy.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    @Getter
    List<String> types;
}
