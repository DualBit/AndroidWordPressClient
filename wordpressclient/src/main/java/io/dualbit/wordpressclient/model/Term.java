package io.dualbit.wordpressclient.model;


import lombok.Getter;

abstract class Term extends FeaturedObject {

    /**
     * Number of published posts for the term.
     * <p>Read only</p>
     * <p>Context: view, edit</p>
     */
    @Getter
    Integer count;

    /**
     * Type attribution for the term.
     * <p>Read only</p>
     * <p>Context: view, edit, embed</p>
     * <p>One of: category, post_tag, nav_menu, link_category, post_format</p>
     */
    @Getter
    String taxonomy;
}
