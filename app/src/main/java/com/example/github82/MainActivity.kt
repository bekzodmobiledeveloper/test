package com.example.github82

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.list.checkItem
import com.afollestad.materialdialogs.list.listItemsMultiChoice
import com.example.github82.databinding.ActivityMainBinding
import com.example.github82.databinding.BotomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.datepicker.MaterialDatePicker

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.basic.setOnClickListener {
            MaterialDialog(this).show {
                title(R.string.basic)
                message(R.string.basic_message)

                positiveButton(R.string.basic_agree) {
                    Toast.makeText(applicationContext, "Google Location Agree", Toast.LENGTH_SHORT).show()
                }
                negativeButton(R.string.basic_disagree) {
                    Toast.makeText(applicationContext, "Google Location DisAgree", Toast.LENGTH_SHORT).show()
                    // finish()
                }
            }
        }

        binding.dateTime.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.dateRangePicker().build()
            datePicker.show(supportFragmentManager, "DatePicker")

            // Setting up the event for when ok is clicked
            datePicker.addOnPositiveButtonClickListener {
                Toast.makeText(this, "${datePicker.headerText} is selected", Toast.LENGTH_LONG).show()
            }

            // Setting up the event for when cancelled is clicked
            datePicker.addOnNegativeButtonClickListener {
                Toast.makeText(this, "${datePicker.headerText} is cancelled", Toast.LENGTH_LONG).show()
            }

            // Setting up the event for when back button is pressed
            datePicker.addOnCancelListener {
                Toast.makeText(this, "Date Picker Cancelled", Toast.LENGTH_LONG).show()
            }
        }

        binding.bottomsheet.setOnClickListener {

            val bottomSheetDialog = BottomSheetDialog(
                this@MainActivity, R.style.BottomSheetDialogTheme
            )

            val bottomSheetView = layoutInflater.inflate(R.layout.botom_sheet, null, false)


            val binding1 = BotomSheetBinding.bind(bottomSheetView)
            binding1.checkBox.setOnClickListener {
                if (binding1.checkBox.isChecked) {
                    binding1.password.inputType = 1
                } else {
                    binding1.password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                }
            }


            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }


        binding.args.setOnClickListener {


        }

        binding.choose.setOnClickListener {


        }


        /*   binding.choose.setOnClickListener {

               MaterialDialog(this).show {
                   title(R.string.choice)
                   val check = arrayOf("Twitter", "Google+", "Instagram", "Facebook")
                   val checkedItems = booleanArrayOf(true, false, false, true)

                   listItemsMultiChoice(check,checkedItems) { dialog, indices, items ->
                   }

                   positiveButton(R.string.basic_agree) {
                       Toast.makeText(applicationContext, "Google Location Agree", Toast.LENGTH_SHORT).show()
                   }
                   negativeButton(R.string.basic_disagree) {
                       Toast.makeText(applicationContext, "Google Location DisAgree", Toast.LENGTH_SHORT).show()
                       // finish()
                   }
               }

          *//*     // Set up the alert builder
            val builder = AlertDialog.Builder(applicationContext)
            builder.setTitle("Choose some animals")

// Add a checkbox list
         //   val animals = arrayOf("horse", "cow", "camel", "sheep", "goat")
            val checkedItems = booleanArrayOf(true, false, false, true)
            builder.setMultiChoiceItems(check, checkedItems) { dialog, which, isChecked ->
                // The user checked or unchecked a box
            }

// Add OK and Cancel buttons
            builder.setPositiveButton("OK") { dialog, which ->
                // The user clicked OK
            }
            builder.setNegativeButton("Cancel", null)

// Create and show the alert dialog
            val dialog = builder.create()
            dialog.show()*//*

        }*/






    }
}