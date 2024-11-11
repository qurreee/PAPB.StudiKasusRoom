/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 * repository yang menyediakan insert update delete dan ambil [Item] dari data source yang diberi
 */
interface ItemsRepository {
    /**
     * Mengambil semua data dari sumber
     */
    fun getAllItemsStream(): Flow<List<Item>>

    /**
     * Mengambil data spesifik dengan referensi [id].
     */
    fun getItemStream(id: Int): Flow<Item?>

    /**
     * memasukkan data
     */
    suspend fun insertItem(item: Item)

    /**
     * menghapus data
     */
    suspend fun deleteItem(item: Item)

    /**
     * memperbarui data
     */
    suspend fun updateItem(item: Item)
}