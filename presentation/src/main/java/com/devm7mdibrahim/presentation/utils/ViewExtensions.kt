package com.devm7mdibrahim.presentation.utils

import android.view.View
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.devm7mdibrahim.presentation.utils.Constants.IMAGE_PATH


fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toInvisible() {
    visibility = View.INVISIBLE
}

fun View.toGone() {
    visibility = View.GONE
}

fun ImageView.loadImageFromUrl(url: String?) {
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()

    var newUrl = url
    if (url != null && url.startsWith("https://").not() && url.startsWith("http://").not()) {
        newUrl = IMAGE_PATH + url
    }

    Glide.with(this.context)
        .load(newUrl).placeholder(circularProgressDrawable)
        .into(this)
}