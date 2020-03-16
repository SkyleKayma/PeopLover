package fr.skyle.peoplover.repository

import fr.skyle.peoplover.model.dao.PeopLoveDao
import fr.skyle.peoplover.model.entity.PeopLove

/**
 * Created by Openium on 19/02/2019.
 */
class PeopLoveRepository(private val peopLoveDao: PeopLoveDao) {

    suspend fun getPeopLove(peopLoveId: Long): PeopLove =
        peopLoveDao.getPeopLove(peopLoveId)

    suspend fun getPeopLoves(): List<PeopLove> =
        peopLoveDao.getPeopLoves()

    suspend fun update(peopLove: PeopLove): Int =
        peopLoveDao.update(peopLove)

    suspend fun update(peopLoves: List<PeopLove>): Int =
        peopLoveDao.update(peopLoves)

    suspend fun insert(peopLove: PeopLove): Long =
        peopLoveDao.insert(peopLove)

    suspend fun insert(peopLoves: List<PeopLove>): List<Long> =
        peopLoveDao.insert(peopLoves)
}