package com.example.assingment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btResult)
        val spinnerVal: Spinner = findViewById(R.id.spinner)
        val emailAddress:EditText = findViewById(R.id.emailAddress)
        val phoneNumber:EditText=findViewById(R.id.phoneNumber)
        var options = arrayOf("Email Address", "Phone Number")
        val Result:TextView=findViewById(R.id.txtView)
        var flag: String = "Email Address"

        spinnerVal.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        button.setOnClickListener { view ->
            if(emailAddress.isVisible)
                Result.text=emailAddress.text;
            else
                Result.text=phoneNumber.text;
        }

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val selectedItem = options[p2]
                if (selectedItem == "Email Address") {
                    emailAddress.visibility = View.VISIBLE
                    phoneNumber.visibility = View.GONE
                } else if (selectedItem == "Phone Number") {
                    phoneNumber.visibility = View.VISIBLE
                    emailAddress.visibility = View.GONE
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Do nothing
            }
        }
    }
}
