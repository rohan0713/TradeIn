package com.social.tradein.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.social.tradein.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreenCompose(function : () -> Unit) {

    val color1 = colorResource(id = R.color.card)
    val color2 = colorResource(id = R.color.background)

    val brush = Brush.horizontalGradient(
        colors = listOf(color1, color2)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush)
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_btc), contentDescription = null,
            modifier = Modifier.fillMaxSize(),
        )

        Box(modifier = Modifier.fillMaxSize()) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .align(Alignment.BottomStart)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    Text(
                        text = "Trade In Real Time", color = Color.White,
                        fontSize = 40.sp, fontWeight = FontWeight.ExtraBold
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        Text(
                            text = "Investing in fractional" +
                                    " shares in real-time and, as always, commission-free",
                            color = Color.LightGray,
                            fontSize = 16.sp,
                            modifier = Modifier.weight(0.6f)
                        )

                        Button(
                            onClick = {
                                function()
                            },
                            modifier = Modifier.weight(0.4f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = color1
                            )
                        ) {
                            Text(text = "Start", modifier = Modifier.padding(20.dp))
                        }
                    }
                }

            }
        }
    }
}