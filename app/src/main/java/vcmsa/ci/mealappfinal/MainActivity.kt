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

