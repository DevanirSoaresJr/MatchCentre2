package devanir.soaresjunior.matchcentredevanir.rvAdapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import devanir.soaresjunior.matchcentredevanir.R
import devanir.soaresjunior.matchcentredevanir.data.eventdetails.Player

class PlayersAdapter : RecyclerView.Adapter<PlayersViewHolder>() {
    var playerList: ArrayList<Player> = arrayListOf()

    fun setData(playersList: ArrayList<Player>) {
        this.playerList = playersList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersViewHolder {
        return PlayersViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rv_player, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlayersViewHolder, position: Int) {
        holder.bind(playerList[position])
    }

    override fun getItemCount(): Int {
        return playerList.size
    }
}

class PlayersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvPlayerName: TextView = itemView.findViewById(R.id.tvPlayerName)
    private val tvShirtNumber: TextView = itemView.findViewById(R.id.tvShirtNumber)
    private val tvPosition: TextView = itemView.findViewById(R.id.tvPosition)
    private val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)

    fun bind(player: Player){
        tvPlayerName.text = "${player.firstName} ${player.lastName}"
        tvPosition.text = player.position
        tvShirtNumber.text = player.shirtNumber.toString()
        tvStatus.text = player.status
    }
}




