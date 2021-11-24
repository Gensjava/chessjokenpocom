package com.example.gena.chessjokenpocom.app.constants

import com.example.gena.chessjokenpocom.BuildConfig

object ApiUtils {
    val BASIC_TOKEN: String = BuildConfig.BASIC_TOKEN
    const val CONTENT_TYPE = "application/x-www-form-urlencoded"
    const val APPLICATION_JSON = "application/json"
    const val GRANT_TYPE = "password"
    const val MODE_DRIVING = "driving"
    const val OAUTH_TOKEN = "/oauth/token"
    const val API_USER_RESET_PASSWORD = "/api/user/reset-password"
    const val API_USER_SEND_PIN = "/api/user/send-pin"
    const val API_USER_CREATED = "/api/user/sign-up"
}