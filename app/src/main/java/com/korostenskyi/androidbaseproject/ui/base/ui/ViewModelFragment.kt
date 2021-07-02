package com.korostenskyi.androidbaseproject.ui.base.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.korostenskyi.androidbaseproject.ui.base.viewModel.BaseViewModel
import timber.log.Timber

abstract class ViewModelFragment<V : BaseViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected abstract val viewModel: V

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onCreate")
        viewModel.onCreate()
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onViewCreated")
        viewModel.onViewCreated()
    }

    @CallSuper
    override fun onStart() {
        super.onStart()
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onStart")
        viewModel.onStart()
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onResume")
        viewModel.onResume()
    }

    @CallSuper
    override fun onPause() {
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onPause")
        viewModel.onPause()
        super.onPause()
    }

    @CallSuper
    override fun onStop() {
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onStop")
        viewModel.onStop()
        super.onStop()
    }

    @CallSuper
    override fun onDestroyView() {
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onDestroyView")
        viewModel.onDestroyView()
        super.onDestroyView()
    }

    @CallSuper
    override fun onDestroy() {
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onDestroy")
        viewModel.onDestroy()
        super.onDestroy()
    }

    companion object {
        private const val LIFECYCLE_EVENT_TAG = "LifecycleEvent"
    }
}