package com.almseit.composition.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.almseit.composition.R
import com.almseit.composition.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView,count:Int){
    textView.text = String.format(textView.context.getString(R.string.required_score),count)
}

@BindingAdapter("score")
fun bindScore(textView: TextView,score:Int){
    textView.text = String.format(
        textView.context.getString(R.string.score_answers),score)
}

@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textView: TextView,percent:Int){
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage),percent)
}

@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView,gameResult: GameResult){
    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),getPercentOfRightAnswers(gameResult)
    )
}

private fun getPercentOfRightAnswers(gameResult: GameResult) = with(gameResult) {
    if (countOfQuestions == 0) {
        0
    } else {
        ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
    }
}

@BindingAdapter("resultEmoji")
fun bindResultEmoji(imageView: ImageView,winner:Boolean){
    imageView.setImageResource(getSmileResId(winner))
}

private fun getSmileResId(winner: Boolean): Int{
    return if (winner){
        R.drawable.ic_smile
    }else{
        R.drawable.ic_sad
    }
}