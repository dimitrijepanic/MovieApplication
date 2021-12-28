package com.example.movieapplication.main.ui.account

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import com.example.movieapplication.R
import com.example.movieapplication.databinding.FragmentAccountBinding
import com.example.movieapplication.main.MainActivity
import java.util.*


class AccountFragment : Fragment() {
    private lateinit var binding: FragmentAccountBinding
    private lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAccountBinding.inflate(inflater)
        mainActivity = requireActivity() as MainActivity

        addListeners()

        setTitleBar()

        return binding.root
    }

    private fun showDialog() {
        val dialog = Dialog(mainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.date_picker)
        val datepicker = dialog.findViewById(R.id.datePicker) as DatePicker
        val cancel = dialog.findViewById(R.id.cancel) as Button
        val submit = dialog.findViewById(R.id.submit) as Button
        submit.setOnClickListener {

            val month = datepicker.month.toString()
            val year = datepicker.year.toString()
            val day = datepicker.dayOfMonth.toString()
            binding.birthdayInput.setText(day + "." + month + "." + year + ".")
            dialog.dismiss()
        }
        cancel.setOnClickListener { dialog.dismiss() }
        dialog.show()

    }

    private fun addListeners() {
        binding.birthdayInput.setOnClickListener {
            showDialog()
        }
    }

    private fun setTitleBar() {
        mainActivity.hideMenuItem()
        mainActivity.setTitleValue(getString(R.string.account_toolbar_title))
        mainActivity.setIcon()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainActivity.showMenuItem()
    }

}