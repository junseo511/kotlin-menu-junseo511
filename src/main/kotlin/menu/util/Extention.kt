package menu.util

import camp.nextstep.edu.missionutils.Console

fun readLine(input: String): String {
    println(input)
    return Console.readLine()
}

inline fun <T> retryUntilSuccess(block: () -> T): T {
    while (true) {
        try {
            return block()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }
}
