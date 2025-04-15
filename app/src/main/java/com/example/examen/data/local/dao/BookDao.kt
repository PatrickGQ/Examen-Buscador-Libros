package com.example.examen.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.examen.data.local.entity.BookEntity

@Dao
interface BookDao {

    @Insert
    suspend fun insert(book: BookEntity)

    @Query("SELECT * FROM books")
    suspend fun getAll(): List<BookEntity>
}