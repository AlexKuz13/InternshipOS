package com.alexkuz.exchangerates.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alexkuz.exchangerates.databinding.CurrencyItemBinding
import com.alexkuz.exchangerates.model.Currency
import com.alexkuz.exchangerates.util.diffutil.CurrencyDiffUtil

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    private var items = emptyList<Currency>()

    class ViewHolder(private val binding: CurrencyItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(currency: Currency) {
            binding.tvSymbol.text = currency.symbols
            val exRate = "${currency.exchange_rate} ₽"
            binding.tvExchangeRate.text = exRate
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CurrencyItemBinding.inflate(layoutInflater, parent, false)
        binding.root.layoutParams = ViewGroup.LayoutParams((parent.width * 0.33).toInt(),ViewGroup.LayoutParams.WRAP_CONTENT)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setData(list: List<Currency>) {
        val currenciesDiffUtil = CurrencyDiffUtil(items, list)
        val diffUtilResult = DiffUtil.calculateDiff(currenciesDiffUtil)
        items = list
        diffUtilResult.dispatchUpdatesTo(this)
    }
}