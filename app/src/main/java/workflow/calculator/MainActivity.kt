package workflow.calculator

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    private var canPlacePoint = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        result.text = savedInstanceState.getString("result")
        inputExpression.text = savedInstanceState.getString("expr")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("result", result.text.toString())
        outState.putString("expr", inputExpression.text.toString())
        super.onSaveInstanceState(outState)
    }

    fun numberPush(view: View) {
        val strToAdd = findViewById<Button>(view.id).text.toString()

        if (strToAdd != ".") {
            result.append(findViewById<Button>(view.id).text)
        } else if (strToAdd == "." && canPlacePoint) {
            result.append(findViewById<Button>(view.id).text)
            canPlacePoint = false
        }
    }

    fun actionPush(view: View) {
        result.append(findViewById<Button>(view.id).text)
        canPlacePoint = true
    }

    fun equalPush(view: View) {
        val inputLine = result.text.toString()
        canPlacePoint = false

        val expr = Expression(inputLine)
        val checkExpr = expr.calculate().toString()

        if (checkExpr == "NaN") {
            val warning = Toast.makeText(this, "Invalid Expression", Toast.LENGTH_SHORT)
            warning.setGravity(Gravity.BOTTOM, 0, 0)
            warning.show()
        } else {
            inputExpression.text = inputLine
            result.text = expr.calculate().toString()
        }
    }

    fun clrAll(view: View) {
        inputExpression.text = ""
        result.text = ""
        canPlacePoint = true
    }

    fun backspacePush(view: View) {
        val lengthOfExpression = result.text.length

        if (lengthOfExpression > 0) {

            if (result.text.toString()[lengthOfExpression - 1] == '.') {
                canPlacePoint = true
            }

            result.text = result.text.substring(0, lengthOfExpression - 1)
        }
    }


}