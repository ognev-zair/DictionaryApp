package com.demo.dictionarytestapp.network.translation

import android.content.Context
import android.widget.Toast
import com.demo.dictionarytestapp.ui.model.TranslationModel
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.Translator
import com.google.mlkit.nl.translate.TranslatorOptions
import java.lang.Exception


object NetworkTranslationHelper {
    private lateinit var englishSpanishTranslator: Translator

    fun init(context: Context) {
        val options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.SPANISH)
            .build()

        englishSpanishTranslator = Translation.getClient(options)

        val conditions = DownloadConditions.Builder()
            .requireWifi()
            .build()

        englishSpanishTranslator.downloadModelIfNeeded(conditions)
            .addOnSuccessListener {
                Toast.makeText(
                    context,
                    "Dictionary Downloaded, Ready to Translate!",
                    Toast.LENGTH_LONG
                )
                    .show()

            }
            .addOnFailureListener { exception ->

            }

    }

    // Use this function to translate the entered text
    fun translate(text: String, translationListener: TranslationListener) {
        englishSpanishTranslator.translate(text)
            .addOnSuccessListener {
                translationListener.onTranslationSuccess(it.split(" ")
                    .map { translatedText ->
                        TranslationModel(translatedText)
                    })
            }.addOnFailureListener {
                translationListener.onTranslationFailure(it)
            }
    }

    interface TranslationListener {
        fun onTranslationSuccess(translationList: List<TranslationModel>)
        fun onTranslationFailure(exception: Exception)
    }
}