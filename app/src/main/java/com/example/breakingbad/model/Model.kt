package com.example.breakingbad.model

import com.squareup.moshi.Json

//characters api
data class Character(
    @Json(name = "name") val name: String,
    @Json(name = "img") val image: String
)

//quotes api
data class Quote(
    @Json(name = "quote") val quote: String,
    @Json(name = "author") val author: String
)

//episode api
data class Episode(
    @Json(name = "title") val title: String,
    @Json(name = "season") val season: String,
    @Json(name = "air_date") val air_date: String,
    @Json(name = "characters") val characters: Array<String>
)

//death api
data class Death(
    @Json(name = "death") val death: String,
    @Json(name = "cause") val cause: String,
    @Json(name = "responsible") val responsible: String,
    @Json(name = "last_words") val last_words: String,
    @Json(name = "season") val season_death: String,
    @Json(name = "episode") val episode_death: String,
    @Json(name = "number_of_deaths") val number_of_deaths: String
)