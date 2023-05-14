package com.example.marks.Data.Dao

import androidx.room.Dao
import androidx.room.Query
import com.example.marks.Data.Entity.Students

@Dao
interface StudentDao {

    @Query("select * from Students")
    fun getStudents():List<Students>

    @Query("select * from Students where clas = :clas")
    fun getStudentsByClass(clas:String):List<Students>
}