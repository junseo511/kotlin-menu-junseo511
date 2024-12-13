package menu.ui

import camp.nextstep.edu.missionutils.Randoms
import menu.domain.Selector.getRandomCategory
import menu.model.Menu.getMenu
import menu.util.Reader.getCoaches
import menu.util.Reader.getHateFoods

class GongBaekMenuPicker {
    fun run() {
        println("점심 메뉴 추천을 시작합니다.\n")
        val coaches = getCoaches()
        val categories = getRandomCategory()
        getHateFoods(coaches)
        println("\n메뉴 추천 결과입니다.")
        println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]")
        println("[ 카테고리 | ${categories[0].title} | ${categories[1].title} | ${categories[2].title} | ${categories[3].title} | ${categories[4].title} ]")
        categories.forEach { category ->
            coaches.forEach { coach ->
                var randomMenu: String
                while (true) {
                    randomMenu = Randoms.shuffle(getMenu(category))[0]
                    if (!coach.menu.contains(randomMenu) && !coach.hate.contains(randomMenu)) {
                        coach.menu.add(randomMenu)
                        break
                    }
                }
            }
        }
        coaches.forEach { coach ->
            println("[ ${coach.name} | ${coach.menu[0]} | ${coach.menu[1]} | ${coach.menu[2]} | ${coach.menu[3]} | ${coach.menu[4]} ]")
        }
        println("\n추천을 완료했습니다.")
    }
}
