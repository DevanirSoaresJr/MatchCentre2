package devanir.soaresjunior.matchcentredevanir.net

import devanir.soaresjunior.matchcentredevanir.COMMENTARY_ENDPOINT
import devanir.soaresjunior.matchcentredevanir.EVENT_ENDPOINT
import devanir.soaresjunior.matchcentredevanir.data.commentary.CommentaryResponse
import devanir.soaresjunior.matchcentredevanir.data.eventdetails.MatchInfoResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface MatchService {
    @GET(EVENT_ENDPOINT)
    fun getMatch(): Single<MatchInfoResponse>

    @GET(COMMENTARY_ENDPOINT)
    fun getCommentary(): Single<CommentaryResponse>
}