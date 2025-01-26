package br.edu.ifpb.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifpb.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        JetPackComposeImage()
                        JetPackCompose(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun JetPackCompose(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Jetpack Compose Tutorial",
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android Ul. Compose simplifies and accelerates Ul development on Android with less code, powerful tools, and intuitive Kotlin APls.",
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = "In this tutorial, you build a simple Ul component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app's Ul programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the Ul's construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
        )
    }

}

@Composable
fun JetPackComposeImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Box(modifier){
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier.padding(top = 25.dp)
        )
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    JetpackComposeTheme {
//        JetPackCompose("Android")
//        JetPackComposeImage()
//    }
//}