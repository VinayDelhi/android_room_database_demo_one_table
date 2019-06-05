package com.demo.roomdatabase.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    @ColumnInfo(name="name")
    var name:String,

    @ColumnInfo(name = "companyName")
    var companyName:String,

    @Ignore
    var isSelected: Boolean = false



) {
    // Used for resolve a bug in Room database.
     constructor() : this(0, "", "", false)
  }