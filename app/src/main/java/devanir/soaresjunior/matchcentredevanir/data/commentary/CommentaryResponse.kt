package devanir.soaresjunior.matchcentredevanir.data.commentary

import com.google.gson.annotations.SerializedName


data class CommentaryResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val `data`: Data,
    val metadata: Metadata
) {
    data class Metadata(
        val createdAt: String
    )

    data class Data(
        val id: String,
        val feedMatchId: Int,
        val homeTeamName: String,
        val homeTeamId: String,
        val homeScore: Int,
        val awayTeamName: String,
        val awayTeamId: String,
        val awayScore: Int,
        val competitionId: Int,
        val competition: String,
        val commentaryEntries: List<CommentaryEntry>
    ) {
        data class CommentaryEntry(
            val type: String,
            val comment: String,
            val period: Int,
            val time: String
        )
    }
}