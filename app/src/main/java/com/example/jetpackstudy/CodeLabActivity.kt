package com.example.jetpackstudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.jetpackstudy.theme.JetPackStudyTheme

class CodeLabActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetPackStudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(name = "Android")
                }
            }
        }

    }

    @Composable
    private fun MyApp(modifier: Modifier = Modifier) {
        Surface(
            modifier = modifier,
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting(name = "Android")
        }
    }

    @Preview(showBackground = true, name = "Text Preview")
    @Composable
    private fun DefaultPreview() {
        JetPackStudyTheme {
            MyApp()
        }
    }

    @Composable
    private fun Greeting(name : String) {
        Surface(color = MaterialTheme.colorScheme.primary) {
            //Text(text = "Hello $name", modifier = Modifier.padding(Dp(24f)))
            Column(modifier = Modifier.padding(Dp(24f))) {
                Text(text = "Hello.")
                Text(text = name)
            }
        }
    }
    
}