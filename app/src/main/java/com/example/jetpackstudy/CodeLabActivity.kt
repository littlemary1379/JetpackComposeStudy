package com.example.jetpackstudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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

//    @Composable
//    private fun MyApp(modifier: Modifier = Modifier) {
//        Surface(
//            modifier = modifier,
//            color = MaterialTheme.colorScheme.background
//        ) {
//            Greeting(name = "Android")
//        }
//    }

    @Composable
    fun MyApp(
        modifier: Modifier = Modifier,
        names: List<String> = listOf("World", "Compose")
    ) {
        Column(modifier = modifier.padding(vertical = Dp(4f))) {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }

    @Preview(showBackground = true, name = "Text Preview", widthDp = 320)
    @Composable
    private fun DefaultPreview() {
        JetPackStudyTheme {
            MyApp()
        }
    }

    @Composable
    private fun Greeting(name: String) {
        Surface(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Row(modifier = Modifier.padding(24.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Hello, ")
                    Text(text = name)
                }

                ElevatedButton(onClick = {}) {
                    Text(text = "Show More")
                }

            }
        }
    }
    
}