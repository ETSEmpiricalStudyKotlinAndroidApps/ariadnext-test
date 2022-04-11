package com.ariadnext.client.presentation.extension

import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

fun View.getLayoutInflater(): LayoutInflater = LayoutInflater.from(context)

/**
 * Changes the provided view visibility.
 */
@BindingAdapter("isVisible")
fun setVisible(view: View, isVisible: Boolean) {
    view.isVisible = isVisible
}