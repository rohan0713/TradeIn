package com.social.tradein.presentation.ui

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.social.tradein.R
import com.social.tradein.presentation.viewmodel.CoinViewModel
import kotlinx.coroutines.launch

@Composable
fun ChartScreenCompose(viewModel: CoinViewModel, id: String?) {

    println(id)
    val scope = rememberCoroutineScope()
    val res by viewModel.coinDetails.observeAsState(null)

    val color1 = colorResource(id = R.color.background)
    val color2 = colorResource(id = R.color.card)

    val brush = Brush.horizontalGradient(
        colors = listOf(color1, color2)
    )

    LaunchedEffect(null){
        scope.launch {
            if (id != null) {
                viewModel.fetchCoinDetails("coins/$id")
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = brush)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )

                Text(
                    text = res?.name ?: "name",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Balance", color = Color.LightGray, fontSize = 14.sp)

                Text(
                    text = "+2.57%", color = Color.White, fontSize = 12.sp,
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(10.dp)
                        )
                        .background(colorResource(id = R.color.tv_background))
                        .padding(horizontal = 10.dp, vertical = 3.dp)
                )

            }

            Text(
                text = "$7,157.66",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontFamily = FontFamily.Default,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .background(colorResource(id = R.color.background))
                .padding(20.dp),
            contentAlignment = Alignment.Center) {

                Text(text = "Coin Chart", color = Color.White)
            }

            MarketCompose()
            footerCompose()
        }

    }
}

@Preview
@Composable
fun MarketCompose(){

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
        .border(1.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
        .padding(20.dp)){

        Column() {

            Text(text = "Overview", color = Color.White, fontWeight = FontWeight.Bold)

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "High", color = Color.Gray)
                Text(text = "3,254.16", color = colorResource(id = R.color.indicator))
                Text(text = "Open", color = Color.Gray)
                Text(text = "3,254.16", color = Color.Gray)

            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Low", color = Color.Gray)
                Text(text = "1,247.16", color = Color.Red)
                Text(text = "Open", color = Color.Gray)
                Text(text = "1,247.16", color = Color.Gray)

            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Daily vol", color = Color.Gray)
                Text(text = "140.2M", color = Color.Gray)
                Text(text = "Market Cap", color = Color.Gray)
                Text(text = "337.88", color = Color.Gray)

            }


        }

    }
}

@Preview
@Composable
fun footerCompose(){

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
    horizontalArrangement = Arrangement.SpaceBetween) {

        Box(modifier = Modifier
            .weight(0.5f)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(30.dp)
            ),
        contentAlignment = Alignment.Center) {
            Row(modifier = Modifier.padding(15.dp)) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null,
                modifier = Modifier.rotate(40f))
                Spacer(modifier = Modifier.size(5.dp))
                Text(text = "Sell", color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.size(20.dp))

        Box(modifier = Modifier
            .weight(0.5f)
            .background(
                color = colorResource(id = R.color.indicator),
                shape = RoundedCornerShape(30.dp)
            ),
            contentAlignment = Alignment.Center) {
            Row(modifier = Modifier.padding(15.dp)) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null,
                    modifier = Modifier.rotate(40f))
                Spacer(modifier = Modifier.size(5.dp))
                Text(text = "Buy", color = Color.Black)
            }
        }
    }
}