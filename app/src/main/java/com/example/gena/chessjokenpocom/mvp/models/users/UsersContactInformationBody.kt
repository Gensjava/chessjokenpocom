package com.example.gena.chessjokenpocom.mvp.models.users

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UsersContactInformationBody {
    @SerializedName("users")
    @Expose
    var users: Users? = null

    @SerializedName("usersContactInformation")
    @Expose
    var usersContactInformation: UsersContactInformation? = null

    @SerializedName("usersPersonalInformation")
    @Expose
    var usersPersonalInformation: UsersPersonalInformation? = null

    @SerializedName("usersCryptoInformation")
    @Expose
    var usersCryptoInformation: UsersCryptoInformation? = null

    constructor(
        users: Users?,
        usersContactInformation: UsersContactInformation?,
        usersPersonalInformation: UsersPersonalInformation?,
        usersCryptoInformation: UsersCryptoInformation?
    ) {
        this.users = users
        this.usersContactInformation = usersContactInformation
        this.usersPersonalInformation = usersPersonalInformation
        this.usersCryptoInformation = usersCryptoInformation
    }
}