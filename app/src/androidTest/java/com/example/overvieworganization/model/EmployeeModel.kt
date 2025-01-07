package com.example.overvieworganization.model

class EmployeeModel {
    private val _employee = mutableSetOf<String>()
    val employee: Set<String>
        get() = _employee
}