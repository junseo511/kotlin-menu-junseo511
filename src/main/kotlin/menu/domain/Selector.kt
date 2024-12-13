package menu.domain

import camp.nextstep.edu.missionutils.Randoms
import menu.model.FoodCategory

object Selector {
    fun getRandomCategory(): List<FoodCategory> {
        val categories: MutableList<FoodCategory> = mutableListOf()
        val numbers: List<Int> = getRandomNumbers()

        numbers.forEach {
            categories.add(FoodCategory.entries[it - 1])
        }

        return categories
    }

    private fun getRandomNumbers(): List<Int> {
        val numbers: MutableList<Int> = mutableListOf()

        while (numbers.size < 5) {
            val randomNumber = Randoms.pickNumberInRange(1, 5)
            if (numbers.count { it == randomNumber } < 2) numbers.add(randomNumber)
        }
        return numbers
    }
}
