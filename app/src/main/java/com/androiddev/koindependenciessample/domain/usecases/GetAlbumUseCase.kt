package com.androiddev.koindependenciessample.domain.usecases

import com.androiddev.koindependenciessample.domain.entities.Album
import com.androiddev.koindependenciessample.domain.result.Result

interface GetAlbumUseCase {
  suspend fun invoke(): Result<List<Album>>
}