package com.example.project.services

import com.example.project.models.User
import com.example.project.utils.ApiRequest
import com.google.gson.Gson
import java.net.HttpURLConnection

class StudentService
{
    fun get(id: Int): User?
    {
        val response = ApiRequest.get("${ApiRequest.USERS_URL}?id=$id")
        if (response.code == HttpURLConnection.HTTP_NOT_FOUND)
            return null

        return Gson().fromJson(response.message, User::class.java)
    }

    fun getAll(): Array<User>
    {
        val response = ApiRequest.get(ApiRequest.USERS_URL)
        if (response.code == HttpURLConnection.HTTP_NO_CONTENT)
            return arrayOf()

        return Gson().fromJson(response.message, Array<User>::class.java)
    }

    fun add(user: User)
    {
        val userJson = Gson().toJson(user)
        ApiRequest.post(ApiRequest.USERS_URL, userJson)
    }

    fun update(id: Int, user: User)
    {
        val userJson = Gson().toJson(user)
        ApiRequest.put("${ApiRequest.USERS_URL}?id=$id", userJson)
    }

    fun delete(id: Int)
    {
        ApiRequest.delete("${ApiRequest.USERS_URL}?id=$id")
    }
}