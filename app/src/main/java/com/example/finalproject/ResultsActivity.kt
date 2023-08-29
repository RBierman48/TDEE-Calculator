package com.example.finalproject
import com.example.finalproject.databinding.ActivityResultsBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultsBinding
    private lateinit var fitnessGoalRadioGroup: RadioGroup
    private lateinit var tvResults: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fitnessGoalRadioGroup = binding.rgFitnessGoal
        tvResults = binding.tvResults

        val tdee = intent.getDoubleExtra("TDEE", 0.0)
        val result = "Your Daily Calories is: $tdee per day."
        tvResults.text = result


    }
}