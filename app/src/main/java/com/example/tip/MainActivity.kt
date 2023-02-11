package com.example.tip

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.tip.ui.theme.TipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TipScreen()
                }
            }
        }
    }
}

//fun cal(number: Int): String =
//     (0.15 * number).toString()




@Composable
fun TipScreen() {
    var amount by remember { mutableStateOf("") }
    var tip by remember { mutableStateOf("") }

    val context = LocalContext.current

    fun updateAmount(s: String){
        amount =s
    }

    fun cal(num: Double){
        //return 15.div(100).times(num).toString()
        tip = "KES " + num.times(0.15)
        Toast.makeText(context, tip, Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tip Calculator")
        TextField(
            value = amount,
            onValueChange = {amount =it},
            keyboardOptions =  KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {
            cal(amount.toDouble())
        }) {
            Text(text = "Generate")
        }
        Text(text = tip)

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipTheme {
        TipScreen()
    }
}