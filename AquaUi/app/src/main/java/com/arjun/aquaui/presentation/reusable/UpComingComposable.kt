package com.arjun.aquaui.presentation.reusable

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arjun.aquaui.R
import com.arjun.aquaui.domain.vos.ShowVo

@SuppressLint("ResourceType")
@Composable
fun UpcommingShowComposable(mShowList: List<ShowVo>, onFavouriteClick : (index : Int) -> Unit){

    LazyRow{

        items(mShowList.size) {
                position ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(240.dp, 280.dp)
                    .padding(start = 8.dp, end = 8.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(mShowList[position].image)
                        .crossfade(true)
                        .build(),
                    //placeholder = painterResource(id = R.drawable.loading),
                    error = painterResource(id = R.drawable.wrong),
                    contentDescription = "Loading",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .size(240.dp, 280.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.TopCenter)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Box(modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .background(color = Color.White)
                        .padding(4.dp)
                    ){

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(painterResource(id =R.drawable.ticket), contentDescription = "",  modifier = Modifier.size(16.dp,16.dp))
                            Text(text =mShowList[position].time ,  fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                }


                Row (
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(
                            12.dp
                        )
                        .fillMaxWidth(),
                    verticalAlignment =Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){

                    Column(
                        horizontalAlignment = Alignment.Start,

                        ) {
                        Text(text = "${mShowList[position].titel}",  fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)

                    }


                }
            }

        }
    }
}