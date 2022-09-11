package workflow.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val buttons = arrayOf(
        R.id.zero,
        R.id.one,
        R.id.two,
        R.id.three,
        R.id.four,
        R.id.five,
        R.id.six,
        R.id.seven,
        R.id.eight,
        R.id.nine
    )

    val actions = arrayOf(
        R.id.comma,
        R.id.plus,
        R.id.minus,
        R.id.negate,
        R.id.multiply,
        R.id.divide,
        R.id.clear_text,
        R.id.clear_symbol
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}