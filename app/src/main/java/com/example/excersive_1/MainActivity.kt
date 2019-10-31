package com.example.excersive_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener {
            //val =  value or var = variable
            val car_price = editTextCarPrice.text.toString().toInt()
            val down_payment = editTextDownPayment.text.toString().toInt()
            val loan_period = editTextLoanPeriod.text.toString().toInt()
            val interest_rate = editTextInterestRate.text.toString().toFloat()

            if (car_price.length ==0)
            {
                editTextCarPrice.setError("Please Enter Car Price")
                return
            }
            if (down_payment.length ==0)
            {
                editTextDownPayment.setError("Please Enter Down Payment")
                return
            }
            if (loan_period.length ==0)
            {
                editTextLoanPeriod.setError("Please Enter Loan Period")
                return
            }
            if (interest_rate.length ==0)
            {
                editTextInterestRate.setError("Please Enter Interest Rate")
                return
            }

            //TODO: Continue your calculation here
            //TODO: Find the locale of the user and display the currency sign
            val car_loan = car_price-down_payment
            textViewLoan.text = getString(R.string.loan)+"${car_loan}"
            val interest = car_loan*interest_rate*loan_period
            textViewInterest.text = getString(R.string.interest)+"${interest}"
            val monthly_rrepayment = (car_loan+interest)/loan_period/12
            textViewMonthyPayment.text =getString(R.string.monthly_repayment)+ "${monthly_rrepayment}"

        }
    }

    fun resetInputs(view: View) {
        //TODO : reset all inputs and outputs
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextLoanPeriod.setText("")
        editTextInterestRate.setText("")

        textViewLoan.setText("")
        textViewInterest.setText("")
        textViewMonthyPayment.setText("")
    }
}
