package com.nhom3.appdulich.ui.fragment.acount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentLoginBinding
import com.nhom3.appdulich.utils.Validations
import com.nhom3.appdulich.utils.navigate
import com.nhom3.appdulich.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentLogin : BaseFragment<FragmentLoginBinding>(), View.OnClickListener {
    @Inject
    lateinit var validation: Validations
    private val _viewModel by activityViewModels<LoginViewModel>()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentLoginBinding = DataBindingUtil.inflate(
        layoutInflater,
        R.layout.fragment_login,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = _viewModel
        binding.lifecycleOwner = this
        _viewModel.checkAccount { }
    }

    override fun listenerViewModel() {
        _viewModel.loadingDialog = {
            helpers.showProgressLoading(requireContext())
        }

        _viewModel.showError = {
            helpers.showAlertDialog(context = requireContext(), msg = it)
            helpers.dismissProgress()
        }
    }

    override fun onInit() {
        onClickView()
    }

    private fun onClickView() {
        binding.txtRegister.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)
        binding.txtForgetPass.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> _viewModel.login {
                requireView().navigate(R.id.action_fragmentLogin_to_fragmentHome)
                helpers.dismissProgress()
            }
            R.id.txtForgetPass -> _viewModel.sendVerifyMail {
                requireView().navigate(R.id.action_fragmentLogin_to_fragmentVerifyAccount)
                helpers.dismissProgress()
            }
            R.id.txtRegister -> requireView().navigate(R.id.action_fragmentLogin_to_fragmentRegister)
        }
    }
}