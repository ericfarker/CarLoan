package com.example.carloan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculate()
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            clear()
        }
    }

    private fun calculate(){

        val carprice = findViewById<EditText>(R.id.editTextCarPrice).text.toString().toFloat()
        val down = findViewById<EditText>(R.id.editTextDownPayment).text.toString().toFloat()
        val loan = findViewById<EditText>(R.id.editTextLoanPeriod).text.toString().toInt()
        val interest = findViewById<EditText>(R.id.editTextInterestRate).text.toString().toFloat()
        editTextCarPrice.requestFocus()
        editTextDownPayment.requestFocus()
        editTextInterestRate.requestFocus()
        editTextLoanPeriod.requestFocus()

        val viewloan = findViewById<TextView>(R.id.textViewLoan)
        val viewInterest = findViewById<TextView>(R.id.textViewInterest)
        val viewRepay = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        try{

            val carloan = carprice - down
            val carinterest = carloan * (interest/100) * loan
            val carRepay = (carloan + carinterest)/loan/12

            viewloan.text = String.format("Loan:"+"%.2f",carloan)
            viewInterest.text = String.format("Interest:"+ "%.2f",carinterest)
            viewRepay.text = String.format("Monthly Repayment:"+ "%.2f",carRepay)



        }catch (e:Exception){


        }


    }
    private fun clear(){
        findViewById<EditText>(R.id.editTextCarPrice).text = null
        findViewById<EditText>(R.id.editTextDownPayment).text = null
        findViewById<EditText>(R.id.editTextLoanPeriod).text = null
        findViewById<EditText>(R.id.editTextInterestRate).text = null
        findViewById<TextView>(R.id.textViewLoan).text = String.format("Loan:")
        findViewById<TextView>(R.id.textViewInterest).text = String.format("Interest:")
        findViewById<TextView>(R.id.textViewMonthlyRepayment).text = String.format("Monthly Repayment:")

    }

}
