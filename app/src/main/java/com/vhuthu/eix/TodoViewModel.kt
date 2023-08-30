package com.vhuthu.eix

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vhuthu.eix.model.Todos
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {
    private val _todoList = mutableStateListOf<Todos>()
    var errorMessage: String by mutableStateOf("")
    val todoList: List<Todos>
        get() = _todoList

    fun getTodoList() {
        viewModelScope.launch {
            val token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huZG9lQGdtYWlsLmNvbSIsInJvbGVzIjoiUk9MRV9GQVJNRVIiLCJpYXQiOjE2OTM0MTQ1MjgsImV4cCI6MTY5NzAxNDUyOH0.VwNAa_umIaQ7qSYjS2sQMoLhRQr29aMFURJdxOlIntk"
            val apiService = ApiService.getInstance(token)

            try {
                _todoList.clear()
                _todoList.addAll(apiService.getTodos(token))

                for (todo in _todoList) {
                    Log.d("TodoViewModel", "Fetched Todo: $todo")
                }

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}