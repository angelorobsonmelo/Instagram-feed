package com.angelorobson.instagramfeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.angelorobson.instagramfeed.adapter.MainAdapter
import com.angelorobson.instagramfeed.model.Post
import com.angelorobson.instagramfeed.model.Story
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val recyclerView = recycler
        with(recyclerView) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MainAdapter(getObjects(), context)
        }
    }

    private fun getObjects(): MutableList<Any> {
        return mutableListOf(getStories()[0], getPosts()[0])
    }


    companion object {
        fun getStories(): MutableList<Story> {
            return mutableListOf(
                Story(R.drawable.jon_snow, "Seu Story"),
                Story(R.drawable.red_queen, "Red Queen"),
                Story(R.drawable.sansa, "Sansa Stark")
            )
        }

        fun getPosts(): MutableList<Post> {
            return mutableListOf(
                Post(
                    R.drawable.jon_snow,
                    "John Snow",
                    R.drawable.post_1,
                    "Sansa",
                    "Daenerys and me looking for dragons!",
                    R.drawable.jon_snow,
                    "Há 35 minutos"
                ),
                Post(
                    R.drawable.red_queen,
                    "Red Queen",
                    R.drawable.post_2,
                    "Jonh Snow",
                    "I am the queen!",
                    R.drawable.jon_snow,
                    "Há 3 horas"
                ),
                Post(
                    R.drawable.sansa,
                    "Sansa Stark",
                    R.drawable.post_3,
                    "John Snow",
                    "my winter clothes. In winter times that keep us warm, it is important to take this care not to die of hypothermia",
                    R.drawable.jon_snow,
                    "Há 8 horas"
                )
            )
        }
    }


}
