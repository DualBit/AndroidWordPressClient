package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;


public class Links {

    @Getter
    @SerializedName("self")
    List<Link> self;

    @Getter
    @SerializedName("collection")
    List<Link> collection;

    @Getter
    @SerializedName("about")
    List<Link> about;

    @Getter
    @SerializedName("author")
    List<Link> author;

    @Getter
    @SerializedName("replies")
    List<Link> replies;

    @Getter
    @SerializedName("version-history")
    List<Link> versionHistory;

    @Getter
    @SerializedName("wp:attachment")
    List<Link> attachment;

    @Getter
    @SerializedName("wp:featuredmedia")
    List<Link> featuredMedia;

    @Getter
    @SerializedName("wp:term")
    List<Link> term;

    @Getter
    @SerializedName("curies")
    List<Link> curies;

    @Getter
    @SerializedName("up")
    List<Link> up;

    @Getter
    @SerializedName("wp:post_type")
    List<Link> postType;

    @Getter
    @SerializedName("in-reply-to")
    List<Link> inReplyTo;

    @Getter
    @SerializedName("children")
    List<Link> children;

    @Getter
    @SerializedName("wp:items")
    List<Link> items;

    @Getter
    @SerializedName("archives")
    List<Link> archives;
}
