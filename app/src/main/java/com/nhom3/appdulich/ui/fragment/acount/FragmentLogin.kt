package com.nhom3.appdulich.ui.fragment.acount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.base.response.DataResponse
import com.nhom3.appdulich.data.model.Account
import com.nhom3.appdulich.databinding.FragmentLoginBinding
import com.nhom3.appdulich.utils.Validations
import com.nhom3.appdulich.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FragmentLogin : BaseFragment<FragmentLoginBinding>() {
    @Inject
    lateinit var validation: Validations
    private val _viewModel by viewModels<LoginViewModel>()

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
        _viewModel.checkAccount {  }
    }

    override fun listenerViewModel() {
        _viewModel.loading.observe(this, {
            when (it) {
                true -> helpers.showProgressLoading(requireContext())
                else -> helpers.dismissProgress()
            }
        })

        _viewModel.data.observe(this, {
            when (it) {
                is DataResponse.Success<*> ->{
                    when(it.data){
                        is Account -> it.data.let { ac -> _viewModel.saveAccount(ac) }
                    }
                }
                is DataResponse.Fail -> {
                    helpers.showAlertDialog(
                        null,
                        it.exception.message.toString(),
                        requireContext()
                    )
                }
            }
            helpers.dismissProgress()
        })
    }

    override fun onInit() {
        binding.viewModel = _viewModel
        binding.lifecycleOwner = this

        onClickView()
    }

    private fun onClickView() {
        binding.btRegister.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_fragmentLogin_to_fragmentRegister)
        }
    }

}