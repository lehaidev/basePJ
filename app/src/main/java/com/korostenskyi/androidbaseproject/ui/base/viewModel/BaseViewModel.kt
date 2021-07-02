package com.korostenskyi.androidbaseproject.ui.base.viewModel

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import timber.log.Timber

abstract class BaseViewModel : ViewModel() {

    init {
        Timber.tag(VIEWMODEL_EVENT_TAG).d("${javaClass.simpleName} init")
    }

    @CallSuper
    open fun onCreate() {}

    @CallSuper
    open fun onViewCreated() {}

    @CallSuper
    open fun onStart() {}

    @CallSuper
    open fun onResume() {}

    @CallSuper
    open fun onPause() {}

    @CallSuper
    open fun onStop() {}

    @CallSuper
    open fun onDestroyView() {}

    @CallSuper
    open fun onDestroy() {}

    @CallSuper
    override fun onCleared() {
        Timber.tag(VIEWMODEL_EVENT_TAG).d("${javaClass.simpleName} onCleared")
        super.onCleared()
    }

    companion object {
        private const val VIEWMODEL_EVENT_TAG = "ViewModelEvent"
    }
}