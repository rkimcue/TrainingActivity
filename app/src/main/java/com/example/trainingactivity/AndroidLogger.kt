package com.example.trainingactivity

import android.util.Log

class AndroidLogger: TrainingLogger {
    override fun d(tag: String, message: String) {
        Log.d(tag, message)
    }
}