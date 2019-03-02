package com.opalynskyi.cleanmovies.core.data.movies

import com.opalynskyi.cleanmovies.core.data.EntityMapper
import com.opalynskyi.cleanmovies.core.data.movies.entities.MovieEntity
import com.opalynskyi.cleanmovies.core.domain.movies.entities.Movie

class MoviesMapper : EntityMapper<MovieEntity, Movie> {
    override fun mapFromEntity(entity: MovieEntity) = Movie(
        entity.id,
        entity.overview,
        entity.releaseDate,
        entity.posterPath,
        entity.title,
        entity.voteAverage,
        entity.isFavourite
    )

    override fun mapToEntity(domain: Movie) = MovieEntity(
        domain.id,
        domain.overview,
        domain.releaseDate,
        domain.posterPath,
        domain.title,
        domain.voteAverage,
        domain.isFavourite
    )
}