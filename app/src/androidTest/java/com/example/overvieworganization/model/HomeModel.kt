package com.example.overvieworganization.model

class HomeModel {
    private val _home = mutableSetOf<String>()
    val home: Set<String>
        get() = _home
}