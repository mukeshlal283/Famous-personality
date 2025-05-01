package com.example.famouspersonality.view

import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    private val timeout = 60 * 1000L
    private val handler = Handler(Looper.getMainLooper())
    private val timeoutRunnable = Runnable {
        navigateToHome()
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        resetTimeOut()
    }

    override fun onResume() {
        super.onResume()
        resetTimeOut()
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(timeoutRunnable)
    }

    private fun resetTimeOut() {
        handler.removeCallbacks(timeoutRunnable)
        handler.postDelayed(timeoutRunnable, timeout)
    }

    private fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

}