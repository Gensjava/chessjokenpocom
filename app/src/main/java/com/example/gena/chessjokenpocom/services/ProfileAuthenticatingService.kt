package com.example.gena.chessjokenpocom.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.gena.chessjokenpocom.app.common.ProfileAccountAuthenticator

class ProfileAuthenticatingService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        // TODO Auto-generated method stub
        return ProfileAccountAuthenticator(this).getIBinder()
    }
}