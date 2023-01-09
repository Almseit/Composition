package com.almseit.composition.domain.usecases

import com.almseit.composition.domain.entity.GameSettings
import com.almseit.composition.domain.entity.Level
import com.almseit.composition.domain.repository.GameRepository

class GetGamesSettingsUseCase(private val gameRepository: GameRepository) {

    operator fun invoke(level: Level) : GameSettings{
        return gameRepository.getGameSettings(level)
    }
}