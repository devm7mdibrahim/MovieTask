package com.devm7mdibrahim.presentation.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.devm7mdibrahim.domain.model.MovieItem
import com.devm7mdibrahim.presentation.base.BaseRecyclerAdapter
import com.devm7mdibrahim.presentation.base.BaseViewHolder
import com.devm7mdibrahim.presentation.databinding.ItemMovieBinding
import com.devm7mdibrahim.presentation.utils.loadImageFromUrl

class MoviesAdapter(val onMovieClicked: (MovieItem) -> Unit) :
    BaseRecyclerAdapter<MovieItem, ItemMovieBinding, MoviesAdapter.MoviesViewHolder>(MovieDiffUtil) {

    object MovieDiffUtil : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

    inner class MoviesViewHolder(private val binding: ItemMovieBinding) :
        BaseViewHolder<MovieItem, ItemMovieBinding>(binding) {

        override fun bind() {
            getRowItem()?.let { movie ->
                binding.tvTitle.text = movie.title
                binding.ivLogo.loadImageFromUrl(movie.posterPath)

                itemView.setOnClickListener { onMovieClicked.invoke(movie) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}