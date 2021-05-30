package com.kumastudio.capstoneproject.core.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class MovieData(
        val movieId: String,
        val name: String,
        val description: String,
        val image: String,
        val isFavorite: Boolean
) : Parcelable