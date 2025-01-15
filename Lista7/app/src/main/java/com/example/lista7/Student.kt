package com.example.lista7


import android.util.Log
import java.util.Objects

class Student {
    var indexNumber: String? = null
    set(value) {
        field = value
        Log.d("Student", "Set indexNumber: $value")
    }
    var name: String? = null
    var lastName: String? = null
    var gradesMean: Double? = null
    var academicYear: Int? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val student = o as Student
        return indexNumber == student.indexNumber && name == student.name && lastName == student.lastName && Objects.equals(
            gradesMean,
            student.gradesMean
        ) && academicYear == student.academicYear
    }

    override fun hashCode(): Int {
        return Objects.hash(indexNumber, name, lastName, gradesMean, academicYear)
    }
}