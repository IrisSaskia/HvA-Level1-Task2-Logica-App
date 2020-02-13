package com.example.logicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log

class MainActivity : AppCompatActivity() {
   /* private val valuesA = intArrayOf(R.id.tvA1, R.id.tvA2, R.id.tvA3, R.id.tvA4);
    private val valuesB = intArrayOf(R.id.tvB1, R.id.tvB2, R.id.tvB3, R.id.tvB4);
    private var answers = intArrayOf(R.id.etAnswer1, R.id.etAnswer2, R.id.etAnswer3, R.id.etAnswer4);
    private val amountOfQuestions = 4;*/
    private var amountCorrect: Int = 0;
    private var returnMessage: String = getString(R.string.super_error);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews();
    }

    private fun initViews() {
        btnSubmit.setOnClickListener {
            if(etAnswer1.text.isNotEmpty() && etAnswer2.text.isNotEmpty() && etAnswer3.text.isNotEmpty() && etAnswer4.text.isNotEmpty()) {
                amountCorrect = 0;
                /*for(x in 0..amountOfQuestions) {
                    var valueForA = findViewById<TextView>(valuesA[x]).text.toString();
                    var valueForB = findViewById<TextView>(valuesB[x]).text.toString();
                    var answerValue = findViewById<EditText>(answers[x]).text.toString();
                    //var valueForA = "T";
                    //var valueForB = "T";
                    //var answerValue = "T";
                    Log.d("EA", valueForA);
                    Log.d("EA", valueForB);
                    Log.d("EA", answerValue);
                    if(checkIfCorrect(valueForA, valueForB, answerValue)) {
                        amountCorrect++;
                    }
                }*/
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
        if((inputA == inputB && inputA == givenAnswer) || (inputA != inputB && givenAnswer.equals(getString(R.string.text_false)))) {
            return true;
        }
        return false;
    }
}