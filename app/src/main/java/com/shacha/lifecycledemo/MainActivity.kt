package com.shacha.lifecycledemo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var logView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        logView = findViewById(R.id.logView)
        logView.log("onCreate")
    }

    override fun onStart() {
        super.onStart()
        logView.log("onStart")
    }

    override fun onPause() {
        super.onPause()
        logView.log("onPause")
    }

    override fun onResume() {
        super.onResume()
        logView.log("onResume")
    }

    override fun onStop() {
        super.onStop()
        logView.log("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logView.log("onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        logView.log("onRestart")
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        logView.log("onWindowFocusChanged, $hasFocus")
    }
}

private fun TextView.log(msg: String) {
    text = "$text\n$msg"
}
