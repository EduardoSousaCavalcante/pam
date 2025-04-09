package com.example.appaula.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import androidx.room.Room
import com.example.appaula.data.dao.ClienteDao
import com.example.appaula.data.model.Cliente

@Database(entities = [Cliente::class], version = 1, exportSchema = false)
abstract class EmpresaDatabase : RoomDatabase() {
    abstract fun clienteDao(): ClienteDao

    companion object {
        @Volatile
        private var Instance: EmpresaDatabase? = null

        fun getDatabase(context: Context): EmpresaDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, EmpresaDatabase::class.java, "empresa")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
