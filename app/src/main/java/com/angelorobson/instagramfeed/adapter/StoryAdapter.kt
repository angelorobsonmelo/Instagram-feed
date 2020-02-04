package com.angelorobson.instagramfeed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.angelorobson.instagramfeed.R
import com.angelorobson.instagramfeed.model.Story
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.feed_item.view.*
import kotlinx.android.synthetic.main.story_item.view.*

class StoryAdapter(private val stories: List<Story>) : RecyclerView.Adapter<StoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder =
        StoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.story_item, parent, false)
        )


    override fun getItemCount(): Int = stories.size

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(stories[position])
    }


}


class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(story: Story) {
        with(itemView) {
            Picasso.get()
                .load(story.userImage)
                .into(imageView_story)

            textView_username.text = story.username
        }
    }

}
