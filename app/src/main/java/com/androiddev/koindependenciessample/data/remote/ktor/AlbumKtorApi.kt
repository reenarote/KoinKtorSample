package com.androiddev.koindependenciessample.data.remote.ktor

import com.androiddev.koindependenciessample.data.remote.AlbumResponse
import retrofit2.Response

interface AlbumKtorApi {
    suspend fun getAlbums(): List<AlbumResponse>
}