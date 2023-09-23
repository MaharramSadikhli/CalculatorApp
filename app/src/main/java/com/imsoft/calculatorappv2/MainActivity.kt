package com.imsoft.calculatorappv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.imsoft.calculatorappv2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var operator = "*"
    private var oldNum = ""
    private var newOperator = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun getBtnVal (view: View) {

        if (newOperator) {
            binding.showResult.setText("")
        }

        newOperator = false

        val getBtn = view as Button
        var btnVal: String = binding.showResult.text.toString()

        when(getBtn.id) {
            binding.zero.id -> btnVal+="0"
            binding.one.id -> btnVal+="1"
            binding.two.id -> btnVal+="2"
            binding.three.id -> btnVal+="3"
            binding.four.id -> btnVal+="4"
            binding.five.id -> btnVal+="5"
            binding.six.id -> btnVal+="6"
            binding.seven.id -> btnVal+="7"
            binding.eight.id -> btnVal+="8"
            binding.nine.id -> btnVal+="9"
            binding.plusminus.id -> btnVal = "-$btnVal"
        }

        binding.showResult.setText(btnVal)
    }

    fun getOperation (view: View) {
        val getBtn = view as Button

        when(getBtn.id) {
            binding.sum.id -> operator = "+"
            binding.difference.id -> operator = "-"
            binding.multiply.id -> operator = "x"
            binding.divide.id -> operator = "/"
        }

        oldNum = binding.showResult.text.toString()
        newOperator = true
    }



    fun getEqual (view: View) {
        val newNum = binding.showResult.text.toString()
        var resultNum: Double? = null

        when(operator) {
            "+" -> resultNum = oldNum.toDouble() + newNum.toDouble()
            "-" -> resultNum = oldNum.toDouble() - newNum.toDouble()
            "x" -> resultNum = oldNum.toDouble() * newNum.toDouble()
            "/" -> resultNum = oldNum.toDouble() / newNum.toDouble()
        }

        binding.showResult.setText(resultNum.toString())
        newOperator = true
    }

    fun getReset (view: View) {
        binding.showResult.setText("0")
        newOperator = true
    }

    fun getPercent (view: View) {
        val num: Double = binding.showResult.text.toString().toDouble() / 100
        binding.showResult.setText(num.toString())
        newOperator = true
    }
}