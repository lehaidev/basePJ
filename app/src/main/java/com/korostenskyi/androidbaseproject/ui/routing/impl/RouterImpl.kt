package com.korostenskyi.androidbaseproject.ui.routing.impl

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.korostenskyi.androidbaseproject.ui.routing.Router

class RouterImpl(private val navController: NavController): Router {

    override fun back() {
        navController.navigateUp()
    }

    private fun navigate(
        destinationId: Int,
        popStrategy: PopStrategy = PopStrategy.NONE,
        bundle: Bundle? = null
    ) {
        val navOptions = NavOptions.Builder()
            .setPopStrategy(popStrategy)
            .build()
        navController.navigate(destinationId, bundle, navOptions)
    }

    private fun NavOptions.Builder.setPopStrategy(strategy: PopStrategy): NavOptions.Builder {
        return when (strategy) {
            PopStrategy.NONE -> this
            PopStrategy.LATEST -> setPopLatest()
            PopStrategy.ALL -> setPopAll()
        }
    }

    private fun NavOptions.Builder.setPopLatest(): NavOptions.Builder {
        return navController.currentDestination
            ?.let { setPopUpTo(it.id, true) }
            ?: this
    }

    private fun NavOptions.Builder.setPopAll(): NavOptions.Builder {
        return setPopUpTo(navController.graph.id, false)
    }
}