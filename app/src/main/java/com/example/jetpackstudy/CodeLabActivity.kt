package com.example.jetpackstudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
                    MyApp()
                }
            }
        }

    }

    @Composable
    fun OnboardingScreen(
        modifier: Modifier = Modifier,
        onContinueClick: () -> Unit
    ) {

        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = {
                    println("???? click ?")
                    onContinueClick()
                }

            ) {
                Text("Continue")
            }
        }
    }

    @Preview(showBackground = true, widthDp = 320, heightDp = 320)
    @Composable
    fun OnboardingPreview() {
        JetPackStudyTheme {
            OnboardingScreen(onContinueClick = {})
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
    ) {
        var shouldShowOnBoarding by rememberSaveable {
            mutableStateOf(true)
        }

        Surface(modifier) {
            if(shouldShowOnBoarding) {
                OnboardingScreen {
                    shouldShowOnBoarding = false
                }
            } else {
                Greetings()
            }
        }

    }

    @Composable
    private fun Greetings(
        modifier: Modifier = Modifier,
        names: List<String> = List(1000) { "$it" }
    ) {
        LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
            items(items = names) {
                Greeting(name = it)
            }
        }
    }

    @Preview(showBackground = true, widthDp = 320)
    @Composable
    private fun GreetingsPreview() {
        JetPackStudyTheme {
            Greetings()
        }
    }

    @Preview
    @Composable
    fun MyAppPreview() {
        JetPackStudyTheme {
            MyApp(Modifier.fillMaxSize())
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

        val expanded = remember {
            mutableStateOf(false)
        }

        val extraPadding = if(expanded.value) 48.dp else 0.dp

        Surface(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Row(modifier = Modifier.padding(24.dp)) {
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
                ) {
                    Text(text = "Hello, ")
                    Text(text = name)
                }

                ElevatedButton(onClick = {
                    expanded.value = !expanded.value
                }) {
                    Text(text = if(expanded.value) "Show more" else "Show less")
                }

            }
        }
    }
    
}