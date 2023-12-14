package com.example.jetpackstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
                Surface {
                    MessageCard(msg = Message(author = "test author", content = "test content"))
                }
            }
        }
    }

    @Composable
    fun Test() {
        Text(text = "hello world!")
    }

    @Composable
    @Preview
    fun PreviewMessage() {
        MessageCard(msg = Message(author = "test author", content = "test content"))
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
            )

            Spacer(modifier = Modifier.width(Dp(8.0f)))

            Column {
                Text(text = msg.author)
                Spacer(modifier = Modifier.height(Dp(4.0f)))
                Text(text = msg.content)
            }

        }
    }
}