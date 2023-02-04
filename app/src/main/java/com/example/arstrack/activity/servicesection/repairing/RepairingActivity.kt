package com.example.arstrack.activity.servicesection.repairing

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar
import com.example.arstrack.R
import java.util.*

class RepairingActivity : AppCompatActivity() {
    var toolbar: Toolbar? = null
    var ProductCategory =
        arrayOf("Category 1", "Category 2", "Category 3", "Category 4", "Category 5")
    var ProblemCategory = arrayOf("Problem 1", "Problem 2", "Problem 3", "Problem 4", "Problem 5")
    var RepairingProductCategoryAutoCompleteTV: AutoCompleteTextView? = null
    var RepairingSelectProblemAutoCompleteTV: AutoCompleteTextView? = null
    var adapterProductCategory: ArrayAdapter<String>? = null
    var adapterProblemCategory: ArrayAdapter<String>? = null
    var RepairingConfirmButton: Button? = null
    var RepairingConfirmFinalButton: Button? = null
    var ConfirmContactRepairingCloseIV: ImageButton? = null
    var ConfirmRepairingCloseIV: ImageButton? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repairing)

        /* --------------DialogBox--------------- */

        val dialog = Dialog(this)
        val dialog1 = Dialog(this)
        dialog.setContentView(R.layout.confirm_contact_repairing_dialog_box_layout)
        dialog1.setContentView(R.layout.confirm_repairing_dailog_box_layout)

        /* --------------Hooks--------------- */

        toolbar = findViewById(R.id.RepairingScreenToolbar)
        RepairingProductCategoryAutoCompleteTV =
            findViewById(R.id.Repairing_Product_Category_Auto_Complete_TV)
        RepairingSelectProblemAutoCompleteTV =
            findViewById(R.id.Repairing_Select_Problem_Auto_Complete_TV)
        RepairingConfirmButton = dialog.findViewById(R.id.Repairing_Confirm_Button)
        ConfirmContactRepairingCloseIV =
            dialog.findViewById(R.id.Confirm_Contact_Repairing_Close_IV)
        RepairingConfirmFinalButton = dialog1.findViewById(R.id.Repairing_Confirm_Final_Button)
        ConfirmRepairingCloseIV = dialog1.findViewById(R.id.Confirm_Repairing_Close_IV)
        /* --------------Toolbar--------------- */
        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)?.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        /* --------------Repairing_Product_Category--------------- */

        adapterProductCategory =
            ArrayAdapter(this, R.layout.dropdown, ProductCategory)
        RepairingProductCategoryAutoCompleteTV?.setAdapter(adapterProductCategory)

        /* --------------Repairing_Problem_Category--------------- */
        adapterProblemCategory =
            ArrayAdapter(this, R.layout.dropdown, ProblemCategory)
        RepairingSelectProblemAutoCompleteTV?.setAdapter(adapterProblemCategory)

        /* --------------Handle onClicks on  Button------------------- */

        findViewById<View>(R.id.Click_To_Proceed_button).setOnClickListener { dialog.show() }

        /* --------------Handle onClicks on  DialogBox------------------- */

        RepairingConfirmButton?.setOnClickListener(
            View.OnClickListener {
                dialog1.show()
                dialog.dismiss()
            })

        /* --------------Handle onClicks on  DialogBox Close Button------------------- */

        ConfirmContactRepairingCloseIV?.setOnClickListener(
            View.OnClickListener { dialog.dismiss() })

        /* --------------Handle onClicks on  DialogBox1------------------- */

        RepairingConfirmFinalButton?.setOnClickListener(
            View.OnClickListener {
                dialog1.dismiss()
                finish()
            })

        /* --------------Handle onClicks on  DialogBox1 Close Button------------------- */

        ConfirmRepairingCloseIV?.setOnClickListener(
            View.OnClickListener {
                dialog1.dismiss()
                finish()
            })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}