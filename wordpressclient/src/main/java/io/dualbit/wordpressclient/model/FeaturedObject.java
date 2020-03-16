package io.dualbit.wordpressclient.model;


import lombok.Getter;

abstract class FeaturedObject extends SlugObject {

    /**
     * Description of the resource.
     * <p>Context: view, edit, embed</p>
     */
    @Getter
    String description;
}
