package com.androiddev.koindependenciessample.ui.presentation.event

sealed class AlbumEvent {
    data object GetAlbums : AlbumEvent()
}