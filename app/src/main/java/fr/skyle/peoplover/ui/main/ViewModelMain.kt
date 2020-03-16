package fr.skyle.peoplover.ui.main

import fr.skyle.peoplover.base.viewmodel.AbstractViewModel
import fr.skyle.peoplover.model.entity.PeopLove
import fr.skyle.peoplover.repository.PeopLoveRepository


class ViewModelMain(private val peopLoveRepository: PeopLoveRepository) : AbstractViewModel() {

    suspend fun getPeopLoves() =
        peopLoveRepository.getPeopLoves()

    suspend fun insertPeopLoves(peopLoves: List<PeopLove>) =
        peopLoveRepository.insert(peopLoves)
}