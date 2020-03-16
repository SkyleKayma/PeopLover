package fr.skyle.peoplover.model

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.skyle.peoplover.model.dao.PeopLoveDao
import fr.skyle.peoplover.model.entity.PeopLove

@Database(entities = [PeopLove::class], version = 2)
abstract class PLDatabase : RoomDatabase() {

    abstract fun peopLoveDao(): PeopLoveDao
}