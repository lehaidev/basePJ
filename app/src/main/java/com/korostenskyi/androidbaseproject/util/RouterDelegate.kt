package com.korostenskyi.androidbaseproject.util

import androidx.fragment.app.Fragment
import com.korostenskyi.androidbaseproject.extensions.findRouter
import com.korostenskyi.androidbaseproject.ui.routing.Router
import kotlin.reflect.KProperty

class RouterDelegate {

    lateinit var router: Router

    operator fun getValue(thisRef: Fragment, property: KProperty<*>): Router {
        return if (::router.isInitialized) router else thisRef.findRouter().also { router = it }
    }
}