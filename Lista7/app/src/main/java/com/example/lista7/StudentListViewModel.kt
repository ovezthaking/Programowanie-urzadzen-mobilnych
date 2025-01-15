package com.example.lista7


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StudentListViewModel : ViewModel() {
    private val _students = MutableStateFlow<List<Student>>(emptyList())
    val students: StateFlow<List<Student>> = _students

    init {
        loadStudents()
        Log.d("ViewModel", "Loaded students: ${_students.value}")
    }

    private fun loadStudents() {
        viewModelScope.launch {
            _students.value = DataProvider.students
        }
    }
}