package com.example.jetpackstudy

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.jetpackstudy.theme.JetPackStudyTheme


class MainActivity : ComponentActivity() {

    data class Message(val author : String, val content : String)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Test()
            JetPackStudyTheme {
//                Surface(modifier = Modifier.fillMaxSize()) {
//                    MessageCard(msg = Message(author = "real author", content = "real content"))
//                }

                //(messages = SampleData.conversationSample)
                ButtonList()
            }
        }
    }

    @Composable
    fun ButtonList() {
        Text(
            modifier = Modifier
                .clickable {
                    val intent = Intent(this, CodeLabActivity::class.java)
                    startActivity(intent)
                }
                .padding(Dp(10f))
                .padding(Dp(10f))
                .background(Color.Yellow)
                .padding(Dp(10f))
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "codelab study"
        )
    }


    @Composable
    fun Test() {
        Text(text = "hello world!")
    }

    @Composable
    @Preview(name = "Light Mode",
        showBackground = true,
        uiMode = Configuration.UI_MODE_NIGHT_NO
    )
    @Preview(
        name = "Dark Mode",
        showBackground = true,
        uiMode = Configuration.UI_MODE_NIGHT_YES
    )
    fun PreviewMessage() {
        JetPackStudyTheme {
            Surface {
                MessageCard(msg = Message(author = "test author", content = "test content"))
            }
        }
    }

    @Composable
    fun MessageCard(msg : Message) {
        // 요소 가로 정렬 시 이용
        Row(Modifier.padding(all = Dp(8.0f))) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "description",
                modifier = Modifier
                    .size(Dp(40f))
                    .clip(CircleShape)
                    .border(
                        width = Dp(1.5f),
                        color = MaterialTheme.colorScheme.primary,
                        CircleShape
                    )
            )

            Spacer(modifier = Modifier.width(Dp(8.0f)))

            // We keep track if the message is expanded or not in this
            // variable
            var isExpend by remember { mutableStateOf(false) }
            // surfaceColor will be updated gradually from one color to the other
            val surfaceColor by animateColorAsState(
                if(isExpend) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                label = "surface color"
            )

            Column(modifier = Modifier.clickable { isExpend = !isExpend }) {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.height(Dp(4.0f)))

                Surface(shape = MaterialTheme.shapes.medium,
                    shadowElevation = Dp(1f),
                    color = surfaceColor,
                    modifier = Modifier.animateContentSize().padding(Dp(1f))
                ) {
                    Text(
                        text = msg.content,
                        modifier = Modifier.padding(Dp(4f)),
                        maxLines = if(isExpend) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

            }

        }
    }

    @Composable
    fun Conversation(messages: List<Message>) {
        LazyColumn {
            items(messages) { message ->
                MessageCard(message)
            }
        }
    }

    @Composable
    fun PreviewConversation() {
        JetPackStudyTheme {
            Conversation(messages = SampleData.conversationSample)
        }
    }

    object SampleData {

        // Sample conversation data
        val conversationSample = listOf(
            Message(
                "Lexi",
                "Test...Test...Test..."
            ),
            Message(
                "Lexi",
                """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim()
            ),
            Message(
                "Lexi",
                """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim()
            ),
            Message(
                "Lexi",
                "Searching for alternatives to XML layouts..."
            ),
            Message(
                "Lexi",
                """Hey, take a look at Jetpack Compose, it's great!
            |It's the Android's modern toolkit for building native UI.
            |It simplifies and accelerates UI development on Android.
            |Less code, powerful tools, and intuitive Kotlin APIs :)""".trim()
            ),
            Message(
                "Lexi",
                "It's available from API 21+ :)"
            ),
            Message(
                "Lexi",
                "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
            ),
            Message(
                "Lexi",
                "Android Studio next version's name is Arctic Fox"
            ),
            Message(
                "Lexi",
                "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
            ),
            Message(
                "Lexi",
                "I didn't know you can now run the emulator directly from Android Studio"
            ),
            Message(
                "Lexi",
                "Compose Previews are great to check quickly how a composable layout looks like"
            ),
            Message(
                "Lexi",
                "Previews are also interactive after enabling the experimental setting"
            ),
            Message(
                "Lexi",
                "Have you tried writing build.gradle with KTS?"
            ),
        )
    }

}

