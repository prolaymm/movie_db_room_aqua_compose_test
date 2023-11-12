package com.arjun.aquaui.presentation.screen.home_composable

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.arjun.aquaui.presentation.reusable.CircularIconButton
import com.arjun.aquaui.presentation.ui_vos.UiCategoryButtonVo

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryButtonComposableList (cityList : List<UiCategoryButtonVo> = mutableListOf()) {
    FlowRow(
        modifier = Modifier.padding(8.dp),

        ) {
        cityList.forEach { vo ->
            CircularIconButton(categoryButton =vo )
        }
    }
}