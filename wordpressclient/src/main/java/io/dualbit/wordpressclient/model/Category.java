package io.dualbit.wordpressclient.model;


import lombok.Getter;

public class Category extends Term {

    /**
     * The parent term ID.
     * <p>Context: view, edit</p>
     */
    @Getter
    Integer parent;
}
