package com.opalynskyi.cleanmovies.app.mainscreen.movies

import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.opalynskyi.cleanmovies.R
import com.opalynskyi.cleanmovies.app.DateTimeHelper
import com.opalynskyi.cleanmovies.app.mainscreen.movies.adapter.ItemType
import com.opalynskyi.cleanmovies.app.mainscreen.movies.adapter.ListItem
import com.opalynskyi.cleanmovies.app.mainscreen.movies.adapter.MovieItem
import com.opalynskyi.cleanmovies.app.mainscreen.movies.adapter.MovieItemComparator

fun createListWithHeaders(dateTimeHelper: DateTimeHelper, movieItems: List<MovieItem>): List<ListItem> {
    val listWithHeaders = mutableListOf<ListItem>()
    val sortedMovieItems = movieItems.sortedWith(MovieItemComparator)
    var headerMonth = -1
    var header: ListItem? = null
    for (i in 0 until sortedMovieItems.size) {
        val currentMovie = sortedMovieItems[i]
        if (headerMonth == -1 || headerMonth != currentMovie.month) {
            headerMonth = currentMovie.month
            header = ListItem(
                type = ItemType.HEADER,
                headerTitle = dateTimeHelper.getHeaderDate(currentMovie.releaseDate)
            )
            listWithHeaders.add(header)
        }
        val item = ListItem(type = ItemType.ITEM, movie = currentMovie, header = header)
        header?.children?.add(item)
        listWithHeaders.add(item)
    }
    return listWithHeaders
}

fun share(context: Context, text: String) {
    val sharingIntent = Intent(Intent.ACTION_SEND)
    sharingIntent.type = "text/plain"
    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, text)
    context.startActivity(Intent.createChooser(sharingIntent, "Share favourite movie"))
}

fun startAnimation(viewGroup: ViewGroup) {
    val resId = R.anim.layout_animation_right_to_left
    val animation = AnimationUtils.loadLayoutAnimation(viewGroup.context, resId)
    viewGroup.layoutAnimation = animation
}