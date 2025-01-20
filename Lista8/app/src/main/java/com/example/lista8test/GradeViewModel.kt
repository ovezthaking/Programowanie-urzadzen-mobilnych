package com.example.lista8test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lista8test.GradeDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import com.example.lista8test.Grade

class GradeViewModel(private val gradeDao: GradeDao) : ViewModel() {

    // Zmieniamy typ na Flow
    val allGrades: Flow<List<Grade>> = gradeDao.getAllGrades()

    fun insert(grade: Grade) {
        viewModelScope.launch {
            gradeDao.insert(grade)
        }
    }

    fun delete(grade: Grade) {
        viewModelScope.launch {
            gradeDao.delete(grade)
        }
    }

    suspend fun getGradeById(id: Int): Grade? {
        // Uzyskaj listę ocen i znajdź ocenę o danym ID
        return gradeDao.getAllGrades().first().find { it.id == id }
    }

    fun update(grade: Grade) {
        viewModelScope.launch {
            gradeDao.update(grade)
        }
    }
}


