package pl.svgames.blog.RustOnAndroid

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import pl.svgames.blog.RustOnAndroid.RpnCalculator
import pl.svgames.blog.RustOnAndroid.Result

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var input: EditText
    private lateinit var resultBox: TextView

    private val colourRed: Int by lazy { Color.parseColor("#AA0000") }
    private val colourGreen: Int by lazy { Color.parseColor("#007F00") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        input = findViewById(R.id.exprInput)
        resultBox = findViewById(R.id.exprResult)

        button.setOnClickListener {
            val expr = input.text.toString()
            val result = RpnCalculator.rpn(expr)
            if (result.isOk()) {
                resultBox.setTextColor(colourGreen)
                resultBox.text = result.getValue()
            } else {
                resultBox.setTextColor(colourRed)
                resultBox.text = result.getError()
            }
        }
    }
}