package com.example.portofolio.bindingadapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.example.portofolio.data.Portofolio


@BindingAdapter("androidTitle")
fun TextView.setTitleAndroid(data: Portofolio?) {
    data?.let {
        text = it.title
    }
}

@BindingAdapter("androidImage")
fun ImageView.setAndroidImage(data: Portofolio) {
    load(data.image){
        crossfade(1000)
    }
}

