package com.example.project.services

import Movie
import com.example.project.models.User
import com.example.project.utils.ApiRequest
import com.example.project.utils.ApiResponse
import com.google.gson.Gson

class AuthService
{
    fun login(user: User): ApiResponse
    {
        return ApiRequest.post(ApiRequest.LOGIN_URL, Gson().toJson(user))
    }

    fun register(user: User): ApiResponse
    {
        return ApiRequest.post(ApiRequest.REGISTER_URL, Gson().toJson(user))
    }

    fun movie(movie: Movie): ApiResponse
    {
        return ApiRequest.post(ApiRequest.MOVIE_URL, Gson().toJson(movie))
    }
}