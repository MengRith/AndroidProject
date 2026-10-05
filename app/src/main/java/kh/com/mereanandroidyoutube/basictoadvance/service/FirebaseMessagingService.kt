package kh.com.mereanandroidyoutube.basictoadvance.service

import com.google.firebase.messaging.FirebaseMessagingService as BaseFirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseMessagingService : BaseFirebaseMessagingService()  {
    override fun onNewToken(token: String) {

    }
    override fun onMessageReceived(remoteMessage: RemoteMessage) {

    }

    private fun showNotification(

    ){

    }

    private fun sendTokenToServer( ){

    }

}