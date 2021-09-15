package com.nhom3.appdulich.ui.fragment.setting

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentAboutBinding
import com.nhom3.appdulich.extension.setUpToolbar
import com.nhom3.appdulich.utils.Const
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentAbout : BaseFragment<FragmentAboutBinding>() {
    override fun getViewBinding() = FragmentAboutBinding.inflate(layoutInflater)

    override fun listenerViewModel() {
    }

    override fun onInit() {
        initView()
    }

    private fun initView() {
        binding.toolbar.toolbar.setUpToolbar {
            requireActivity().onBackPressed()
        }

        binding.webView.apply {
            loadUrl(Const.WEB_VIEW_URL)
            webViewClient = object : WebViewClient(){
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    helpers.showProgressLoading(requireContext())
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    helpers.dismissProgress()
                }
            }
        }
    }
}