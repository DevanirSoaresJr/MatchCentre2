package devanir.soaresjunior.matchcentredevanir.data.eventdetails

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MatchInfoResponse(
    val status: String,
    val `data`: Data,
    val metadata: Metadata
)

data class Data(
    val id: String,
    val feedMatchId: Int,
    val competition: String,
    val competitionId: Int,
    val status: String,
    val period: String,
    val seasonId: Int,
    val season: String,
    val round: Int,
    val minute: Int,
    val attendance: Int,
    val date: String,
    val homeTeam: HomeTeam,
    val awayTeam: AwayTeam,
    val venue: Venue,
    //val events: List<Event>,
    val officials: List<Official>
)

data class Venue(
    val id: Int,
    val name: String,
    val location: String
)

data class HomeTeam(
    val id: String,
    val name: String,
    val shortName: String,
    val score: Int,
    val halfTimeScore: Int,
    val players: List<Player>,
    val teamStats: TeamStats
)

data class TeamStats(
    val centreBoxShots: Int,
    val leftBoxShots: Int,
    val topRightGoals: Int,
    val bottomRightGoals: Int,
    val insideBoxBlocks: Int,
    val insideBoxGoals: Int,
    val insideBoxGoalkeeperSaves: Int,
    val leftFootShotGoals: Int,
    val leftFootShotSaves: Int,
    val leftFootShots: Int,
    val leftMisses: Int,
    val outsideBoxMisses: Int,
    val outsideBoxGoalkeeperSaves: Int,
    val outsideBoxCentreShots: Int,
    val openPlayShots: Int,
    val penaltyGoals: Int,
    val rightFootGoals: Int,
    val rightFootSaves: Int,
    val rightFootShots: Int,
    val bottomCentreSaves: Int,
    val bottomRightSaves: Int,
    val concededShotsOnTargetInsideBox: Int,
    val concededShotsOnTargetOutsideBox: Int,
    val shotsBlocked: Int,
    val cornersTaken: Int,
    val defenderGoals: Int,
    val keeperDivingSaves: Int,
    val finalThirdFouls: Int,
    val firstHalfGoals: Int,
    val freeKicksConceded: Int,
    val freeKicksWon: Int,
    val goalAssists: Int,
    val intentionalGoalAssists: Int,
    val openPlayGoalAssists: Int,
    val goalKicks: Int,
    val goals: Int,
    val goalsConceded: Int,
    val goalsConcededInsideBox: Int,
    val openPlayGoals: Int,
    val cornersLost: Int,
    val midfielderGoals: Int,
    val shotsOnTargetAssists: Int,
    val shotsOnTarget: Int,
    val defenderBlocks: Int,
    val penaltiesWon: Int,
    val possession: Double,
    val insideBoxSaves: Int,
    val outsideBoxSaves: Int,
    val saves: Int,
    val shotsOffTarget: Int,
    val substitutionsMade: Int,
    val totalCornersIntoBox: Int,
    val throwIns: Int,
    val shotsOnGoal: Int,
    val teamYellowCards: Int,
    val cornersWon: Int,
    val formation: String
)

@Parcelize
data class Player(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val position: String,
    val shirtNumber: Int,
    val status: String,
    val captain: Boolean,
    val playerStats: PlayerStats,
    val known: String
): Parcelable

@Parcelize
data class PlayerStats(
    val formationPlace: Int
): Parcelable


data class AwayTeam(
    val id: String,
    val name: String,
    val shortName: String,
    val score: Int,
    val halfTimeScore: Int,
    val players: List<Player>,
    val teamStats: TeamStats
)


data class SubstitutionDetails(
    val playerSubOff: PlayerSubOff,
    val playerSubOn: PlayerSubOn,
    val reason: String
)

data class PlayerSubOff(
    val playerId: Int,
    val firstName: String,
    val lastName: String
)

data class PlayerSubOn(
    val playerId: Int,
    val firstName: String,
    val lastName: String
)


data class GoalDetails(
    val player: Player,
    val type: String
)


data class Official(
    val id: Int,
    val name: String,
    val type: String,
    val referee: Boolean
)


data class Metadata(
    val createdAt: String
)
