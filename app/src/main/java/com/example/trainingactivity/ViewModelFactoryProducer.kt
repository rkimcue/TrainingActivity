package com.example.trainingactivity

import androidx.activity.ComponentActivity
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

object ViewModelFactoryProducer {

    private var testFactory: ViewModelProvider.Factory? = null

    fun getFactory(activity: ComponentActivity): ViewModelProvider.Factory =
        testFactory ?: ProdFactory(activity)

    fun setTestFactory(testFactory: ViewModelProvider.Factory) {
        this.testFactory = testFactory
    }

    class ProdFactory(private val activity: ComponentActivity): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass == MainViewModelInterface::class.java) {
                MainViewModel() as T
            } else {
                activity.defaultViewModelProviderFactory.create(modelClass)
            }
        }
    }
}