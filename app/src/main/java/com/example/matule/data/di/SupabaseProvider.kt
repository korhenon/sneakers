package com.example.matule.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

@Module
@InstallIn(SingletonComponent::class)
class SupabaseProvider {
    @Provides
    fun provideSupabaseClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://akxsonxvlgwpevsjlvzu.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImFreHNvbnh2bGd3cGV2c2psdnp1Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzcyNzEwNjcsImV4cCI6MjA1Mjg0NzA2N30.RkAFW2U7U3fg2O_xA8DV5q3YWId_QdMm81OdZrmQoLI"
        ) {
            install(Auth)
            install(Postgrest)
        }
    }

    @Provides
    fun provideAuth(client: SupabaseClient): Auth {
        return client.auth
    }
}