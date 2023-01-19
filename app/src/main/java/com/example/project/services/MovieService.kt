package com.example.project.services

import android.media.Image
import com.example.project.utils.ApiRequest
import com.example.project.utils.ApiResponse
import com.google.gson.Gson

class MovieService
{
    fun getAllMovie(): ApiResponse
    {
        return ApiRequest.get(ApiRequest.MOVIE_URL)
    }

    fun  getMovieImages(movieImage: Image): ApiResponse
    {
        return ApiRequest.post(ApiRequest.MOVIE_URL, Gson().toJson(movieImage))
    }
}