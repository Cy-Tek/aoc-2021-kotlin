fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        val numbers = input.map { it.toInt() }
        for (i in 1 until numbers.size) {
            result += if (numbers[i] > numbers[i - 1]) 1 else 0
        }

        return result
    }

    fun part2(input: List<String>): Int {
        check(input.size > 3) // We need to have at least 4 elements to check the sliding window

        var result = 0
        val numbers = input.map { it.toInt() }
        val sums = mutableListOf<Int>()

        sums.add(numbers[0] + numbers[1] + numbers[2])

        for (i in 1..numbers.size - 3) {
            sums.add(numbers[i] + numbers[i + 1] + numbers[i + 2])
            result += if (sums[i] > sums[i - 1]) 1 else 0
        }

        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("inputs/Day01_test")
    check(part1(testInput) == 5)

    val input = readInput("inputs/Day01")
    println(part1(input))
    println(part2(input))
}
