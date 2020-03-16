package io.dualbit.wordpressclient.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;


public class Rendered {

    @Getter
    @SerializedName("rendered")
    String rendered;

    @Getter
    @SerializedName("protected")
    Boolean isProtected;
}
