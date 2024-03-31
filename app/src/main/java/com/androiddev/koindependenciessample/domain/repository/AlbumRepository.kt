package com.androiddev.koindependenciessample.domain.repository

import com.androiddev.koindependenciessample.domain.entities.Album
import com.androiddev.koindependenciessample.domain.result.Result

interface AlbumRepository {
    suspend fun getAlbums(): Result<List<Album>>
}