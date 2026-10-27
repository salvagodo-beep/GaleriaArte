
package com.example.galeriaarte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galeriaarte.ui.theme.GaleriaArteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            GaleriaArteTheme(darkTheme = false) {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Galeria(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Galeria(modifier: Modifier = Modifier) {
    var obraActual by remember { mutableIntStateOf(1) }

    val titulo = when (obraActual) {
        1 -> "Las meninas"
        2 -> "La Mona Lisa"
        3 -> "La noche estrellada"
        4 -> "El beso"
        else -> "Guernica"
    }

    val artista = when (obraActual) {
        1 -> "Diego Velázquez (1656)"
        2 -> "Leonardo da Vinci (c. 1503-1519)"
        3 -> "Vincent van Gogh (1889)"
        4 -> "Gustav Klimt (1907-1908)"
        else -> "Pablo Picasso (1937)"
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                id = when (obraActual) {
                    1 -> R.drawable.meninas
                    2 -> R.drawable.mona_lisa
                    3 -> R.drawable.noche_estrellada
                    4 -> R.drawable.el_beso
                    else -> R.drawable.guernica
                }
            ),
            contentDescription = titulo,
            modifier = Modifier.size(280.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = titulo,
            fontSize = 22.sp
        )

        Text(
            text = artista,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    obraActual = when (obraActual) {
                        1 -> 5
                        else -> obraActual - 1
                    }
                }
            ) {
                Text("Anterior")
            }

            Button(
                onClick = {
                    obraActual = when (obraActual) {
                        5 -> 1
                        else -> obraActual + 1
                    }
                }
            ) {
                Text("Siguiente")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GaleriaPreview() {
    GaleriaArteTheme {
        Galeria()
    }
}
