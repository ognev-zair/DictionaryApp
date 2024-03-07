package com.demo.dictionarytestapp.ui.main

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.demo.dictionarytestapp.databinding.FragmentTranslationItemBinding
import com.demo.dictionarytestapp.ui.model.TranslationModel

/**
 * [RecyclerView.Adapter] that can display a [TranslationModel].
 */
class TranslationResultAdapter(
) : RecyclerView.Adapter<TranslationResultAdapter.ViewHolder>() {
    private var items: List<TranslationModel> = emptyList()
    private var onTranslationClickListener: OnTranslationClickListener ? = null

    fun setItems(items: List<TranslationModel>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(onTranslationClickListener: OnTranslationClickListener) {
        this.onTranslationClickListener = onTranslationClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentTranslationItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.contentView.text = item.text
        holder.itemView.setOnClickListener {
            onTranslationClickListener?.onTranslationClicked(item)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(binding: FragmentTranslationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val contentView: TextView = binding.content
    }

    interface OnTranslationClickListener {
        fun onTranslationClicked(translationModel: TranslationModel)
    }
}