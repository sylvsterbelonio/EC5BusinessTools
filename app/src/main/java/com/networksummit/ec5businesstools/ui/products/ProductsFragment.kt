package com.networksummit.ec5businesstools.ui.gallery

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.networksummit.ec5businesstools.R

class ProductsFragment : Fragment() {
    private lateinit var adView : AdView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_products, container, false)


        var dialog_Spinner_Category: Spinner?
        var languages = arrayOf("- Select Category Type -", "French", "Spanish", "Hindi", "Russian", "Telugu", "Chinese", "German", "Portuguese", "Arabic", "Dutch", "Urdu", "Italian", "Tamil", "Persian", "Turkish", "Other")




        val btnMore = root.findViewById(R.id.imgBtnMore) as ImageButton
        btnMore.setOnClickListener {
            // your code to perform when the user clicks on the button
            val dialogBuilder = AlertDialog.Builder(root.context)
            val dialogView = layoutInflater.inflate(R.layout.fragment_products_dialogbox,null)
            val dialog_Spinner_Category = dialogView.findViewById<Spinner>(R.id.spinnerCategory)


            // Create an ArrayAdapter using a simple spinner layout and languages array
            val items = ArrayAdapter(root.context, android.R.layout.simple_spinner_item, languages)
            // Set layout to use when the list of choices appear
            items.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Set Adapter to Spinner
            dialog_Spinner_Category!!.setAdapter(items)



            dialogBuilder.setView(dialogView)
            dialogBuilder.setCancelable(false)

            dialogBuilder.setPositiveButton("Apply", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, id: Int) {
                        Toast.makeText(root.context,"Apply completed!!",Toast.LENGTH_LONG).show()
                }
            })
            dialogBuilder.setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                }
            })


            val customDialog = dialogBuilder.create()
            customDialog.show()




        }















        //var list_of_items = arrayOf("- Select Category -", "Category A", "Category B","Category C")
        //val aa = ArrayAdapter(root.context, android.R.layout.simple_spinner_item, list_of_items)
        //aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //spinner!!.setAdapter(aa)

        adView = root.findViewById<View>(R.id.adViewProducts) as AdView
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        return root

    }
}