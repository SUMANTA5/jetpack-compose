package com.sumanta.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sumanta.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserList()
        }
    }
}

data class User(
    val id: Int
)

val Users = listOf(
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1)
)

@Composable
fun UserList(){
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//        for (i in 1..10){
//            UserCard()
//        }
//   }
    LazyColumn{
        items(Users){ user ->
            UserCard()
        }
    }
}

@Composable
fun UserCard() {
    val context = LocalContext.current
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.sumanta),
                contentDescription = "",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.app_title),
                    Modifier.padding(5.dp)
                )
                Button(onClick = {
                    Toast.makeText(context, "Click", Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "View Channel")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        UserList()
    }
}