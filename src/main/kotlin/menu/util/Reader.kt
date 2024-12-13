package menu.util

import menu.model.Coach

object Reader {
    fun getCoaches(): List<Coach> {
        val result: MutableList<Coach> = mutableListOf()
        retryUntilSuccess {
            val coaches = readLine("코치의 이름을 입력해 주세요. (, 로 구분)").split(",")
            validateCoachCount(coaches)
            validateCoachNameLength(coaches, result)
        }
        return result
    }

    private fun validateCoachCount(coaches: List<String>) {
        if (coaches.size !in 2..5) {
            throw IllegalArgumentException("코치는 최소 2명, 최대 5명까지 식사를 함께 해야 합니다.")
        }
    }

    private fun validateCoachNameLength(
        coaches: List<String>,
        result: MutableList<Coach>
    ) {
        coaches.forEach { name ->
            when (name.length in 2..4) {
                true -> result.add(Coach(name))
                false -> throw IllegalArgumentException("코치의 이름은 2자에서 4자 사이어야 합니다.")
            }
        }
    }

    fun getHateFoods(coaches: List<Coach>) {
        coaches.forEach { coach ->
            val hates = readLine("\n${coach.name}(이)가 못 먹는 메뉴를 입력해 주세요.").split(",")
            if (hates.size !in 0..2) throw IllegalArgumentException("못 먹는 메뉴가 너무 많아요!")
            coach.hate.addAll(hates)
        }
    }
}
