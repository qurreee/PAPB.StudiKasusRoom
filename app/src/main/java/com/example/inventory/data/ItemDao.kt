package com.example.inventory.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * beri anotasi @Dao dan @Insert di dalam interface beri fungsi suspend agar
 * dapat terpisah thread nya ketika di run
 * buat 2 fungsi lain untuk update dan delete dengan anotasi masing-masing
 */
@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item : Item)

    @Update
    suspend fun update(item : Item)

    @Delete
    suspend fun delete(item : Item)

    //membuat QUery yang bisa mengambil id diambil oleh fun getItem yang mengembalikan Flow
    @Query("SELECT * from items WHERE id = :id")
    fun getItem(id : Int): Flow<Item>

    //quert untuk getallitem
    @Query("SELECT * from items ORDER BY name ASC")
    fun getAllItems(): Flow<List<Item>>
}