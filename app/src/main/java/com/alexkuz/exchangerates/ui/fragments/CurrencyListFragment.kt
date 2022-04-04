package com.alexkuz.exchangerates.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.alexkuz.exchangerates.R
import com.alexkuz.exchangerates.adapters.CurrencyAdapter
import com.alexkuz.exchangerates.databinding.FragmentCurrencyListBinding
import com.alexkuz.exchangerates.ui.viewmodels.CurrencyViewModel
import com.alexkuz.exchangerates.util.CustomDatePicker
import com.alexkuz.exchangerates.util.showSnackBar
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DateFormatSymbols
import java.util.*


class CurrencyListFragment : Fragment() {

    private var _binding: FragmentCurrencyListBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy { CurrencyAdapter() }
    private val currencyViewModel by viewModel<CurrencyViewModel>()

    private val cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
    private val year get() = cal.get(Calendar.YEAR)
    private val month get() = cal.get(Calendar.MONTH)
    private val day get() = cal.get(Calendar.DAY_OF_MONTH)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrencyListBinding.inflate(inflater, container, false)

        binding.tieDate.setText(convertDate(day, month, year))

        binding.tieDate.setOnClickListener { openDatePicker() }

        setupRecyclerView()

        return binding.root
    }

    private fun setupRecyclerView() {
        currencyViewModel.currencyListLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressCircular.isVisible = isLoading
        }

        currencyViewModel.onInitCurrencies()
        binding.recyclerView.adapter = adapter

        currencyViewModel.currencyListError.observe(viewLifecycleOwner) {
            showSnackBar(
                binding.root,
                requireContext().getString(R.string.exchange_rates_not_found)
            )
        }

        currencyViewModel.currencyList.observe(viewLifecycleOwner, adapter::setData)
    }

    private fun openDatePicker() {
        val datePicker = CustomDatePicker(cal).create()

        datePicker.addOnPositiveButtonClickListener {
            cal.timeInMillis = it
            binding.tieDate.setText(convertDate(day, month, year))
        }

        datePicker.show(childFragmentManager, "tag")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun convertDate(day: Int, month: Int, year: Int): String {
        return "$day ${DateFormatSymbols().months[month]} $year"
    }

}