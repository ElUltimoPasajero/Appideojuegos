package com.example.appvideojuegos.Entities

data class Videogame(

    val id: Int,
    var name: String,
    val platform: String,
    val year: Int,
    val country: String,
    val latitude: Double,
    val longitude: Double,
    val image: Int)

{

}