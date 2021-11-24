package com.example.gena.chessjokenpocom.helpers

import android.util.Base64
import android.util.Log
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import java.io.IOException
import java.security.SecureRandom
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.SecretKeySpec

object EncoderHelper {

    private val secretKeySpec: SecretKeySpec?
        get() {
            var sks: SecretKeySpec? = null
            try {
                val sr = SecureRandom.getInstance("SHA1PRNG")
                sr.setSeed("any data used as random seed".toByteArray())
                val kg = KeyGenerator.getInstance("AES")
                kg.init(128, sr)
                sks = SecretKeySpec(kg.generateKey().encoded, "AES")
            } catch (e: Exception) {
                Log.e("Crypto", "AES secret key spec error")
            }

            return sks
        }

    fun <T> converterErrorGSon(error: HttpException, aClass: Class<T>): T? {
        val gson = GsonBuilder().create()
        try {
            val bytes = error.response().errorBody()!!.bytes()
            return gson.fromJson(String(bytes), aClass)
        } catch (e: IOException) {
            e.printStackTrace()
            System.out.println(e.printStackTrace())
        }

        return null
    }


    fun getOnlyNumbers(number: String): String {
        return number.trim { it <= ' ' }.replace("\\D+".toRegex(), "")
    }


    fun emailValidator(email: String): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val EMAIL_PATTERN =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        pattern = Pattern.compile(EMAIL_PATTERN)
        matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun encodeCryptoText(text: String): String? {
        var encodedBytes: ByteArray? = null
        try {
            val c = Cipher.getInstance("AES")
            c.init(Cipher.ENCRYPT_MODE, secretKeySpec)
            encodedBytes = c.doFinal(text.toByteArray())
            return Base64.encodeToString(encodedBytes, Base64.DEFAULT)
        } catch (e: Exception) {
            Log.e("Crypto", "AES encryption error")
            return null
        }

    }

    fun decodeCryptoText(encodedBytes: ByteArray): String? {
        var decodedBytes: ByteArray? = null
        try {
            val c = Cipher.getInstance("AES")
            c.init(Cipher.DECRYPT_MODE, secretKeySpec)
            decodedBytes = c.doFinal(encodedBytes)
            return String(decodedBytes!!)
        } catch (e: Exception) {
            Log.e("Crypto", "AES decryption error")
            return null
        }

    }
}