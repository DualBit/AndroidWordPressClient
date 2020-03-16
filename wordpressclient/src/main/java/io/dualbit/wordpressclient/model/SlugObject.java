package io.dualbit.wordpressclient.model;


import lombok.Getter;

public class SlugObject extends BaseObject {

    /**
     * Name for the resource.
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    String name;

    /**
     * An alphanumeric identifier for the resource.
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    String slug;
}
