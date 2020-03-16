package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;


public class MediaSizes {

    @Getter
    MediaSize thumbnail;

    @Getter
    MediaSize medium;

    @Getter
    @SerializedName("medium_large")
    MediaSize mediumLarge;

    @Getter
    MediaSize large;

    @Getter
    @SerializedName("twentyseventeen-thumbnail-avatar")
    MediaSize twentyseventeenThumbnailAvatar;

    @Getter
    MediaSize full;
}
