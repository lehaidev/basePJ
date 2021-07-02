package com.korostenskyi.androidbaseproject.extensions

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.korostenskyi.androidbaseproject.ui.routing.Router
import com.korostenskyi.androidbaseproject.ui.routing.impl.RouterImpl

fun Fragment.findRouter(): Router {
    return RouterImpl(findNavController())
}
