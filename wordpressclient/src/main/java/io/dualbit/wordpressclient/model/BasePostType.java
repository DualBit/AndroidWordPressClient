package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;


abstract class BasePostType extends FeaturedObject {

    /**
     * Whether or not the resource should have children.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    @Getter
    Boolean hierarchical;

    /**
     * All capabilities used by the resource.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @Getter
    List<Rendered> capabilities;

    /**
     * Human-readable labels for the resource for various contexts.
     * <p>Read only</p>
     * <p>Context: edit</p>
     */
    @Getter
    List<Rendered> labels;

    /**
     * REST base route for the resource.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    @SerializedName("rest_base")
    String restBase;
}
