package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;


public class MediaSize {

    @Getter
    String file;

    @Getter
    Integer width;

    @Getter
    Integer height;

    @Getter
    @SerializedName("mime_type")
    String mimeType;

    @Getter
    @SerializedName("source_url")
    String sourceUrl;
}
