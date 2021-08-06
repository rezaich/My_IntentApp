package com.zaich.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_move_with_data.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    companion object{
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity:Button = findViewById(R.id.btMoveActivty)
        btnMoveActivity.setOnClickListener(this)

        btMoveActivtyData.setOnClickListener(this)

        btMoveActivtyObject.setOnClickListener(this)

        btDialNumber.setOnClickListener(this)

        btMoveForResult.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btMoveActivty -> {
                startActivity(Intent(this@MainActivity,MoveActivity::class.java))
            }
            R.id.btMoveActivtyData -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy ")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }
            R.id.btMoveActivtyObject -> {
                val person = Person(
                    "Reza" , 21 , "rezareza@mail.id" , "Jakarta"
                )

                val moveWithObjectIntent = Intent(this,MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON,person)
                startActivity(moveWithObjectIntent)
            }
            R.id.btDialNumber -> {
                val phoneNumber = "0812345678"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btMoveForResult -> {
                startActivityForResult(Intent(this,MoveForResultActivity::class.java), REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_RESULT_VALUE,0)
                tvResult.text = selectedValue.toString()
            }
        }
    }
}