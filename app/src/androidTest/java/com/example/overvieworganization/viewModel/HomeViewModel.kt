package com.example.overvieworganization.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.overvieworganization.model.HomeModel

class HomeViewModel {
    private val homeModel = HomeModel()

    private val _home = MutableLiveData<List<String>>()
    val cards: LiveData<List<String>>
        get() = _home

    fun check() {
//        val modelCards = HomeModel.cards
//        val numbers = modelCards.map { getNumber(it) }
//        val shapes = modelCards.map { getShape(it) }
//
//        _cardRank.value = when {
//            isStraightFlush(numbers, shapes) -> "스트레이트 플러시"
//            isFourOfAKind(numbers) -> "포카드"
//            isFullHouse(numbers) -> "풀 하우스"
//            isFlush(shapes) -> "플러시"
//            isStraight(numbers) -> "스트레이트"
//            isThreeOfAKind(numbers) -> "트리플"
//            isTwoPair(numbers) -> "투페어"
//            isOnePair(numbers) -> "원페어"
//            else -> "노페어"
//            //우선순위가 높은것부터 나열
//        }
    }

//    private fun isStraightFlush(numbers: List<String>, shapes: List<String>): Boolean {
//        return isStraight(numbers) && isFlush(shapes)
//        ///스트레이트 이면서 플러시
//    }
}