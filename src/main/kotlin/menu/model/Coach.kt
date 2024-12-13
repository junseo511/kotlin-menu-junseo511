package menu.model

data class Coach(
    val name: String,
    val hate: MutableList<String> = mutableListOf(),
    val menu: MutableList<String> = mutableListOf(),
)
