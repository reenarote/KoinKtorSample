package com.androiddev.koindependenciessample.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface AlbumApi {
  @GET("albums")
  suspend fun getAlbums(): Response<List<AlbumResponse>>
}