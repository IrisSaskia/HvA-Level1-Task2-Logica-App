package com.example.logicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val valuesA = arrayOf(tvA1, tvA2, tvA3, tvA4);
    private val valuesB = arrayOf(tvB1, tvB2, tvB3, tvB4);
    private val answers = arrayOf(etAnswer1, etAnswer2, etAnswer3, etAnswer4);
    private var amountCorrect: Int = 0;
    private var returnMessage: String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initViews();
    }

    /*private fun initViews() {
        btnSubmit.setOnClickListener {
            if(etAnswer1.text.isNotEmpty() && etAnswer2.text.isNotEmpty() && etAnswer3.text.isNotEmpty() && etAnswer4.text.isNotEmpty()) {
                amountCorrect = 0;
                for ((index, answer) in answers.withIndex()) {
                    if(checkIfCorrect(valuesA[index].text.toString(), valuesB[index].text.toString(), answer.text.toString())) {
                        amountCorrect++;
                    }
                }
                returnMessage = getString(R.string.check_message, amountCorrect);
            } else {
                returnMessage = getString(R.string.error_message);
            }
            updateUI();
        }
    }

    private fun updateUI() {
        Toast.makeText(this, returnMessage, Toast.LENGTH_LONG).show();
    }

    private val checkIfCorrect = fun(inputA: String, inputB: String, givenAnswer: String): Boolean {
        if(inputA == inputB && inputA == givenAnswer) {
            return true;
        } else if(inputA != inputB && getString(R.string.text_false).equals(givenAnswer)) {
            return true;
        } else {
            return false;
        }
    }*/
}
