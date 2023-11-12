package com.arjun.aquaui.presentation.reusable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjun.aquaui.R
import com.arjun.aquaui.ui.theme.Hint20

@Composable
fun TicketCardComposable() {


    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Card(
            shape = RoundedCornerShape(6.dp),
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier.width(160.dp).height(130.dp).padding(12.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ) {
            Column(
                Modifier.padding(8.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("My E Ticket", style = MaterialTheme.typography.labelSmall, modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.clock),
                        contentDescription = "",
                        modifier = Modifier
                            .width(12.dp)
                            .height(12.dp),
                        //  colorFilter = ColorFilter.tint(colorResource(id = R.color.white)),
                        contentScale = ContentScale.Fit,
                    )
                }

                Text(text = "There are not yet", fontSize = 17.sp, fontWeight = FontWeight.SemiBold, color = Hint20,modifier = Modifier.weight(1f))
                Text(text = "Retrieve here",  color = Color.Red, fontSize = 10.sp)
            }
        }
        Card(
            shape = RoundedCornerShape(6.dp),
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier.width(160.dp).height(130.dp).padding(12.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ) {
            Column(
                Modifier.padding(8.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("My E Ticket", style = MaterialTheme.typography.labelSmall, modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(id = R.drawable.clock),
                        contentDescription = "",
                        modifier = Modifier
                            .width(12.dp)
                            .height(12.dp),
                        //  colorFilter = ColorFilter.tint(colorResource(id = R.color.white)),
                        contentScale = ContentScale.Fit,
                    )
                }

                Text(text = "There are not yet", fontSize = 17.sp, fontWeight = FontWeight.SemiBold, color = Hint20,modifier = Modifier.weight(1f))
                Text(text = "Retrieve here",  color = Color.Red, fontSize = 10.sp)
            }
        }
    }
}