package com.social.tradein.presentation.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.social.tradein.R
import com.social.tradein.presentation.viewmodel.CoinViewModel

@Composable
fun HomeCompose(vm: CoinViewModel, navController: NavController) {

    val list by vm.coins.observeAsState(initial = emptyList())

    val color1 = colorResource(id = R.color.card)
    val color2 = colorResource(id = R.color.background)

    val brush = Brush.horizontalGradient(
        colors = listOf(color2, color1)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush)
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.ic_dashboard),
                        contentDescription = null,
                        tint = Color.LightGray,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

            item {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(text = "Balance", color = Color.LightGray, fontSize = 14.sp)

                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                            .border(0.5.dp, Color.LightGray, shape = RoundedCornerShape(10.dp))
                    ) {

                        Row(
                            modifier = Modifier.padding(start = 10.dp, end = 5.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {


                            Text(text = "USD", color = Color.LightGray, fontSize = 11.sp)

                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = Color.LightGray
                            )
                        }

                    }
                }

            }

            item {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "$28,390.08",
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontFamily = FontFamily.Default
                    )

                    Text(
                        text = "+2.57%", color = Color.LightGray, fontSize = 14.sp,
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(10.dp)
                            )
                            .background(colorResource(id = R.color.tv_background))
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                    )

                }

            }

            item {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

                    Column(
                        modifier = Modifier.width(80.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .background(
                                    colorResource(id = R.color.btn_background),
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Image(
                                imageVector = Icons.Default.ArrowBack, contentDescription = null,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .rotate(40f)
                            )
                        }

                        Text(
                            text = "Deposit", color = Color.Gray, fontSize = 13.sp,
                            textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp)
                        )
                    }

                    Column(
                        modifier = Modifier.width(80.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .background(
                                    colorResource(id = R.color.btn_background),
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Image(
                                imageVector = Icons.Default.ArrowForward, contentDescription = null,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .rotate(40f)
                            )
                        }

                        Text(
                            text = "Withdraw", color = Color.Gray, fontSize = 13.sp,
                            textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp)
                        )
                    }

                    Column(
                        modifier = Modifier.width(80.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .background(
                                    colorResource(id = R.color.btn_background),
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Image(
                                imageVector = Icons.Default.PlayArrow, contentDescription = null,
                                modifier = Modifier
                                    .padding(10.dp)
                            )
                        }

                        Text(
                            text = "Swap", color = Color.Gray, fontSize = 13.sp,
                            textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp)
                        )
                    }

                }
            }

            item {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "List of Coins",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(text = "See all", color = Color.LightGray, fontSize = 13.sp)

                }
            }

            item {
                LazyColumn(
                    content = {
                        Log.d("size", list.size.toString())
                        items(if (list.isNotEmpty()) list.subList(0, 100) else list) { coin ->
                            CoinItem(brush, coin.id ,coin.name, coin.symbol, coin.is_active, coin.rank) {
                                navController.navigate("chart/${coin.id}")
                            }
                        }
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 1000.dp)
                        .padding(top = 20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)
                )
            }

            item {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                )
            }
        }
    }
}


@Composable
fun CoinItem(
    brush: Brush,
    id : String,
    name: String,
    symbol: String,
    isActive: Boolean,
    rank: Int,
    function: (String) -> Unit
) {


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(brush)
            .clickable {
                println(id)
                function(id)
            }
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.card)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 20.dp
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {

                Text(
                    text = "$rank)", fontSize = 16.sp, color = Color.White,
                    modifier = Modifier.padding(top = 5.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 3.dp, start = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {
                        Text(
                            text = name,
                            fontSize = 18.sp,
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Spacer(modifier = Modifier.size(5.dp))
                        Text(text = symbol, fontSize = 14.sp, color = Color.LightGray)
                    }

                    Box() {
                        Text(
                            text = if (isActive) "is Active" else "Not Active", fontSize = 16.sp,
                            color = colorResource(id = R.color.indicator)
                        )
                    }
                }
            }
        }
    }
}