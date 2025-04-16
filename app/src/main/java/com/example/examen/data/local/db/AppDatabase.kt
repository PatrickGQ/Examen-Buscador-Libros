package com.example.examen.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.examen.data.local.dao.BookDao
import com.example.examen.data.local.entity.BookEntity

@Database(entities = [BookEntity::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}