package fr.skyle.peoplover.model.dao

import androidx.room.*
import fr.skyle.peoplover.model.entity.PeopLove


@Dao
interface PeopLoveDao {

    // Query

    @Query("SELECT * FROM PeopLove WHERE uid == :peopLoveId LIMIT 1")
    suspend fun getPeopLove(peopLoveId: Long): PeopLove

    @Query("SELECT * FROM PeopLove")
    suspend fun getPeopLoves(): List<PeopLove>

    // Update

    @Update
    suspend fun update(peopLove: PeopLove): Int

    @Update
    suspend fun update(peopLoves: List<PeopLove>): Int

    // Insert

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(section: PeopLove): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sections: List<PeopLove>): List<Long>

    // Delete

    @Delete
    suspend fun delete(peopLove: PeopLove)

    @Delete
    suspend fun delete(peopLoves: List<PeopLove>)
}