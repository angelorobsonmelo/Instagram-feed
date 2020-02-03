package com.angelorobson.instagramfeed.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.angelorobson.instagramfeed.MainActivity.Companion.getPosts
import com.angelorobson.instagramfeed.MainActivity.Companion.getStories
import com.angelorobson.instagramfeed.R
import com.angelorobson.instagramfeed.model.Post
import com.angelorobson.instagramfeed.model.Story
import kotlinx.android.synthetic.main.post_recycler_view.view.*
import kotlinx.android.synthetic.main.stories_recycler_view.view.*

class MainAdapter(private val objects: MutableList<Any>, private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val STORY_VIEW = 0
    private val FEED_VIEW = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View
        var holder: RecyclerView.ViewHolder? = null

        when (viewType) {
            STORY_VIEW -> {
                view = inflater.inflate(R.layout.stories_recycler_view, parent, false)
                holder = StoryViewHolderHorizontal(view)
            }
            FEED_VIEW -> {
                view = inflater.inflate(R.layout.post_recycler_view, parent, false)
                holder = PostViewHolderVertical(view)
            }
        }

        return holder!!

    }

    override fun getItemCount(): Int = objects.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == STORY_VIEW) {
            storyView(holder as StoryViewHolderHorizontal)
        } else if (holder.itemViewType == FEED_VIEW) {
            postView(holder as PostViewHolderVertical)
        }
    }

    private fun storyView(holder: StoryViewHolderHorizontal) {
        val adapter = StoryAdapter(getStories())
        with(holder.recyclerView) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            this.adapter = adapter
        }

    }

    private fun postView(holder: PostViewHolderVertical) {
        val adapter = PostAdapter(getPosts())
        with(holder.recyclerView) {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (objects[position] is Post) {
            return FEED_VIEW
        }
        if (objects[position] is Story) {
            return STORY_VIEW
        }

        return -1
    }

}

class StoryViewHolderHorizontal(view: View) : RecyclerView.ViewHolder(view) {

    var recyclerView: RecyclerView

    init {
        with(itemView) {
            recyclerView = story_recyclerView
        }
    }
}

class PostViewHolderVertical(view: View) : RecyclerView.ViewHolder(view) {

    var recyclerView: RecyclerView

    init {
        with(itemView) {
            recyclerView = recyclerView_feed
        }
    }
}