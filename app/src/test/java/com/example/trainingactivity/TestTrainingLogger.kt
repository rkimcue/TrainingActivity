package com.example.trainingactivity

class TestTrainingLogger: TrainingLogger {
    override fun d(tag: String, message: String) {
        println("$tag: $message")
    }
}