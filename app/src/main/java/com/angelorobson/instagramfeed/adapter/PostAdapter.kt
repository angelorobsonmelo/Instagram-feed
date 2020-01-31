package com.angelorobson.instagramfeed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.angelorobson.instagramfeed.R
import com.angelorobson.instagramfeed.model.Post
import kotlinx.android.synthetic.main.feed_item.view.*

class PostAdapter(private val posts: List<Post>) : RecyclerView.Adapter<PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder =
        PostHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.feed_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bind(posts[position])
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
