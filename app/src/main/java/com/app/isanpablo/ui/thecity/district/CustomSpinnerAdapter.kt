package com.app.isanpablo.ui.thecity.district

//noinspection SuspiciousImport
import android.R.*
import android.R.id.*
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.app.isanpablo.R
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

@Suppress("DEPRECATION")
class CustomSpinnerAdapter(
    context: Context,
    items: Array<String>
) : ArrayAdapter<String>(context, layout.simple_spinner_item, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Reuse convertView if it is not null, otherwise inflate a new view
        val view: View = convertView ?: super.getView(position, convertView, parent)

        // Find the TextView
        val textView = view.findViewById<TextView>(android.R.id.text1)

        // Set the text color
        textView.setTextColor(ContextCompat.getColor(context, R.color.white))

        // Set the text size
        textView.textSize = 16f

        // Set the typeface
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