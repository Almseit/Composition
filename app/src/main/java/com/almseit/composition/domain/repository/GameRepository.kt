package com.almseit.composition.domain.repository

import com.almseit.composition.domain.entity.GameSettings
import com.almseit.composition.domain.entity.Level
import com.almseit.composition.domain.entity.Questions

interface GameRepository {

    fun generateQuestion(maxSumValue:Int,countOfOptions:Int) : Questions

    fun getGameSettings(level:Level) : GameSettings
}