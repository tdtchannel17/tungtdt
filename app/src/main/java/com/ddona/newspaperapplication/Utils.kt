package com.ddona.newspaperapplication

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object Utils {
    @JvmStatic
    @BindingAdapter("setText")
    fun setText(tv: TextView, content: String?) {
        tv.setText(content)
    }

    @JvmStatic
    @BindingAdapter("setImage")
    fun setImage(iv: ImageView, imageId: Int) {
        iv.setImageResource(imageId)
    }

    @JvmStatic
    @BindingAdapter("setImageLink")
    fun setImageLink(iv: ImageView, link: String) {
        Glide.with(iv.context)
            .load(link)
            .into(iv)
    }
}