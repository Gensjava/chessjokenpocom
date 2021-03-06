package com.example.gena.chessjokenpocom.mvp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthorizationResponse {
    @SerializedName("access_token")
    @Expose
    var accessToken: String? = null

    @SerializedName("token_type")
    @Expose
    var tokenType: String? = null

    @SerializedName("refresh_token")
    @Expose
    var refreshToken: String? = null

    @SerializedName("expires_in")
    @Expose
    var expiresIn: Int? = null

    @SerializedName("scope")
    @Expose
    var scope: String? = null

}
