package com.hsmnzaydn.term_commands_clean.base

import com.hsmnzaydn.term_commands_clean.remote.ServiceCallback


abstract class BaseResponseCallBack<R> constructor(
    private val baseInterfaces: BaseInterfaces
) : ServiceCallback<R> {

    override fun onSuccess(response: R?) {

    }

    override fun onError(errorCode: Int, errorMessage: String) {
        baseInterfaces.showMessage(errorMessage)
    }
}