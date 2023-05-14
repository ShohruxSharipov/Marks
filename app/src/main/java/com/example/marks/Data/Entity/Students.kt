package com.example.marks.Data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Students (
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var name:String,
    var login:String,
    var pasword:String,
    var clas:String)