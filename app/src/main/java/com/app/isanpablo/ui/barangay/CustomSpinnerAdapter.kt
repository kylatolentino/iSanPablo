package com.app.isanpablo.ui.barangay

import android.content.Context
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.app.isanpablo.R

class CustomSpinnerAdapter(
    context: Context,
    private val items: Array<String>
) : ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.setTextColor(context.resources.getColor(R.color.white))
        textView.textSize=14f

        val font = ResourcesCompat.getFont(context, R.font.poppins_semibold)
        textView.typeface = font
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.setTextColor(context.resources.getColor(R.color.black))
        return view
    }
}
