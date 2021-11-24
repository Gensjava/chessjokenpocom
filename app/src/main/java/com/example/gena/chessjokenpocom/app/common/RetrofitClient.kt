package com.example.gena.chessjokenpocom.app.common

import android.content.Context
import com.example.gena.chessjokenpocom.BuildConfig
import com.example.gena.chessjokenpocom.app.App
import com.example.gena.chessjokenpocom.customs.CustomInterceptor
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    var retrofit: Retrofit
    internal val BASE_URL = BuildConfig.BASE_URL
    private val TIMEOUT_HTTP = 5

    init {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(getSlrClubClient(App.app))
            .build()
    }


    @Throws(Exception::class)
    fun getSlrClubClient(context: Context): OkHttpClient {
        // loading CAs from an InputStream
        //        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        //        InputStream cert = context.getAssets().open("DigiCertGlobalCAG2.crt");
        //        Certificate ca;
        //        try {
        //            ca = cf.generateCertificate(cert);
        //        } finally {
        //            cert.close();
        //        }
        //
        //        // creating a KeyStore containing our trusted CAs
        //        String keyStoreType = KeyStore.getDefaultType();
        //        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        //        keyStore.load(null, null);
        //        keyStore.setCertificateEntry("ca", ca);
        //
        //        // creating a TrustManager that trusts the CAs in our KeyStore
        //        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        //        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
        //        tmf.init(keyStore);
        //
        //        // creating an SSLSocketFactory that uses our TrustManager
        //        SSLContext sslContext = SSLContext.getInstance("TLS");
        //        sslContext.init(null, tmf.getTrustManagers(), null);

        val builder = OkHttpClient.Builder()
        builder.addInterceptor(CustomInterceptor())

        // builder.sslSocketFactory(sslContext.getSocketFactory());
        // builder.hostnameVerifier((hostname, session) -> true);

        val okHttpClient = builder.build()

        builder.connectTimeout(TIMEOUT_HTTP.toLong(), TimeUnit.SECONDS)
        builder.readTimeout(TIMEOUT_HTTP.toLong(), TimeUnit.SECONDS)
        builder.writeTimeout(TIMEOUT_HTTP.toLong(), TimeUnit.SECONDS)

        // creating a RestAdapter using the custom client
        return okHttpClient
    }
}