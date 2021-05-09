package com.markoapps.theculturetrip.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.markoapps.theculturetrip.R
import com.markoapps.theculturetrip.core.Status
import com.markoapps.theculturetrip.models.Article
import com.markoapps.theculturetrip.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showArticlesBtn.setOnClickListener {
            viewModel.getArticles().observe(this, { result ->

                showArticlesBtn.isEnabled = result.status != Status.LOADING

                when (result.status) {
                    Status.SUCCESS -> openArticlesActivity(result.data!!)
                    Status.ERROR -> showError(result.message!!)
                }
            })
        }

    }

    private fun openArticlesActivity(articles: List<Article>){
        val intent = Intent(this, ArticlesActivity::class.java).apply {
            putExtra(ArticlesActivity.ArticlesKey,ArrayList(articles))
        }
        startActivity(intent)
    }

    private fun showError(message: String) {

    }


}