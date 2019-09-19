package devanir.soaresjunior.matchcentredevanir.ui

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import com.squareup.picasso.Picasso
import devanir.soaresjunior.matchcentredevanir.MAN_UNITED
import devanir.soaresjunior.matchcentredevanir.R
import devanir.soaresjunior.matchcentredevanir.data.eventdetails.Player
import devanir.soaresjunior.matchcentredevanir.di.ActivityComponent
import devanir.soaresjunior.matchcentredevanir.di.ActivityModule
import devanir.soaresjunior.matchcentredevanir.di.DaggerActivityComponent
import devanir.soaresjunior.matchcentredevanir.rvAdapters.CommentaryAdapter
import kotlinx.android.synthetic.main.activity_matchcentre.*
import javax.inject.Inject
import devanir.soaresjunior.matchcentredevanir.LEICESTER as LEICESTER

class MatchCentreActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MatchCentreViewModel

    private lateinit var commentaryAdapter: CommentaryAdapter
    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matchcentre)
        activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()
        activityComponent.inject(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()
        Picasso
            .get()
            .load(MAN_UNITED)
            .into(imageTeam1)

        Picasso
            .get()
            .load(LEICESTER)
            .into(imageTeam2)

        viewModel.showMatchInfo().observe(this, Observer { response ->
            val homeRoasterText: TextView = findViewById(R.id.homeRoaster)
            val awayRoasterText: TextView = findViewById(R.id.awayRoaster)

            homeRoasterText.setOnClickListener {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                val homePlayers = response?.data?.homeTeam?.players ?: listOf()
                val fragment = PlayersFrag.newInstance(homePlayers as ArrayList<Player>)
                fragmentTransaction.replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit()

            }

            awayRoasterText.setOnClickListener {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                val awayPlayers = response?.data?.awayTeam?.players ?: listOf()
                val fragment = PlayersFrag.newInstance(awayPlayers as ArrayList<Player>)
                fragmentTransaction.replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit()
            }

            //TextViews Match Data Info
            val teamAwayScore: String = response?.data?.awayTeam?.score.toString()
            val teamHomeScore: String = response?.data?.homeTeam?.score.toString()
            val homeTeam: String = response?.data?.homeTeam?.shortName.toString()
            val awayTeam: String = response?.data?.awayTeam?.shortName.toString()

            tvCompetition.text = response?.data?.competition
            tvScore.text = "$teamHomeScore : $teamAwayScore"
            tvTeams.text = "$homeTeam V.S. $awayTeam"

            viewModel.fetchCommentary().observe(this, Observer {
                //Recycler View For Match Commentary
                commentaryAdapter = CommentaryAdapter(it?.data?.commentaryEntries!!)

                rvCommentary.apply {
                    layoutManager = LinearLayoutManager(this@MatchCentreActivity)
                    adapter = commentaryAdapter
                    addItemDecoration(DividerItemDecoration(this@MatchCentreActivity, LinearLayoutManager.VERTICAL))
                }

            })

            viewModel.fetchCommentary()

        })
    }

}
