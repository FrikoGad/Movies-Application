package com.example.moviesapplication.screens.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapplication.MAIN
import com.example.moviesapplication.R
import com.example.moviesapplication.SaveShared
import com.example.moviesapplication.databinding.FragmentDetailBinding
import com.example.moviesapplication.databinding.FragmentMainBinding
import com.example.moviesapplication.models.MovieItemModel
import com.example.moviesapplication.models.MoviesModel
import com.example.moviesapplication.screens.favorite.FavoriteFragmentViewModel
import com.example.moviesapplication.screens.main.MainAdapter
import retrofit2.Response

class DetailFragment : Fragment() {

    private var mBinding: FragmentDetailBinding? = null
    private val binding get() = mBinding!!
    private var isFavorite = false
    lateinit var currentMovie: MovieItemModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentMovie = arguments?.getSerializable("movie") as MovieItemModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun init() {
        val valueBoolean = SaveShared.getFavorite(MAIN, currentMovie.kinopoiskId.toString())
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        val movie = viewModel.getMovieRetrofit(currentMovie.kinopoiskId)
        val id = currentMovie.kinopoiskId

        var kek: Response<MovieItemModel>
        viewModel.myMovie.observe(this) {
            kek = it
        }
        var  lol = 4

        if (isFavorite != valueBoolean) {
            binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }

        Glide.with(MAIN)
            .load(currentMovie.posterUrlPreview)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imgDetail)
        binding.tvTitle.text = currentMovie.nameRu
        binding.tvDate.text = currentMovie.premiereRu

        binding.imgDetailFavorite.setOnClickListener {
            isFavorite = if (isFavorite == valueBoolean) {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                SaveShared.setFavorite(MAIN, currentMovie.kinopoiskId.toString(), true)
                viewModel.insert(currentMovie) {}
                true
            } else {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                SaveShared.setFavorite(MAIN, currentMovie.kinopoiskId.toString(), false)
                viewModel.delete(currentMovie) {}
                false
            }
        }
    }
}