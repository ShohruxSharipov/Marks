package com.example.marks.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.marks.Data.Dao.StudentDao
import com.example.marks.Data.Dao.TeachersDao
import com.example.marks.Data.Entity.Students
import com.example.marks.Data.Entity.Teachers

@Database(entities = [Students::class,Teachers::class], version = 1)
abstract class AppData : RoomDatabase(){
    abstract fun runStudents():StudentDao
    abstract fun runTeachers():TeachersDao

    companion object{
        var instance:AppData? = null

        fun getInstance(context: Context):AppData{
            if(instance == null){
                instance = Room.databaseBuilder(context,AppData::class.java,"app_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}