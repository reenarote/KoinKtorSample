package com.androiddev.koindependenciessample.data.repository

import com.androiddev.koindependenciessample.domain.entities.Album
import com.androiddev.koindependenciessample.domain.repository.AlbumRepository
import com.androiddev.koindependenciessample.data.mapper.AlbumResponseToModelMapper
import com.androiddev.koindependenciessample.data.remote.AlbumApi
import com.androiddev.koindependenciessample.data.remote.ktor.AlbumKtorApi
import com.androiddev.koindependenciessample.data.utils.Connectivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.androiddev.koindependenciessample.domain.result.Result

class AlbumRepositoryImpl(
    private val albumApi: AlbumApi,
    private val connectivity: Connectivity,
    private val albumKtorApi: AlbumKtorApi
) : AlbumRepository {
    override suspend fun getAlbums(): Result<List<Album>> {
        val albumList: List<Album> = AlbumResponseToModelMapper.map(albumKtorApi.getAlbums())

//        if (connectivity.hasNetwork()) {
//                albumList =
//                    albumApi.getAlbums().body()?.let { AlbumResponseToModelMapper.map(it) }
//        }

        return when (albumList.isEmpty()) {
            true -> Result.Error(Throwable("No Entries Found"))
            else -> Result.Success(albumList)
        }
    }
}
