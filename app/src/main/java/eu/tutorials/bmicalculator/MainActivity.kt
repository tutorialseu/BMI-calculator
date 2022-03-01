package eu.tutorials.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import eu.tutorials.bmicalculator.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var ageValue: Int = 0
    private var heightValue: Double = 0.0
    private var weightValue: Double = 0.0
    private var bmi:Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val ageEt = binding.ageEt
        val weightEt = binding.weightEt
        val heightEt = binding.heightEt
        binding.agePlusBtn.setOnClickListener {
            if (ageEt.text.toString().isNotEmpty()) {
                ageValue = ageEt.text.toString().toInt()
            }
            ageValue++
            ageEt.setText(ageValue.toString())
        }
        binding.ageMinusBtn.setOnClickListener {
            if (ageEt.text.toString().isNotEmpty()) {
                ageValue = ageEt.text.toString().toInt()
            }
            ageValue--
            ageEt.setText(ageValue.toString())
        }

        binding.heightPlusBtn.setOnClickListener {
            if (heightEt.text.toString().isNotEmpty()) {
            heightValue = heightEt.text.toString().toDouble()
            }
            heightValue++
            heightEt.setText(heightValue.toString())
        }
        binding.heightMinusBtn.setOnClickListener {
            if (heightEt.text.toString().isNotEmpty()) {
                heightValue = heightEt.text.toString().toDouble()
            }
            heightValue--
            heightEt.setText(heightValue.toString())
        }
        binding.weightPlusBtn.setOnClickListener {
            if (weightEt.text.toString().isNotEmpty()){
                weightValue = weightEt.text.toString().toDouble()
            }
            weightValue++
            weightEt.setText(weightValue.toString())
        }
        binding.weightMinusBtn.setOnClickListener {
            if (weightEt.text.toString().isNotEmpty()){
                weightValue = weightEt.text.toString().toDouble()
            }
            weightValue--
            weightEt.setText(weightValue.toString())
            Toast.makeText(this,"$bmi",Toast.LENGTH_LONG).show()
        }


        binding.calculateBtn.setOnClickListener {
            val height = heightEt.text.toString().toDouble()
           val weight = weightEt.text.toString().toDouble()
             bmi =(weight/height.times(height))
            Toast.makeText(this,"$bmi",Toast.LENGTH_LONG).show()
            displayBMIResult(bmi.toFloat())
        }

    }


    private fun displayBMIResult(bmi: Float) {

        val bmiLabel: String
        val bmiDescription: String

        if (bmi.compareTo(15f) <= 0) {
            bmiLabel = "Very severely underweight"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!"
        } else if (bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0
        ) {
            bmiLabel = "Severely underweight"
            bmiDescription = "Oops!You really need to take better care of yourself! Eat more!"
        } else if (bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0
        ) {
            bmiLabel = "Underweight"
            bmiDescription = "Oops! You really need to take better care of yourself! Eat more!"
        } else if (bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0
        ) {
            bmiLabel = "Normal"
            bmiDescription = "Congratulations! You are in a good shape!"
        } else if (bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0
        ) {
            bmiLabel = "Overweight"
            bmiDescription = "Oops! You really need to take care of your yourself! Workout maybe!"
        } else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0
        ) {
            bmiLabel = "Obese Class | (Moderately obese)"
            bmiDescription = "Oops! You really need to take care of your yourself! Workout maybe!"
        } else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0
        ) {
            bmiLabel = "Obese Class || (Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now!"
        } else {
            bmiLabel = "Obese Class ||| (Very Severely obese)"
            bmiDescription = "OMG! You are in a very dangerous condition! Act now!"
        }

        val bmiValue = BigDecimal(bmi.toDouble())
        binding.resultTv.text = resources.getString(R.string.bmi_result,bmiValue,bmiLabel,bmiDescription)
    }

}