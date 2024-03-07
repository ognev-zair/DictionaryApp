package com.demo.dictionarytestapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.dictionarytestapp.network.translation.NetworkTranslationHelper
import com.demo.dictionarytestapp.ui.model.TranslationModel
import java.lang.Exception

class TranslationViewModel : ViewModel() {
    private val _translatedItems = MutableLiveData<List<TranslationModel>>(emptyList())
    val translatedItems: LiveData<List<TranslationModel>> = _translatedItems

    fun translate(text: String) {
        NetworkTranslationHelper.translate(
            text,
            object : NetworkTranslationHelper.TranslationListener {
                override fun onTranslationSuccess(translationList: List<TranslationModel>) {
                    _translatedItems.value = translationList
                }

                override fun onTranslationFailure(exception: Exception) {

                }

            })

    }
}