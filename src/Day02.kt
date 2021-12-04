data class Input(val direction: String, val value: Int)
data class Position(var distance: Int, var depth: Int)
data class AdvPosition(var distance: Int, var depth: Int, var aim: Int)

fun main() {
    fun part1(input: List<String>): Int {
        val position = Position(0, 0)

        input.map {
            val inputs = it.split(" ")
            Input(inputs[0], inputs[1].toInt())
        }.forEach {
            when (it.direction) {
                "forward" -> position.distance += it.value
                "down" -> position.depth += it.value
                "up" -> position.depth -= it.value
            }
        }

        return position.depth * position.distance
    }

    fun part2(input: List<String>): Int {
        val position = AdvPosition(0, 0, 0)

        input.map {
            val inputs = it.split(" ")
            Input(inputs[0], inputs[1].toInt())
        }.forEach {
            when (it.direction) {
                "forward" -> {
                    position.distance += it.value
                    position.depth += position.aim * it.value
                }
                "down" -> position.aim += it.value
                "up" -> position.aim -= it.value
            }
        }

        return position.depth * position.distance
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("inputs/Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("inputs/Day02")
    println(part1(input))
    println(part2(input))
}