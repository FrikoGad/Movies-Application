package com.example.moviesapplication.screens.detail

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
import com.example.moviesapplication.databinding.FragmentDetailBinding
import com.example.moviesapplication.databinding.FragmentMainBinding
import com.example.moviesapplication.models.MovieItemModel
import com.example.moviesapplication.screens.favorite.FavoriteFragmentViewModel
import com.example.moviesapplication.screens.main.MainAdapter

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

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        Glide.with(MAIN)
            .load(currentMovie.posterUrlPreview)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imgDetail)
        binding.tvTitle.text = currentMovie.nameRu
        binding.tvDate.text = currentMovie.premiereRu
        binding.tvCountry.text = "Россия"

        binding.imgDetailFavorite.setOnClickListener {
            isFavorite = if (!isFavorite) {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
                true
            } else {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                false
            }
        }
    }
}