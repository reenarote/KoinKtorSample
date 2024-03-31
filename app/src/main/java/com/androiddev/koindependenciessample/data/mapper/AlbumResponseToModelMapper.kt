package com.androiddev.koindependenciessample.data.mapper

import com.androiddev.koindependenciessample.data.remote.AlbumResponse
import com.androiddev.koindependenciessample.domain.entities.Album
import com.learn.album.data.mapper.Mapper

object AlbumResponseToModelMapper : Mapper<List<AlbumResponse>, List<Album>> {
    override fun map(from: List<AlbumResponse>): List<Album> {
        return from.map {
            Album(id = it.id, userId = it.userId, title = it.title)
        }
    }
}