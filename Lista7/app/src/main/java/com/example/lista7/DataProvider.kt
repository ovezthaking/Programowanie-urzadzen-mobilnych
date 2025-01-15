package com.example.lista7

import android.util.Log
import com.example.lista7.Student
import java.util.Locale
import java.util.Random

object DataProvider {
    private val firstNames: List<String> = mutableListOf(
        "Adam",
        "Ewa",
        "Jan",
        "Anna",
        "Piotr",
        "Maria",
        "Tomasz",
        "Małgorzata",
        "Krzysztof",
        "Alicja",
        "Andrzej",
        "Joanna",
        "Michał",
        "Barbara",
        "Kamil",
        "Magdalena",
        "Robert",
        "Monika",
        "Mateusz",
        "Natalia"
    )

    private val lastNames: List<String> = mutableListOf(
        "Nowak",
        "Kowalski",
        "Wiśniewski",
        "Wójcik",
        "Kowalczyk",
        "Kamiński",
        "Lewandowski",
        "Zieliński",
        "Szymański",
        "Woźniak",
        "Dąbrowski",
        "Kozłowski",
        "Jankowski",
        "Mazur",
        "Kwiatkowski",
        "Krawczyk",
        "Piotrowski",
        "Grabowski",
        "Nowakowski",
        "Pawłowski"
    )
    private val random = Random()

    val students: List<Student> = generateStudents(41)

    private fun generateStudents(count: Int): List<Student> {
        val students: MutableList<Student> = ArrayList()

        for (i in 0 until count) {
            val newStudent = Student()
            newStudent.name = getRandomElement(firstNames)
            newStudent.lastName = getRandomElement(lastNames)
            newStudent.academicYear = random.nextInt(3) + 1

            val indexNumber = String.format(
                Locale.getDefault(), "3%d%d%d%d%d",
                random.nextInt(10), random.nextInt(10), random.nextInt(10),
                random.nextInt(10), random.nextInt(10)
            )
            newStudent.indexNumber = indexNumber
            Log.d("DataProvider", "Generated indexNumber: $indexNumber")

            var gradesMean = 2.0 + (5.0 - 2.0) * random.nextDouble()
            gradesMean = Math.round(gradesMean * 100) / 100.0
            newStudent.gradesMean = gradesMean

            students.add(newStudent)
        }
        return students
    }

    private fun getRandomElement(list: List<String>): String {
        val index = random.nextInt(list.size)
        return list[index]
    }
}
