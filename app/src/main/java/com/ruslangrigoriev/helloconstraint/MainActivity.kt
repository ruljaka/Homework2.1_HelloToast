package com.ruslangrigoriev.helloconstraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import helloconstraint.R

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.java.simpleName
    private var mCount = 0
    private var mShowCount: TextView? = null
    private var mZeroBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShowCount = findViewById(R.id.show_count)
        mZeroBtn = findViewById(R.id.button_zero)
    }

    fun showToast(view: View) {
        val toast: Toast = Toast.makeText(
            this, R.string.toast_message,
            Toast.LENGTH_SHORT
        )
        toast.show()
    }

    fun countUp(view: View) {
        mCount++
        mShowCount?.text = mCount.toString()
        if (mCount % 2 == 0) {
            view.setBackgroundColor(getColor(R.color.blue))
        } else {
            view.setBackgroundColor(getColor(R.color.green))
        }
        mZeroBtn?.setBackgroundColor(getColor(R.color.pink))
    }

    fun countToZero(view: View) {
        mCount = 0
        mShowCount?.text = mCount.toString()
        view.setBackgroundColor(getColor(R.color.gray))
        val mCountBtn = findViewById<Button>(R.id.button_count)
        mCountBtn?.setBackgroundColor(getColor(R.color.colorPrimary))
    }
}