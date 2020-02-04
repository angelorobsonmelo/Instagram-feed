package com.angelorobson.instagramfeed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.angelorobson.instagramfeed.MainActivity
import com.angelorobson.instagramfeed.R
import com.angelorobson.instagramfeed.model.Post
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.feed_item.view.*
import kotlinx.android.synthetic.main.suggestions_recycler_view.view.*
import kotlin.math.sign

class PostAdapter(private val posts: List<Post>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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

    override fun getItemCount(): Int = posts.size + 1


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == SUGGESTIONS_VIEW) {
            suggestionView(holder as SuggestionViewHolderVertical)
        }

        if (holder.itemViewType == POST_VIEW) {
            val holder = holder as PostHolder

            if (position > 1) {
                holder.bind(posts[position - 1])
                return
            }

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

            Picasso.get()
                .load(post.userImage)
                .into(imageView_user)

            textView_user.text = post.username

            Picasso.get()
                .load(post.imagePost)
                .into(imageView_post)

            textView_user_like.text = post.likeTo
            textView_user_owner.text = post.username
            textView_comment.text = post.description

            Picasso.get()
                .load(post.imageCommentUser)
                .into(imageView_comment_user)

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
