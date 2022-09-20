package com.submission.sportapp.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.submission.sportapp.core.ui.SportsAdapter
import com.submission.sportapp.favorite.databinding.ActivityFavoriteBinding
import com.submission.sportapp.ui.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Favorite"

        loadKoinModules(favoriteModule)

        val sportsAdapter = SportsAdapter()
            sportsAdapter.onItemClick = { selectedData ->
                val intent = Intent(this@FavoriteActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

        favoriteViewModel.favoriteSports.observe(this, { dataSports ->
            sportsAdapter.setData(dataSports)
            binding.viewEmpty.root.visibility = if (dataSports.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvSports){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = sportsAdapter
        }
    }

}