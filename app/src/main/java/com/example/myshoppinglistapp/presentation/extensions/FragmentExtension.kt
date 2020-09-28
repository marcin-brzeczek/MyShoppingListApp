package com.example.myshoppinglistapp.presentation.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showShortToast(message:String) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()