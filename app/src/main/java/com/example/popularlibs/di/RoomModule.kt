package com.example.popularlibs.di

import android.content.Context
import androidx.room.Room
import com.example.popularlibs.data.room.DBStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideRoom(context: Context): DBStorage =
        Room.databaseBuilder(context, DBStorage::class.java, "github.db")
            .build()

}
