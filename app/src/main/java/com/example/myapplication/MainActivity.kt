package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    var texto : TextView ?= null
    var isParenthesisPressed : Boolean ?= false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.textView)

        //Add events to numbers 1-9
        val btn1 : Button = findViewById(R.id.b1)
        btn1.setOnClickListener{numberPressed(btn1.text.toString())}
        val btn2 : Button = findViewById(R.id.b2)
        btn2.setOnClickListener{numberPressed(btn2.text.toString())}
        val btn3 : Button = findViewById(R.id.b3)
        btn3.setOnClickListener{numberPressed(btn3.text.toString())}
        val btn4 : Button = findViewById(R.id.b4)
        btn4.setOnClickListener{numberPressed(btn4.text.toString())}
        val btn5 : Button = findViewById(R.id.b5)
        btn5.setOnClickListener{numberPressed(btn5.text.toString())}
        val btn6 : Button = findViewById(R.id.b6)
        btn6.setOnClickListener{numberPressed(btn6.text.toString())}
        val btn7 : Button = findViewById(R.id.b7)
        btn7.setOnClickListener{numberPressed(btn7.text.toString())}
        val btn8 : Button = findViewById(R.id.b8)
        btn8.setOnClickListener{numberPressed(btn8.text.toString())}
        val btn9 : Button = findViewById(R.id.b9)
        btn9.setOnClickListener{numberPressed(btn9.text.toString())}
        val btn0 : Button = findViewById(R.id.b0)
        btn0.setOnClickListener{numberPressed(btn0.text.toString())}

        val btnPercentage : Button = findViewById(R.id.percentage)
        btnPercentage.setOnClickListener{numberPressed(btnPercentage.text.toString())}
        val btnDivider : Button = findViewById(R.id.divider)
        btnDivider.setOnClickListener{numberPressed(btnDivider.text.toString())}
        val btnMultiply : Button = findViewById(R.id.multiplier)
        btnMultiply.setOnClickListener{numberPressed("*")}
        val btnMinus : Button = findViewById(R.id.minus)
        btnMinus.setOnClickListener{numberPressed(btnMinus.text.toString())}
        val btnSum : Button = findViewById(R.id.sum)
        btnSum.setOnClickListener{numberPressed(btnSum.text.toString())}
        val btnDot : Button = findViewById(R.id.dot)
        btnDot.setOnClickListener{numberPressed(btnDot.text.toString())}

        //Add events to C key "erase"
        val btnC : Button = findViewById(R.id.C)
        btnC.setOnClickListener{cPressed()}

        //Add events to Parenthesis keys
        val btnParenthesis : Button = findViewById(R.id.parenthesis)
        btnParenthesis.setOnClickListener{parenthesisPressed()}

        //Add events to Erase key
        val btnErase : Button = findViewById(R.id.erase)
        btnErase.setOnClickListener{eraseIsPressed()}

        //Add events to Equal key
        val btnEquals : Button = findViewById(R.id.equals)
        btnEquals.setOnClickListener{equalIsPressed()}

        //Add events to wtf key
        val btnWtf : Button = findViewById(R.id.wtf)
        btnWtf.setOnClickListener{wtfIsPressed()}
    }

    private fun numberPressed(buttonNumber : String) {
        texto?.text = texto?.text.toString() + buttonNumber
    }

    private fun cPressed() {
        texto?.text = ""
    }

    private fun parenthesisPressed() {
        val parType : String = if (isParenthesisPressed == true) ")" else "("
        isParenthesisPressed = !isParenthesisPressed!!
        texto?.text = texto?.text.toString() + parType
    }

    private fun eraseIsPressed() {
        var size : Int = texto?.text?.length ?: 0
        if (texto?.text?.takeLast(1) == "(" || texto?.text?.takeLast(1) == ")")
        {
            isParenthesisPressed = !isParenthesisPressed!!
        }
        texto?.text = texto?.text?.dropLast(1)
    }

    private fun equalIsPressed() {
        var expression : Expression = Expression(texto?.text.toString())
        texto?.text = expression.calculate().toString()
    }

    private fun wtfIsPressed() {
        Toast.makeText(this, "Upcoming Feature",Toast.LENGTH_SHORT).show()
    }
}