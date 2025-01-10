package com.example.overvieworganization.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel private constructor() : ViewModel() {
    private val _data = MutableLiveData<String>()
    val data: LiveData<String>
        get() = _data
    fun setData(newData: String) {
        _data.value = newData
    }

    private val _employee = MutableLiveData<String>()
    val employee: LiveData<String>
        get() = _employee
    fun setEmployee(newEmployee: String){
        _employee.value = newEmployee
    }

    companion object {
        private var instance: AppViewModel? = null

        fun getInstance(): AppViewModel {
            if (instance == null) {
                instance = AppViewModel()
            }
            return instance!!
        }
    }
}