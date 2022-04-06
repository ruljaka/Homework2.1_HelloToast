package com.ruslangrigoriev.helloconstraint

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import helloconstraint.R

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MESSAGE = "com.ruslangrigoriev.helloconstraint.extra.MESSAGE"
        const val EXTRA_COUNT = "com.ruslangrigoriev.helloconstraint.extra.COUNT"
    }

    private var mCount = 0
    private var mShowCount: TextView? = null
    private var mZeroBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShowCount = findViewById(R.id.show_count)
        mZeroBtn = findViewById(R.id.button_zero)
    }

    fun sayHello(view: View) {
        val intent = Intent(this, HelloActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, mCount.toString())
        startActivity(intent)
    }

    fun countUp(view: View) {
        mCount++
        mShowCount?.text = mCount.toString()
        setButtonsColor(view)
    }

    private fun setButtonsColor(view: View) {
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

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mCount = savedInstanceState.getInt(EXTRA_COUNT)
        mShowCount?.text = mCount.toString()
        setButtonsColor(findViewById(R.id.button_count))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(EXTRA_COUNT,mCount)
    }

}