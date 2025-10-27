package com.alexisserapio.contalana_prototipe.a.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alexisserapio.contalana_prototipe.a.data.db.model.ProductEntity
import com.alexisserapio.contalana_prototipe.a.utils.Constants

@Database(
    entities = [ProductEntity::class],
    version = 1
)
abstract class BusinessDatabase: RoomDatabase() {
    //Aquí va la función del DAO
    abstract fun prodcutDao(): ProductDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: BusinessDatabase? = null

        fun getDatabase(context: Context): BusinessDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BusinessDatabase::class.java,
                    Constants.DATABASE_NAME
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}