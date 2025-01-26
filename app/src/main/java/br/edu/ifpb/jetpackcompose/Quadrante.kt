package br.edu.ifpb.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifpb.jetpackcompose.ui.theme.JetpackComposeTheme

class Quadrante : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantesText(
                        quadrants = listOf(
                            Quadrant(
                                title = "Text composable",
                                content = "Displays text and follows the recommended Material Design guidelines.",
                                backgroundColor = Color(0xFFEADDFF)
                            ),
                            Quadrant(
                                title = "Image composable",
                                content = "Creates a composable that lays out and draws a given Painter class object.",
                                backgroundColor = Color(0xFFD0BCFF)
                            ),
                            Quadrant(
                                title = "Row composable",
                                content = "A layout composable that places its children in a horizontal sequence.",
                                backgroundColor = Color(0xFFB69DF8)
                            ),
                            Quadrant(
                                title = "Column composable",
                                content = "A layout composable that places its children in a vertical sequence.",
                                backgroundColor = Color(0xFFF6EDFF)
                            )
                        )
                    )
                }
            }
        }
    }
}

data class Quadrant(
    val title: String,
    val content: String,
    val backgroundColor: Color
)

@Composable
fun QuadrantesText(quadrants: List<Quadrant>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        quadrants.chunked(2).forEach { rowQuadrants ->
            Row(modifier = Modifier.weight(1f).fillMaxWidth()) {
                rowQuadrants.forEach { quadrant ->
                    QuadrantBox(
                        title = quadrant.title,
                        content = quadrant.content,
                        backgroundColor = quadrant.backgroundColor,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun QuadrantBox(
    title: String,
    content: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantesPreview() {
    JetpackComposeTheme {
        QuadrantesText(
            quadrants = listOf(
                Quadrant(
                    title = "Text composable",
                    content = "Displays text and follows the recommended Material Design guidelines.",
                    backgroundColor = Color(0xFFEADDFF)
                ),
                Quadrant(
                    title = "Image composable",
                    content = "Creates a composable that lays out and draws a given Painter class object.",
                    backgroundColor = Color(0xFFD0BCFF)
                ),
                Quadrant(
                    title = "Row composable",
                    content = "A layout composable that places its children in a horizontal sequence.",
                    backgroundColor = Color(0xFFB69DF8)
                ),
                Quadrant(
                    title = "Column composable",
                    content = "A layout composable that places its children in a vertical sequence.",
                    backgroundColor = Color(0xFFF6EDFF)
                )
            )
        )
    }
}
