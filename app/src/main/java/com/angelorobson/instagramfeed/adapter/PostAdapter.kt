package com.angelorobson.instagramfeed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.angelorobson.instagramfeed.MainActivity
import com.angelorobson.instagramfeed.R
import com.angelorobson.instagramfeed.model.Post
import kotlinx.android.synthetic.main.feed_item.view.*
import kotlinx.android.synthetic.main.suggestions_recycler_view.view.*
import kotlin.math.sign

class PostAdapter(private val posts: List<Post>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var twoIsDrag = false
    private val POST_VIEW = 1
    private val SUGGESTIONS_VIEW = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View

        return when (viewType) {
            SUGGESTIONS_VIEW -> {
                view = inflater.inflate(R.layout.suggestions_recycler_view, parent, false)
                SuggestionViewHolderVertical(view)
            }
            else -> {
                PostHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.feed_item,
                        parent,
                        false
                    )
                )
            }
        }

    }

    override fun getItemCount(): Int = posts.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        if (holder.itemViewType == SUGGESTIONS_VIEW) {
            suggestionView(holder as SuggestionViewHolderVertical)
        }

        if (holder.itemViewType == POST_VIEW) {
            val holder = holder as PostHolder
            holder.bind(posts[position])
        }

    }

    override fun getItemViewType(position: Int): Int {
        if (position == 1) {
            return SUGGESTIONS_VIEW
        }

        return POST_VIEW

    }

}


private fun suggestionView(holder: SuggestionViewHolderVertical) {
    val adapter = SuggestionAdapter(MainActivity.getSuggestions())
    with(holder.recycler) {
        layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
            context,
            androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,
            false
        )
        this.adapter = adapter
    }
}


class PostHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(post: Post) {
        with(itemView) {
            imageView_user.setImageResource(post.userImage)
            textView_user.text = post.username
            imageView_post.setImageResource(post.imagePost)
            textView_user_like.text = post.likeTo
            textView_user_owner.text = post.username
            textView_comment.text = post.description
            imageView_comment_user.setImageResource(post.imageCommentUser)
            textView_post_time.text = post.postTime
        }
    }

}

class SuggestionViewHolderVertical(view: View) : RecyclerView.ViewHolder(view) {

    var recycler: RecyclerView

    init {
        with(itemView) {
            recycler = suggestion_recycler_view
        }
    }
}
