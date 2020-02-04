package com.angelorobson.instagramfeed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.angelorobson.instagramfeed.R
import com.angelorobson.instagramfeed.model.Suggestion
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.story_item.view.*
import kotlinx.android.synthetic.main.suggestion_item.view.*

class SuggestionAdapter(private val suggestions: List<Suggestion>) :
    RecyclerView.Adapter<SuggestionHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuggestionHolder =
        SuggestionHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.suggestion_item, parent, false)
        )


    override fun getItemCount(): Int = suggestions.size

    override fun onBindViewHolder(holder: SuggestionHolder, position: Int) {
        holder.bind(suggestions[position])
    }


}

class SuggestionHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(suggestion: Suggestion) {
        with(itemView) {
            Picasso.get()
                .load(suggestion.imageUser)
                .into(image_user_suggestion)

            textview_username_suggestion.text = suggestion.username
            textview_info_user_suggestion.text = suggestion.userInfo
            button_suggestion.text = suggestion.textButton
        }
    }

}
