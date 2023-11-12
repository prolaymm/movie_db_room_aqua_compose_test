package com.arjun.aquaui.presentation.screen.home_composable

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextOverflow
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjun.aquaui.R
import com.arjun.aquaui.presentation.reusable.TicketCardComposable
import com.arjun.aquaui.presentation.reusable.UpcommingShowComposable
import com.arjun.aquaui.presentation.screen.home_composable.CategoryButtonComposableList
import com.arjun.aquaui.ui.theme.AquaUiTheme
import com.arjun.aquaui.ui.theme.Hint20
import com.arjun.aquaui.utils.Constants
import okhttp3.internal.wait
import java.util.Stack

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(topBar = {
        TopAppBar(title = {

            Surface(modifier= Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, end = 12.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(  painterResource(id = R.drawable.ic_back),
                        contentDescription = "",modifier = Modifier
                            .height(28.dp)
                            .width(28.dp))
                    Image(  painterResource(id = R.drawable.sea),
                        contentDescription = "",modifier = Modifier
                            .height(80.dp)
                            .width(80.dp)
                            .weight(1f))

                    Image(  painterResource(id = R.drawable.noti),
                        contentDescription = "",modifier = Modifier
                            .height(40.dp)
                            .width(40.dp))
                }
            }
        })
    }
    ) {

        Column {

            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "helo wlldldddd")

            CategoryButtonComposableList(Constants.categoryList)
            TicketCardComposable()
            Spacer(modifier =Modifier.height(12.dp))

            Row {
                Text(text = "There are not yet", fontSize = 17.sp, fontWeight = FontWeight.SemiBold,modifier = Modifier.weight(1f))
                Text(text = "Retrieve here",  color = Hint20, fontSize = 10.sp)
            }
            Spacer(modifier =Modifier.height(8.dp))

            UpcommingShowComposable(Constants.mShowlList ){

            }
        }



    }
}