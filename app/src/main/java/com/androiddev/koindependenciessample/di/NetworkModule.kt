package com.androiddev.koindependenciessample.di

import android.util.Log
import com.androiddev.koindependenciessample.data.remote.AlbumApi
import com.androiddev.koindependenciessample.data.remote.ktor.AlbumKtorApi
import com.androiddev.koindependenciessample.data.remote.ktor.AlbumKtorApiImpl
import com.androiddev.koindependenciessample.data.repository.AlbumRepositoryImpl
import com.androiddev.koindependenciessample.domain.repository.AlbumRepository
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.DefaultRequest
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

private const val TIME_OUT = 6000

val networkModule = module {
    single { get<Retrofit>().create(AlbumApi::class.java) }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(AlbumApi::class.java)
    }

    // Ktor
    factory<AlbumKtorApi> { AlbumKtorApiImpl(get()) }

    single {
        HttpClient(Android) {
            install(JsonFeature)
            {
                KotlinxSerializer(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })

                engine {
                    connectTimeout = TIME_OUT
                    socketTimeout = TIME_OUT
                }

                //Logging
                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            Log.d("HttpLogging:", message)
                        }

                    }
                }

                //Http Response
                install(ResponseObserver) {
                    onResponse { response ->
                        Log.d("HTTP status:", "${response.status.value}")
                    }
                }

                // Headers
                install(DefaultRequest) {
                    header(HttpHeaders.ContentType, ContentType.Application.Json)
                }

            }

        }

    }
}
