package devanir.soaresjunior.matchcentredevanir.rvAdapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import devanir.soaresjunior.matchcentredevanir.R
import devanir.soaresjunior.matchcentredevanir.data.commentary.CommentaryResponse

class CommentaryAdapter(private val commentaryList: List<CommentaryResponse.Data.CommentaryEntry>) :
    RecyclerView.Adapter<CommentaryAdapter.CommentaryVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentaryVH {
        return CommentaryVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_commentary, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return commentaryList.size
    }

    override fun onBindViewHolder(vh: CommentaryVH, position: Int) {
        vh.bind(commentaryList[position])
    }

    class CommentaryVH(view: View) : RecyclerView.ViewHolder(view) {

        private val tvComment: TextView = view.findViewById(R.id.tvComment)
        private val tvTime: TextView = view.findViewById(R.id.tvTime)
        private val tvPeriod: TextView = view.findViewById(R.id.tvPeriod)
        private val tvType: TextView = view.findViewById(R.id.tvType)

        @SuppressLint("SetTextI18n")
        fun bind(commentaryList: CommentaryResponse.Data.CommentaryEntry) {
            tvComment.text = commentaryList.comment
            tvTime.text = "Time: ${commentaryList.time}"
            tvPeriod.text = "Period: ${commentaryList.period}"
            tvType.text = commentaryList.type
        }
    }
}
