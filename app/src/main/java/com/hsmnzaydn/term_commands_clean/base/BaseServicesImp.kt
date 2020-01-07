package com.basefy.burger_king.data.network.services

import com.google.gson.Gson
import com.hsmnzaydn.term_commands_clean.Category.data.api.CategoryServices
import com.hsmnzaydn.term_commands_clean.remote.NetworkError
import com.hsmnzaydn.term_commands_clean.remote.ServiceCallback
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

open class BaseServicesImp  constructor(
    private val retrofit: Retrofit,
    private val gson: Gson
) : BaseServices {

    fun <T> getRequest(
        callback: ServiceCallback<T>,
        observable: () -> Observable<T>
    ): Disposable = observable()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(onNext(callback)) {
            callback.onError(NetworkError(it).errorCode, NetworkError(it).appErrorMessage)
        }

    fun <T > onNext(callback: ServiceCallback<T>): (T) -> Unit = {

    }

    override fun getCategoryServices(): CategoryServices {
        return retrofit.create(CategoryServices::class.java)
    }




}