package com.example.gena.chessjokenpocom.customs

import com.example.gena.chessjokenpocom.app.Session
import com.example.gena.chessjokenpocom.app.common.RetrofitClient
import com.example.gena.chessjokenpocom.app.constants.ApiUtils
import com.example.gena.chessjokenpocom.app.constants.AppConstants
import com.example.gena.chessjokenpocom.app.constants.CodesErrors
import com.example.gena.chessjokenpocom.mvp.AuthorizationResponse
import com.example.gena.chessjokenpocom.network.MainRequestApi
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import retrofit2.Call
import java.io.IOException

class CustomInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalHttpUrl = request.url()
        return if (request.url().encodedPath() != ApiUtils.OAUTH_TOKEN) {
            val response = chain.proceed(getRequest(request, originalHttpUrl))
            if (response.code() == CodesErrors.ERROR_CODE_TOKEN) {
                val messagesApi: MainRequestApi =
                    RetrofitClient.retrofit.create(MainRequestApi::class.java)
                val messages: Call<AuthorizationResponse> = messagesApi.getTokenSyn(
                    ApiUtils.BASIC_TOKEN,
                    ApiUtils.CONTENT_TYPE,
                    ApiUtils.GRANT_TYPE,
                    AppConstants.LOGIN,
                    AppConstants.PASSWORD
                ) as Call<AuthorizationResponse>
                try {
                    val responseToken: retrofit2.Response<AuthorizationResponse> =
                        messages.execute()
                    if (responseToken.isSuccessful) {
                        Session.accessToken = responseToken.body()?.accessToken!!
                    } else {
                        throw IOException("Unexpected code " + responseToken.errorBody()!!.string())
                    }
                } catch (e: Exception) {
                    throw IOException("Unexpected code " + e.message)
                }
                chain.proceed(getRequest(request, originalHttpUrl))
            } else {
                response
            }
        } else {
            chain.proceed(request)
        }
    }

    private fun getRequest(request: Request, originalHttpUrl: HttpUrl): Request {
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("access_token", Session.accessToken)
            .build()
        return if (request.url().encodedPath() != ApiUtils.API_USER_RESET_PASSWORD
            && request.url().encodedPath() != ApiUtils.API_USER_SEND_PIN
            && request.url().encodedPath() != ApiUtils.API_USER_CREATED
        ) {
            val build = request.newBuilder()
                .header("password", AppConstants.PASSWORD)
                .header("username", AppConstants.LOGIN)
                .header("Content-Type", ApiUtils.APPLICATION_JSON)
                .url(url)
                .build()
            build
        } else {
            request.newBuilder()
                .header("Content-Type", ApiUtils.APPLICATION_JSON)
                .url(url)
                .build()
        }
    }
}