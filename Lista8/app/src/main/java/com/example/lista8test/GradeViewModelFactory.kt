package com.example.lista8test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lista8test.GradeViewModel

class GradeViewModelFactory(private val gradeDao: GradeDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GradeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GradeViewModel(gradeDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}