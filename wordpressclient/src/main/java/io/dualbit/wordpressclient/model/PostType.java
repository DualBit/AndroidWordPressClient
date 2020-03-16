package io.dualbit.wordpressclient.model;

import java.util.List;

import lombok.Getter;


public class PostType extends BasePostType {

    @Getter
    List<String> taxonomies;
}
