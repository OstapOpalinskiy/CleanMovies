package com.opalynskyi.cleanmovies.app.login

import com.opalynskyi.cleanmovies.app.base.BasePresenter
import com.opalynskyi.cleanmovies.core.domain.login.LoginResultWrapper

class LoginContract {

    interface Presenter : BasePresenter<View> {
        fun login()
        fun onActivityResult(result: LoginResultWrapper)
    }

    interface View {
        fun proceedFlow()
        fun showLoginError(errorMsg: String)
    }
}