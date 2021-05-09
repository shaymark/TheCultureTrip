package com.markoapps.theculturetrip.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.markoapps.theculturetrip.R
import com.markoapps.theculturetrip.models.Article
import kotlinx.android.synthetic.main.article_item.view.*

class ArticlesAdapter: ListAdapter<Article, ArticlesAdapter.ViewHolder>(ArticleDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.article_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(article: Article) {

            itemView.apply {
                val likeIcon = if(article.isLiked) R.drawable.liked else  R.drawable.like
                val saveIcon = if(article.isSaved) R.drawable.saved else  R.drawable.save

                Glide.with(this)
                    .load(likeIcon)
                    .into(like)

                Glide.with(this)
                    .load(saveIcon)
                    .into(save)

                Glide.with(this)
                    .load(article.imageUrl)
                    .into(image)

                Glide.with(this)
                    .load(article.author.authorAvatar.imageUrl)
                    .into(avatar)

                category.text = article.category
                title.text = article.title
                writer.text = article.author.authorName
                date.text = article.metaData.updateTime
                likeCounter.text = article.likesCount.toString()
            }

        }
    }

    class ArticleDiffUtil: DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }
}