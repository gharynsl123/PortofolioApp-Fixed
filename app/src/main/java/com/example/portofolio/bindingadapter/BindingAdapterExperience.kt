package com.example.portofolio.bindingadapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.example.portofolio.data.Portofolio

@BindingAdapter("experienceTitle")
fun TextView.setExperienceTitle(data: Portofolio?){
    data?.let {
        text = data.title
    }
}

@BindingAdapter("experienceDetail")
fun TextView.setExperienceDetail(data: Portofolio?){
    data?.let {
        text = data.detail
    }
}

@BindingAdapter("experienceImage")
fun ImageView.setExperienceImage(data: Portofolio){
    load(data.image){
        crossfade(1000)
    }
}