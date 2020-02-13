package com.example.logicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log

class MainActivity : AppCompatActivity() {
    lateinit var valuesA: Array<TextView>;
    lateinit var valuesB: Array<TextView>;
    lateinit var answers: Array<EditText>;
    var amountOfQuestions: Int = 5;
    var amountCorrect: Int = 0;
    lateinit var returnMessage: String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        valuesA = arrayOf(
            findViewById(R.id.tvA1),
            findViewById(R.id.tvA2),
            findViewById(R.id.tvA3),
            findViewById(R.id.tvA4));
        valuesB = arrayOf(
            findViewById(R.id.tvB1),
            findViewById(R.id.tvB2),
            findViewById(R.id.tvB3),
            findViewById(R.id.tvB4));
        answers = arrayOf(
            findViewById(R.id.etAnswer1),
            findViewById(R.id.etAnswer2),
            findViewById(R.id.etAnswer3),
            findViewById(R.id.etAnswer4));
        returnMessage = getString(R.string.super_error);

        initViews();
    }

    private fun initViews() {
        btnSubmit.setOnClickListener {
            if(etAnswer1.text.isNotEmpty() && etAnswer2.text.isNotEmpty() && etAnswer3.text.isNotEmpty() && etAnswer4.text.isNotEmpty()) {
                amountCorrect = 0;
                for(x in 1..amountOfQuestions) {
                    var valueForA = valuesA[x].text.toString();
                    var valueForB = valuesB[x].text.toString();
                    var answerValue = answers[x].text.toString();
                    //var valueForA = findViewById<TextView>(valuesA[x]).text.toString();
                    //var valueForB = findViewById<TextView>(valuesB[x]).text.toString();
                    //var answerValue = findViewById<EditText>(answers[x]).text.toString();
                    //var valueForA = "T";
                    //var valueForB = "T";
                    //var answerValue = "T";
                    Log.d("EA", valueForA);
                    Log.d("EA", valueForB);
                    Log.d("EA", answerValue);
                    if(checkIfCorrect(valueForA, valueForB, answerValue)) {
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
        if((inputA == inputB && inputA == givenAnswer) || (inputA != inputB && givenAnswer.equals(getString(R.string.text_false)))) {
            return true;
        }
        return false;
    }
}