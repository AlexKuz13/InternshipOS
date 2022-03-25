package com.alexkuz.exchangerates.util

import com.alexkuz.exchangerates.R
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*

class CustomDatePicker(private val cal: Calendar) {

     fun create(): MaterialDatePicker<Long> {
        val constraints = CalendarConstraints.Builder()
            .setValidator(DateValidatorPointBackward.now())
            .build()

        return MaterialDatePicker.Builder.datePicker()
            .setTitleText(R.string.choose_date)
            .setSelection(cal.timeInMillis)
            .setCalendarConstraints(constraints)
            .build()
    }
}