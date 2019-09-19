package devanir.soaresjunior.matchcentredevanir.ui

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import devanir.soaresjunior.matchcentredevanir.ARG_PLAYERS
import devanir.soaresjunior.matchcentredevanir.BaseFragment
import devanir.soaresjunior.matchcentredevanir.R
import devanir.soaresjunior.matchcentredevanir.data.eventdetails.Player
import devanir.soaresjunior.matchcentredevanir.rvAdapters.PlayersAdapter
import kotlinx.android.synthetic.main.fragment_players.*

class PlayersFrag : BaseFragment() {
    override fun inject() {
        (activity as MatchCentreActivity).activityComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_players, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val players = arguments?.getParcelableArrayList<Player>(ARG_PLAYERS) ?: arrayListOf()
        val playersAdapter = PlayersAdapter()

        rvHomeTeam.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = playersAdapter
            addItemDecoration(DividerItemDecoration(this.context, LinearLayoutManager.VERTICAL))
        }

        playersAdapter.setData(players)

    }

    companion object {
        fun newInstance(players: ArrayList<Player>): PlayersFrag {
            val fragment = PlayersFrag()
            val arguments = Bundle()
            arguments.putParcelableArrayList(ARG_PLAYERS, players)
            fragment.arguments = arguments
            return fragment
        }
    }
}
