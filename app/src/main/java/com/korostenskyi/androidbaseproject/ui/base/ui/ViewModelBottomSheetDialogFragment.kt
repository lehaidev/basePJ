package com.korostenskyi.androidbaseproject.ui.base.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.korostenskyi.androidbaseproject.R
import com.korostenskyi.androidbaseproject.ui.base.viewModel.BaseViewModel
import timber.log.Timber

abstract class ViewModelBottomSheetDialogFragment<V : BaseViewModel>(
    @LayoutRes private val layoutId: Int
) : BottomSheetDialogFragment() {

    protected abstract val viewModel: V

    override fun getTheme(): Int = R.style.PROJECT_NAME_Theme_BottomSheetDialog

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onCreateView")
        return inflater.inflate(layoutId, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onCreateDialog")
        return BottomSheetDialog(requireContext(), theme)
    }

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

    override fun onStart() {
        super.onStart()
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onStart")
        dialog?.window?.apply {
            setBackgroundDrawable(null)
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            setWindowAnimations(R.style.Animation_Design_BottomSheetDialog)
        }
        viewModel.onStart()
    }

    override fun onResume() {
        super.onResume()
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onResume")
        viewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onPause")
        viewModel.onPause()
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        Timber.tag(LIFECYCLE_EVENT_TAG).d("${javaClass.simpleName} onDestroyView")
        viewModel.onDestroyView()
    }

    companion object {
        private const val LIFECYCLE_EVENT_TAG = "LifecycleEvent"
    }
}