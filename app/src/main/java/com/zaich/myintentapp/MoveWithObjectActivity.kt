package com.zaich.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_move_with_object.*

class MoveWithObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PERSON= "EXTRA PERSON"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Name : ${person.name.toString()}\nEmail : ${person.email}\nAge : ${person.age}\nLocation : ${person.city}"
        tv_object_receive.text = text
    }
}