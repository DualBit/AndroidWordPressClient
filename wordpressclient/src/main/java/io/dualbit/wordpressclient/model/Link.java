package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;


public class Link {

    @Getter
    @SerializedName("name")
    String name;

    @Getter
    @SerializedName("taxonomy")
    String taxonomy;

    @Getter
    @SerializedName("href")
    String href;

    @Getter
    @SerializedName("embeddable")
    Boolean embeddable;

    @Getter
    @SerializedName("templated")
    Boolean templated;

    @Getter
    @SerializedName("post_type")
    String postType;
}
