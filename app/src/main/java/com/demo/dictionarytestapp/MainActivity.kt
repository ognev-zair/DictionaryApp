package com.demo.dictionarytestapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.demo.dictionarytestapp.ui.model.TranslationModel
import com.demo.dictionarytestapp.ui.main.TranslationFragment
import com.demo.dictionarytestapp.ui.details.TranslationDetailsFragment

class MainActivity : AppCompatActivity(R.layout.main_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            navigateToTranslationFragment()
        }
    }

    private fun navigateToTranslationFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<TranslationFragment>(R.id.fragment_container_view)
        }
    }
}

