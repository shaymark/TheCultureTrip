package com.markoapps.theculturetrip.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.markoapps.theculturetrip.R
import com.markoapps.theculturetrip.models.Article
import kotlinx.android.synthetic.main.activity_articles.*


class ArticlesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles)


        val articleList = intent.getSerializableExtra(ArticlesKey) as List<Article>

        listview.apply {
            adapter = ArticlesAdapter()
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                ItemOffsetDecoration(context, R.dimen.item_offset)
            )
        }

        (listview.adapter as ArticlesAdapter).submitList(articleList)

    }


    companion object {
        const val ArticlesKey = "articles"

        fun getActivityIntent(context: Context, articles: List<Article>) =
            Intent(context, ArticlesActivity::class.java).apply {
                putExtra(ArticlesKey, ArrayList(articles))
            }

    }

}