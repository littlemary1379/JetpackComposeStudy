package com.example.jetpackstudy

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp


class MainActivity : ComponentActivity() {

    data class Message(val author : String, val content : String)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Test()
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(msg = Message(author = "real author", content = "real content"))
                }
            }
        }
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
        MaterialTheme {
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

            Column {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.height(Dp(4.0f)))

                Surface(shape = MaterialTheme.shapes.medium, shadowElevation = Dp(1f)) {
                    Text(
                        text = msg.content,
                        modifier = Modifier.padding(Dp(4f)),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

            }

        }
    }
}