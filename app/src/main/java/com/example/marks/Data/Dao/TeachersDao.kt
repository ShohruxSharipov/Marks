package com.example.marks.Data.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marks.Data.Entity.Teachers

@Dao
interface TeachersDao {
    @Insert
    fun addTeacher(teachers: Teachers)

    @Query("select * from Teachers where login = :login and password = :password")
    fun findTeacher(login:String,password:String): Teachers
}