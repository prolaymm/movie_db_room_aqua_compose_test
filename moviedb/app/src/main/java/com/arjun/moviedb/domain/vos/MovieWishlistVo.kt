package com.arjun.moviedb.domain.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arjun.moviedb.utils.DatabaseConstant

@Entity(tableName = DatabaseConstant.WISHLIST)
data class MovieWishlistVo (
    @ColumnInfo("title")
    val title: String,
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    @ColumnInfo("poasterPath")
    val image: String
);