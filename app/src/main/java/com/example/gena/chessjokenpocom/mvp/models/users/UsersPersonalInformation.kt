package com.example.gena.chessjokenpocom.mvp.models.users


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UsersPersonalInformation {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("userId")
    @Expose
    var userId: String? = null

    @SerializedName("firstName")
    @Expose
    var firstName: String? = null

    @SerializedName("secondName")
    @Expose
    var secondName: String? = null

    @SerializedName("linkPhotoAvatar")
    @Expose
    var linkPhotoAvatar: String? = null

    constructor(firstName: String?, secondName: String?) {
        this.firstName = firstName
        this.secondName = secondName
    }

}