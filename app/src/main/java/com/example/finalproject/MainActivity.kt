package com.example.finalproject
import com.example.finalproject.databinding.ActivityMainBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {


    private lateinit var tdeeViewModel: tdeeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tdeeViewModel = ViewModelProvider(this)[tdeeViewModel::class.java]
        val btnCalculate: Button = binding.btnCalculate
        val radioGroupGender: RadioGroup = binding.rgGender
        val radioGroupActivityLevel: RadioGroup = binding.rgActivityLevel
        val editAge: EditText = binding.etAge
        val editHeight: EditText = binding.etHeight
        val editWeight: EditText = binding.etWeight




        btnCalculate.setOnClickListener {
            val gender: Int = when (radioGroupGender.checkedRadioButtonId) {
                R.id.rbMale -> 0
                R.id.rbFemale -> 1
                else -> 0
            }

            val activityLevel: Double = when (radioGroupActivityLevel.checkedRadioButtonId) {
                R.id.rbSedentary -> 0.0
                R.id.rbLight -> 1.0
                R.id.rbModerate -> 2.0
                R.id.rbHeavy -> 3.0
                R.id.rbAthlete -> 4.0
                else -> 0.0
            }

            val age = editAge.text.toString().toIntOrNull() ?: 0
            val heightInInches = editHeight.text.toString().toDoubleOrNull() ?: 0.0
            val weightInPounds = editWeight.text.toString().toDoubleOrNull() ?: 0.0

            val tdee = tdeeViewModel.calculateTDEE(
                gender,
                age,
                heightInInches,
                weightInPounds,
                activityLevel
            )

            val intent = Intent(this, ResultsActivity::class.java)
            intent.putExtra("TDEE", tdee)
            startActivity(intent)

        }
    }

}