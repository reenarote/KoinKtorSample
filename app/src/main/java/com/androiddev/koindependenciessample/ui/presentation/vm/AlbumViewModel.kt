package com.androiddev.koindependenciessample.ui.presentation.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddev.koindependenciessample.domain.entities.Album
import com.androiddev.koindependenciessample.domain.usecases.GetAlbumUseCase
import com.androiddev.koindependenciessample.domain.result.Result
import com.androiddev.koindependenciessample.ui.presentation.event.AlbumEvent
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class AlbumViewModel(
    private val getAlbumUseCase: GetAlbumUseCase
) : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.IO + job

    val albumList = MutableLiveData<List<Album>>()

    fun loadAlbums() {
        viewModelScope.launch(coroutineContext) {
            val result = getAlbumUseCase.invoke()
            withContext(Dispatchers.Main)
            {
                when (result) {
                    is Result.Success -> {
                        Log.d("Size:", "${result.data.size}")
                        albumList.value = result.data.sortedBy { it.title }
                    }

                    is Result.Error -> {
                        albumList.value = listOf()
                    }
                }
            }
        }
    }

    fun onEvent(event: AlbumEvent) {
        when (event) {
            AlbumEvent.GetAlbums -> loadAlbums()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}