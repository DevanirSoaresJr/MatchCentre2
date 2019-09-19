package devanir.soaresjunior.matchcentredevanir.data.repository

import android.arch.lifecycle.LiveData
import devanir.soaresjunior.matchcentredevanir.data.commentary.CommentaryResponse
import devanir.soaresjunior.matchcentredevanir.data.eventdetails.MatchInfoResponse
import io.reactivex.Single

interface Repository {

    fun getMatch():LiveData<MatchInfoResponse>

    fun getCommentary():LiveData<CommentaryResponse>

    fun dispose()

}