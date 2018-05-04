package ru.endlesscode.miet.orioks.presentation.common.navigation

import ru.terrakok.cicerone.*

import java.util.*

class LocalCiceroneHolder {

    private val containers: HashMap<String, Cicerone<Router>> = HashMap()

    fun getCicerone(containerTag: String): Cicerone<Router> {
        return containers.getOrPut(containerTag, { Cicerone.create() })
    }
}
