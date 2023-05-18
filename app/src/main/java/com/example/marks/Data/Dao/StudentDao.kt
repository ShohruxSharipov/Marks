package com.example.marks.Data.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marks.Data.Entity.Students
import com.example.marks.Data.Entity.Teachers

@Dao
interface StudentDao {

    @Query("select * from Students")
    fun getStudents():List<Students>

    @Query("select * from Students where id = :id")
    fun getStudentsById(id:Int):Students

    @Insert
    fun addStudent(students: Students)

    @Query("select name from Students where clas = :clas")
    fun getStudentsByClass(clas:String):List<Students>

    @Query("select * from Students where login = :login and password = :password")
    fun findStudent(login:String,password:String):Students

}