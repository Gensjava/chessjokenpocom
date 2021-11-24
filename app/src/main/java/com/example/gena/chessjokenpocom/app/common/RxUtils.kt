package com.example.gena.chessjokenpocom.app.common

import io.reactivex.Completable
import io.reactivex.CompletableTransformer
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object RxUtils {
    fun <T> wrapAsync(observable: Observable<T>): Observable<T> {
        return wrapAsync(observable, Schedulers.io())
    }

    fun <T> wrapAsync(observable: Observable<T>, scheduler: Scheduler): Observable<T> {
        return observable
            .subscribeOn(scheduler)
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun applySchedulers(): CompletableTransformer? {
        return CompletableTransformer { upstream: Completable ->
            upstream
                .unsubscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
}
