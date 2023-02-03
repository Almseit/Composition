package com.almseit.composition.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameSettings(
    val maxSumValue:Int,
    val minCountOfRightAnswers:Int,
    val minPercentOfRightAnswers:Int,
    val gameTimeSeconds:Int
) : Parcelable {

    val minCountOfRightAnswersString: String
        get() = minCountOfRightAnswers.toString()

    val minPercentOfRightAnswersString:String
        get() = minPercentOfRightAnswers.toString()
}