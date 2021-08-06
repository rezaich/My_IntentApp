package com.zaich.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_move_for_result.*

class MoveForResultActivity : AppCompatActivity(),View.OnClickListener {

    companion object{
        const val EXTRA_RESULT_VALUE = "extra result value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        btChoose.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btChoose){
            if (rgNumber.checkedRadioButtonId > 0){
                var value = 0
                when(rgNumber.checkedRadioButtonId){
                    R.id.rb100 -> value = 100
                    R.id.rb150 -> value = 150
                    R.id.rb50 -> value = 50
                }

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_RESULT_VALUE,value)
                setResult(RESULT_CODE,resultIntent)
                finish()
            }
        }
    }
}