package com.yesabhi.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_starting.*

class StartingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting)

        startbtn.setOnClickListener {

            if(startEd1.text.toString().isEmpty() ){

                startEd1.error="Enter player name"
                startEd1.requestFocus()

            }
            if(startEd2.text.toString().isEmpty()){
                startEd2.error="Enter player name"
                startEd2.requestFocus()
            }
            else {
                Toast.makeText(this,"HOPE ${startEd1.text.toString()} and ${startEd2.text.toString()} will enjoy the game",Toast.LENGTH_LONG).show()
                val i = Intent(this, MainActivity::class.java)
                val a = startEd1.text.toString()
                val b = startEd2.text.toString()

                i.putExtra("player1", a)
                i.putExtra("player2", b)
                startActivity(i)
            }
        }
    }
}