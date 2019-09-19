package devanir.soaresjunior.matchcentredevanir.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import devanir.soaresjunior.matchcentredevanir.data.commentary.CommentaryResponse
import devanir.soaresjunior.matchcentredevanir.data.eventdetails.MatchInfoResponse
import devanir.soaresjunior.matchcentredevanir.data.repository.Repository
import io.reactivex.disposables.CompositeDisposable

class MatchCentreViewModel(private val repository: Repository) : ViewModel() {
    override fun onCleared() {
        super.onCleared()
        repository.dispose()
    }

    fun showMatchInfo(): LiveData<MatchInfoResponse> = repository.getMatch()

    fun fetchCommentary(): LiveData<CommentaryResponse> = repository.getCommentary()
}