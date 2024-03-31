package com.androiddev.koindependenciessample.data.remote.ktor

import com.androiddev.koindependenciessample.data.remote.AlbumResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.post

class AlbumKtorApiImpl(val httpClient: HttpClient) : AlbumKtorApi {

    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val GET_ALBUMS_ENDPOINT = "albums"


    override suspend fun getAlbums() =
        httpClient.get<List<AlbumResponse>>("$BASE_URL$GET_ALBUMS_ENDPOINT")

    suspend fun postAlbum(id: Int) = httpClient.post<AlbumResponse>(
        body = {}

    )
}
