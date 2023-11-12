package com.arjun.aquaui.utils

import android.graphics.drawable.Drawable
import com.arjun.aquaui.R
import com.arjun.aquaui.domain.vos.ShowVo
import com.arjun.aquaui.presentation.ui_vos.UiCategoryButtonVo

object Constants {

     val categoryList : List<UiCategoryButtonVo> =  mutableListOf(
        UiCategoryButtonVo("Map", icon = R.drawable.map),
        UiCategoryButtonVo("Inhabitants",R.drawable.in_habit),
        UiCategoryButtonVo("Shows",R.drawable.show),
        UiCategoryButtonVo("Shopping",R.drawable.cart),
        UiCategoryButtonVo("Dine",R.drawable.dine),
        UiCategoryButtonVo("Meeting & Greets",R.drawable.meet),

    )
    val mShowlList : List<ShowVo> = listOf(
        ShowVo(image = "https://cdn.pixabay.com/photo/2014/07/21/19/20/lobby-398845_1280.jpg", time = "02:PM", titel="Hotel Malia New Work",),
        ShowVo(image = "https://cdn.pixabay.com/photo/2021/12/11/07/59/hotel-6862159_1280.jpg", time = "03:0PM",titel="Amex Logical Delhi"),
        ShowVo(image = "https://cdn.pixabay.com/photo/2012/11/21/10/24/building-66789_1280.jpg", time = "03:0PM",titel="Viter Vix Chicago"),
        ShowVo(image = "https://cdn.pixabay.com/photo/2014/07/10/17/17/hotel-389256_1280.jpg", time = "03:0PM",titel="Poiner Singapore"),
    )
}