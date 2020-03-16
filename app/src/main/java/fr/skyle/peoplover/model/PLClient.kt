package fr.skyle.peoplover.model

import android.content.Context
import androidx.room.Room


class PLClient private constructor(context: Context) {

    // App database object
    val database: PLDatabase = Room.databaseBuilder(context, PLDatabase::class.java, "PLDatabase").build()

    companion object {
        private var instance: PLClient? = null

        @Synchronized
        fun getInstance(context: Context): PLClient {
            if (instance == null) {
                instance = PLClient(context)
            }
            return instance!!
        }
    }
}