package devanir.soaresjunior.matchcentredevanir.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import devanir.soaresjunior.matchcentredevanir.data.commentary.CommentaryResponse
import devanir.soaresjunior.matchcentredevanir.data.eventdetails.MatchInfoResponse
import devanir.soaresjunior.matchcentredevanir.net.MatchService
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

//Since using MVVM, here we have the repository pattern in action

class RepositoryImpl(private val matchService: MatchService) : Repository {


    private val compositeDisposable = CompositeDisposable()
    private val matchLiveData = MutableLiveData<MatchInfoResponse>()
    private val commentaryLiveData = MutableLiveData<CommentaryResponse>()

    override fun getCommentary(): LiveData<CommentaryResponse> {
        compositeDisposable.add(matchService.getCommentary()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(
                {
                    commentaryLiveData.value = it
                },
                {
                    handleError(it)
                }
            ))
        return commentaryLiveData
    }


    override fun getMatch(): LiveData<MatchInfoResponse> {
        //dispose of the data after it was used, stops wasting resources fetching data when app is stopped.
        compositeDisposable.add(matchService.getMatch()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(
                {
                    matchLiveData.value = it
                },
                {
                    handleError(it)
                }
            ))
        return matchLiveData
    }


    override fun dispose() {
        compositeDisposable.clear()
    }

    private fun handleError(throwable: Throwable) {
        if (throwable.message != null) {
            throwable.printStackTrace()
        }
    }
}
