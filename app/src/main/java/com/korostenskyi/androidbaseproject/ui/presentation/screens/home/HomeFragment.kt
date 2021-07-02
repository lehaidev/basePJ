package com.korostenskyi.androidbaseproject.ui.presentation.screens.home

import com.korostenskyi.androidbaseproject.R
import com.korostenskyi.androidbaseproject.ui.base.ui.ViewModelFragment
import org.koin.android.ext.android.inject

class HomeFragment : ViewModelFragment<HomeViewModel>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by inject()
}
