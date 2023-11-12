package com.arjun.aquaui.presentation.reusable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjun.aquaui.R
import com.arjun.aquaui.presentation.ui_vos.UiCategoryButtonVo
import com.arjun.aquaui.ui.theme.Hint20

@Composable
fun CircularIconButton (categoryButton: UiCategoryButtonVo) {



    Column(
        verticalArrangement = Arrangement.Center,
                horizontalAlignment= Alignment.CenterHorizontally,
        modifier = Modifier.padding(12.dp)
    ) {

        Box(
            contentAlignment= Alignment.Center,
            modifier = Modifier
                .clip(CircleShape)
                .background(Hint20, CircleShape)
            .padding(8.dp).width(30.dp).height(30.dp),){
            Image(
                painter = painterResource(id = categoryButton.icon),
                contentDescription = "",
                modifier = Modifier.width(18.dp).height(18.dp),
                //  colorFilter = ColorFilter.tint(colorResource(id = R.color.white)),
                contentScale = ContentScale.Fit,
            )
        }

        Text(categoryButton.title, color = Color.Black, fontSize = 14.sp)
    }
}

