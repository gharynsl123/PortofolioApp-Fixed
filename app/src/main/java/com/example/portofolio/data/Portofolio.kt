package com.example.portofolio.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Portofolio(
    var id: Int = 0,
    var title: String = "",
    var detail: String = "",
    var link: String = "",
    var image: Int = 0
): Parcelable