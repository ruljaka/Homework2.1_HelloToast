package com.ruslangrigoriev.helloconstraint

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import helloconstraint.R

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val messageTextView = findViewById<TextView>(R.id.textView_message)
        messageTextView.text = message
    }
}