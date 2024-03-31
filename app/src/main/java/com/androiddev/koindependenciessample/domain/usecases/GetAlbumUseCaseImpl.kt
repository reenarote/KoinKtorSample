package com.androiddev.koindependenciessample.domain.usecases

import com.androiddev.koindependenciessample.domain.entities.Album
import com.androiddev.koindependenciessample.domain.repository.AlbumRepository
import com.androiddev.koindependenciessample.domain.result.Result
import com.androiddev.koindependenciessample.domain.usecases.GetAlbumUseCase

class GetAlbumUseCaseImpl(private val albumRepository: AlbumRepository) : GetAlbumUseCase {
  override suspend fun invoke(): Result<List<Album>> {
    return albumRepository.getAlbums()
  }
}