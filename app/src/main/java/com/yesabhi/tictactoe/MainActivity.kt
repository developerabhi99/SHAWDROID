package com.yesabhi.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() , View.OnClickListener{
    var PLAYER = true
    var player1count = 0
    var player2count = 0
    var count = 0
    var boardCurrent = Array(3 ){IntArray(3)}


    lateinit var board : Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateName()

        board= arrayOf(
            arrayOf(button1,button2,button3),
            arrayOf(button4,button5,button6),
            arrayOf(button7,button8,button9)
        )
        initialiseBoardStatus()
        for (i in board) {
            for (button in i) {
                button.setOnClickListener(this)
            }
        }
        initialiseBoardStatus()

        btnreset.setOnClickListener {
                PLAYER = true
                count =0
                initialiseBoardStatus()
            switchbtn.isEnabled = true

            }
        switchbtn.setOnClickListener {
            switch()
        }



    }

    private fun switch() {
        PLAYER = PLAYER != true
        if(PLAYER ){
            var s1= intent.getStringExtra("player1")
            var text=s1 + " Turn "
            updateText(text)

        }
        else{
            var  s2= intent.getStringExtra("player2")
            var text=s2 + " Turn "
            updateText(text)
        }
        

    }

    private fun updateName() {
        var playerr1= intent.getStringExtra("player1")
        player1.text=playerr1 +" "+player1count
        var  playerr2= intent.getStringExtra("player2")
        player2.text=playerr2 +" "+player2count
    }

    private fun initialiseBoardStatus()
    {
        for(i in 0..2){
            for(j in 0..2){
                boardCurrent[i][j]=-1
            }
        }
        for(i in board){
            for(button in i){
                button.isEnabled = true
                button.text=""

            }
        }
        switchbtn.isEnabled = false

    }

    override fun onClick(view:  View) {
        when(view.id){
            R.id.button1 ->{
                updatevalue(row =0,col=0, player =PLAYER)
                switchbtn.isEnabled = false

            }

            R.id.button2 ->{
                updatevalue(row =0,col=1, player =PLAYER)
                switchbtn.isEnabled = false
            }
            R.id.button3 ->{
                updatevalue(row =0,col=2, player =PLAYER)
                switchbtn.isEnabled = false
            }
            R.id.button4 ->{
                updatevalue(row =1,col=0, player =PLAYER)
                switchbtn.isEnabled = false
            }
            R.id.button5 ->{
                updatevalue(row =1,col=1, player =PLAYER)
                switchbtn.isEnabled = false

            }
            R.id.button6 ->{
                updatevalue(row =1,col=2, player =PLAYER)
                switchbtn.isEnabled = false

            }
            R.id.button7 ->{
                updatevalue(row =2,col=0, player =PLAYER)
                switchbtn.isEnabled = false

            }
            R.id.button8 ->{
                updatevalue(row =2,col=1, player =PLAYER)
                switchbtn.isEnabled = false

            }
            R.id.button9 ->{
                updatevalue(row =2,col=2, player =PLAYER)
                switchbtn.isEnabled = false

            }

        }
        count++
        PLAYER = !PLAYER
        if(PLAYER){
            var s1= intent.getStringExtra("player1")
            var text=s1 + " Turn "
           updateText(text)

        }
        else{
            var  s2= intent.getStringExtra("player2")
            var text=s2 + " Turn "
            updateText(text)
        }
        if(count == 9){
            updateText("Match Draw")
        }

         Winner()

    }

    private fun Winner() {
       for (i in 0..2) {
           if (boardCurrent[i][0] == boardCurrent[i][1] && boardCurrent[i][0] == boardCurrent[i][2]) {
               if (boardCurrent[i][0] == 1) {
                   var s1 = intent.getStringExtra("player1")
                   var text = s1 + " Won"
                   updateText(text)
                   player1count++
                   updateName()

                   break

               } else if (boardCurrent[i][0] == 0) {
                   var s2 = intent.getStringExtra("player2")
                   var text = s2 + " Won "
                   updateText(text)
                   player2count++
                   updateName()
                   break
               }
           }
           if (boardCurrent[0][i] == boardCurrent[1][i] && boardCurrent[0][i] == boardCurrent[2][i]) {
               if (boardCurrent[0][i] == 1) {
                   var s1 = intent.getStringExtra("player1")
                   var text = s1 + " Won"
                   updateText(text)
                   player1count++
                   updateName()
                   break

               } else if (boardCurrent[0][i] == 0) {
                   var s2 = intent.getStringExtra("player2")
                   var text = s2 + " Won "
                   updateText(text)
                   player2count++
                   updateName()
                   break
               }
           }
       }
           if(boardCurrent[0][0]==boardCurrent[1][1] && boardCurrent[0][0]==boardCurrent[2][2]){
               if (boardCurrent[0][0]==1){
                   var  s1= intent.getStringExtra("player1")
                   var text=s1 + " Won"
                   updateText(text)
                   player1count++
                   updateName()


               }
               else if(boardCurrent[0][0]==0){
                   var  s2= intent.getStringExtra("player2")
                   var text= s2 + " Won "
                   updateText(text)
                   player2count++
                   updateName()

               }
           }
           if(boardCurrent[0][2]==boardCurrent[1][1] && boardCurrent[0][2]==boardCurrent[2][0]){
               if (boardCurrent[0][2]==1){
                   var  s1= intent.getStringExtra("player1")
                   var text=s1 + " Won"
                   updateText(text)
                   player1count++
                   updateName()


               }
               else if(boardCurrent[0][2]==0){
                   var  s2= intent.getStringExtra("player2")
                   var text= s2 + " Won "
                   updateText(text)
                   player2count=player2count+1
                   updateName()

               }
           }

    }

    private fun updateText(text: String) {
        updateetv.setText(text)
        if(text.contains("Won")){
            disablebutton()

        }

    }

    private fun disablebutton() {
        for(i in board){
            for(button in i){
                button.isEnabled = false


            }
        }

    }


    private fun updatevalue(row: Int, col: Int, player: Boolean) {
        val text1 =if(player) "X" else "O"
        val value1 =if(player) 1 else 0

        board[row][col].apply {
            isEnabled=false
            setText(text1)
        }
        boardCurrent[row][col]=value1

    }
}