package com.mjpecora.app.challenge.adapters

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter("android:src")
fun setSrc(imageView: AppCompatImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(imageView)
}

@BindingAdapter("android:text")
fun setText(textView: AppCompatTextView, text: String?) {
    textView.text = text
}
