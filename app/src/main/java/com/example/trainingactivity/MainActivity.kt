package com.example.trainingactivity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import com.example.trainingactivity.GameMasterRepository.ButtonValue
import com.example.trainingactivity.MainViewModelInterface.HighlightedButtonState

class MainActivity : AppCompatActivity() {
    //val gameMaster = GameMaster()
    val mainViewModel: MainViewModelInterface by viewModels(factoryProducer = {ViewModelFactoryProducer.getFactory(this)})
    lateinit var buttonOne: Button
    lateinit var buttonTwo: Button
    lateinit var buttonThree: Button
    lateinit var buttonFour: Button
    lateinit var textview: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonOne = findViewById(R.id.button_first)
        buttonTwo = findViewById(R.id.button_second)
        buttonThree = findViewById(R.id.button_third)
        buttonFour = findViewById(R.id.button_fourth)
        textview = findViewById(R.id.textview)
        mainViewModel.highlightedButtonStateLiveData.observe(this) {
            when (it) {
                MainViewModelInterface.HighlightedButtonState.None -> {
                    buttonOne.setBackground(getDrawable(R.drawable.ic_button_red))
                    buttonTwo.setBackground(getDrawable(R.drawable.ic_button_green))
                    buttonThree.setBackground(getDrawable(R.drawable.ic_button_yellow))
                    buttonFour.setBackground(getDrawable(R.drawable.ic_button_blue))
                }
                MainViewModelInterface.HighlightedButtonState.RedHighlighted -> {
                    buttonOne.setBackground(getDrawable(R.drawable.ic_button_white))
                    buttonTwo.setBackground(getDrawable(R.drawable.ic_button_green))
                    buttonThree.setBackground(getDrawable(R.drawable.ic_button_yellow))
                    buttonFour.setBackground(getDrawable(R.drawable.ic_button_blue))
                }
                MainViewModelInterface.HighlightedButtonState.GreenHighlighted -> {
                    buttonOne.setBackground(getDrawable(R.drawable.ic_button_red))
                    buttonTwo.setBackground(getDrawable(R.drawable.ic_button_white))
                    buttonThree.setBackground(getDrawable(R.drawable.ic_button_yellow))
                    buttonFour.setBackground(getDrawable(R.drawable.ic_button_blue))
                }
                MainViewModelInterface.HighlightedButtonState.YellowHighlighted -> {
                    buttonOne.setBackground(getDrawable(R.drawable.ic_button_red))
                    buttonTwo.setBackground(getDrawable(R.drawable.ic_button_green))
                    buttonThree.setBackground(getDrawable(R.drawable.ic_button_white))
                    buttonFour.setBackground(getDrawable(R.drawable.ic_button_blue))
                }
                MainViewModelInterface.HighlightedButtonState.BlueHighlighted -> {
                    buttonOne.setBackground(getDrawable(R.drawable.ic_button_red))
                    buttonTwo.setBackground(getDrawable(R.drawable.ic_button_green))
                    buttonThree.setBackground(getDrawable(R.drawable.ic_button_yellow))
                    buttonFour.setBackground(getDrawable(R.drawable.ic_button_white))
                }
                MainViewModelInterface.HighlightedButtonState.AllHighlighted -> {
                    buttonOne.setBackground(getDrawable(R.drawable.ic_button_white))
                    buttonTwo.setBackground(getDrawable(R.drawable.ic_button_white))
                    buttonThree.setBackground(getDrawable(R.drawable.ic_button_white))
                    buttonFour.setBackground(getDrawable(R.drawable.ic_button_white))
                }
            }
        }
        mainViewModel.textviewStateLiveData.observe(this) {
            textview.text = it
        }
        buttonOne.setOnClickListener {
            mainViewModel.checkPlayerInput(ButtonValue.RED)
        }
        buttonTwo.setOnClickListener {
            mainViewModel.checkPlayerInput(ButtonValue.GREEN)
        }
        buttonThree.setOnClickListener {
            mainViewModel.checkPlayerInput(ButtonValue.YELLOW)
        }
        buttonFour.setOnClickListener {
            mainViewModel.checkPlayerInput(ButtonValue.BLUE)
        }
        Log.d("MainActivity", "Launching coroutine")
        mainViewModel.startView()
        Log.d("MainActivity", "Oncreate Finished")
    }
}
