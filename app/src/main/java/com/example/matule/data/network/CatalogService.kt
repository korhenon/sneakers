package com.example.matule.data.network

import com.example.matule.data.models.Product
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import javax.inject.Inject

class CatalogService @Inject constructor(
    private val postgrest: Postgrest
) {
    suspend fun getAll(): List<Product> {
        return postgrest.from("catalog").select().decodeList<Product>()
    }
}