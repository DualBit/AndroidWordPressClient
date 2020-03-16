package io.dualbit.wordpressclient.model;


import lombok.Getter;

public class MediaDetails {

    @Getter
    Integer width;

    @Getter
    Integer height;

    @Getter
    String file;

    @Getter
    MediaSizes sizes;
}
