package com.opalynskyi.cleanmovies.app.mainscreen.movies

import com.opalynskyi.cleanmovies.app.DateTimeHelper
import com.opalynskyi.cleanmovies.app.mainscreen.movies.adapter.MovieItem
import com.opalynskyi.cleanmovies.core.movies.domain.entities.Movie

class MovieListMapper(private val dateTimeHelper: DateTimeHelper) {
    fun mapToMovieItem(movie: Movie) = MovieItem(
        movie.id,
        movie.overview ?: "",
        movie.releaseDate,
        movie.posterPath,
        movie.title ?: "",
        movie.voteAverage,
        movie.isFavourite,
        dateTimeHelper.getYear(movie.releaseDate),
        dateTimeHelper.getMonth(movie.releaseDate)
    )
}