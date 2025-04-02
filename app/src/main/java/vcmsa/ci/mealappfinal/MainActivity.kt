package vcmsa.ci.mealappfinal

import android.os.Bundle
import android.view.Display
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()  {

    private lateinit var periodInputField: EditText
    private lateinit var recommendationDisplay: TextView
    private lateinit var getRecommendationBtn: Button
    private lateinit var clearFieldsBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeComponents()
        setupInteractions()

    }
    private fun initializeComponents() {

        periodInputField = findViewById(R.id.periodEntry)
        recommendationDisplay = findViewById(R.id.recommendationText)
        getRecommendationBtn = findViewById(R.id.fetchRecommendation)
        clearFieldsBtn = findViewById(R.id.clearAll)

    }
    private fun setupInteractions() {

        getRecommendationBtn.setOnClickListener() {
            provideFoodRecommendation()
        }

        clearFieldsBtn.setOnClickListener() {
            clearAllFields()
        }
        // Set focus change listener for the time of the day input field
        periodInputField.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus && periodInputField.text.isNotEmpty()) {
                provideFoodRecommendation()
            }
        }
    }
    private fun provideFoodRecommendation() {
        val dayPeriod = periodInputField.text.toString().trim().lowercase()

        val recommendedMeal = when (dayPeriod) {
            "Morning" -> "Eggs and Bacon"
            "Mid-morning" -> "Fruits"
            "Afternoon" -> "Chicken and Tomato Sandwich"
            "Mid-afternoon" -> "Mac and Cheese"
            "Dinner" -> "Pasta"
            "Dessert" -> "Malva Pudding"
            else ->{
                showInputError()
                return
            }
        }

        recommendationDisplay.text = "We recommend: $recommendedMeal"

    }
    private fun showInputError() {
        recommendationDisplay.text = "Please enter a valid  day period"
        periodInputField.error = "Try: 'Morning', 'Mid-morning', 'Afternoon', 'Mid-afternoon', 'Dinner', 'Dessert'"
        Toast.makeText(
            this,
            "Valid options:'Morning', 'Mid-morning', 'Afternoon', 'Mid-afternoon', 'Dinner', 'Dessert'",
            Toast.LENGTH_LONG
        ).show()
    }




