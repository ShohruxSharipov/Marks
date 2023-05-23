package com.example.marks.Data.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marks.Data.Entity.Students
import com.example.marks.Data.Entity.Teachers
import javax.security.auth.Subject

@Dao
interface StudentDao {

    @Query("select * from Students")
    fun getStudents():List<Students>

    @Query("select * from Students where id = :id")
    fun getStudentsById(id:Int):Students

//    @Query("select * from Students where id = :id")
//    fun getScoresBySubject(id: Int,subject: String):String
//


    @Insert
    fun addStudent(students: Students)

    @Query("select * from Students where clas = :clas")
    fun getStudentsByClass(clas:String):List<Students>

    @Query("select * from Students where login = :login and password = :password")
    fun findStudent(login:String,password:String):Students

    @Query("update Students set Student_marks = :baho where id = :id")
    fun addMark(baho:String,id: Int)

}