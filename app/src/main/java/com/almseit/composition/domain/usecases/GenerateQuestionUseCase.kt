package com.almseit.composition.domain.usecases

import com.almseit.composition.domain.entity.Questions
import com.almseit.composition.domain.repository.GameRepository

class GenerateQuestionUseCase(private val gameRepository: GameRepository) {

    operator fun invoke(maxSumValue:Int) : Questions{
        return gameRepository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    private companion object{
        private const val COUNT_OF_OPTIONS = 6
    }
}