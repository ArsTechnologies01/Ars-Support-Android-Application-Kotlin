package com.example.arstrack.activity.servicesection.complaints

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

class NewComplaintActivity : AppCompatActivity() {
    var Groups = arrayOf("Group 1", "Group 2", "Group 3", "Group 4", "Group 5")
    var CategoryS = arrayOf("Category 1", "Category 2", "Category 3", "Category 4", "Category 5")
    var Products = arrayOf("Product 1", "Product 2", "Product 3", "Product 4", "Product 5")
    var Problems = arrayOf("Problems 1", "Problems 2", "Problems 3", "Problems 4", "Problems 5")
    var GroupAutoCompleteTV: AutoCompleteTextView? = null
    var SubCategoryAutoCompleteTV: AutoCompleteTextView? = null
    var ProductAutoCompleteTV: AutoCompleteTextView? = null
    var ProblemAutoCompleteTV: AutoCompleteTextView? = null
    var adapterGroup: ArrayAdapter<String>? = null
    var adapterCategory: ArrayAdapter<String>? = null
    var adapterProduct: ArrayAdapter<String>? = null
    var adapterProblem: ArrayAdapter<String>? = null
    var toolbar: Toolbar? = null
    var ComplaintConfirmButton: Button? = null
    var ComplaintConfirmFinalButton: Button? = null
    var ConfirmContactComplaintCloseIV: ImageButton? = null
    var ConfirmComplaintCloseIV: ImageButton? = null
    var ComplaintDialog: Dialog? = null
    var ComplaintDialog1: Dialog? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_complaint)

        /* --------------DialogBox--------------- */

        ComplaintDialog = Dialog(this)
        ComplaintDialog!!.setContentView(R.layout.confirm_complaint_dialogbox_layout)

        /* --------------DialogBox1--------------- */

        ComplaintDialog1 = Dialog(this)
        ComplaintDialog1!!.setContentView(R.layout.confirm_complaint_final_dialogbox_layout)

        /* --------------Hooks--------------- */

        toolbar = findViewById(R.id.NewComplaintScreenToolbar)
        GroupAutoCompleteTV = findViewById(R.id.Group_Auto_Complete_TV)
        SubCategoryAutoCompleteTV = findViewById(R.id.Sub_Category_Auto_Complete_TV)
        ProductAutoCompleteTV = findViewById(R.id.Product_Auto_Complete_TV)
        ProblemAutoCompleteTV = findViewById(R.id.Problem_Auto_Complete_TV)
        ComplaintConfirmButton = ComplaintDialog!!.findViewById(R.id.Complaint_Confirm_Button)
        ComplaintConfirmFinalButton =
            ComplaintDialog1!!.findViewById(R.id.Complaint_Confirm_Final_Button)
        ConfirmContactComplaintCloseIV =
            ComplaintDialog!!.findViewById(R.id.Confirm_Contact_Complaint_Close_IV)
        ConfirmComplaintCloseIV = ComplaintDialog1!!.findViewById(R.id.Confirm_Complaint_Close_IV)

        /* --------------Toolbar--------------- */

        setSupportActionBar(toolbar)
        Objects.requireNonNull(supportActionBar)?.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        /* --------------Group--------------- */

        adapterGroup = ArrayAdapter(this, R.layout.dropdown, Groups)
        GroupAutoCompleteTV?.setAdapter(adapterGroup)

        /* --------------Category--------------- */

        adapterCategory = ArrayAdapter(this, R.layout.dropdown, CategoryS)
        SubCategoryAutoCompleteTV?.setAdapter(adapterCategory)

        /* --------------Product--------------- */

        adapterProduct = ArrayAdapter(this, R.layout.dropdown, Products)
        ProductAutoCompleteTV?.setAdapter(adapterProduct)

        /* --------------Problem--------------- */

        adapterProblem = ArrayAdapter(this, R.layout.dropdown, Problems)
        ProblemAutoCompleteTV?.setAdapter(adapterProblem)

        /* --------------Handle onClicks on  Button------------------- */

        findViewById<View>(R.id.AddNewComplaintButton).setOnClickListener { ComplaintDialog!!.show() }

        /* --------------Handle onClicks on  dialogBox------------------- */

        ComplaintConfirmButton?.setOnClickListener(
            View.OnClickListener {
                ComplaintDialog1!!.show()
                ComplaintDialog!!.dismiss()
            })

        /* --------------Handle onClicks on  dialogBox Close Button------------------- */

        ConfirmContactComplaintCloseIV?.setOnClickListener(
            View.OnClickListener { ComplaintDialog!!.dismiss() })

        /* --------------Handle onClicks on  dialogBox1------------------- */

        ComplaintConfirmFinalButton?.setOnClickListener(
            View.OnClickListener {
                ComplaintDialog1!!.dismiss()
                finish()
            })

        /* --------------Handle onClicks on  dialogBox1 Close Button------------------- */

        ConfirmComplaintCloseIV?.setOnClickListener(
            View.OnClickListener {
                ComplaintDialog1!!.dismiss()
                finish()
            })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}