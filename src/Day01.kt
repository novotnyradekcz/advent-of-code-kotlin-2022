fun main() {
    fun part1(input: List<String>): Int {
        var calories = 0
        val maxima = mutableListOf<Int>()
        for (line in input) {
            if (line == "") {
                maxima.add(calories)
                calories = 0
            } else {
                calories += line.toInt()
            }
        }
        maxima.add(calories)
        return maxima.max()
    }

    fun part2(input: List<String>): Int {
        var calories = 0
        val maxima = mutableListOf<Int>()
        for (line in input) {
            if (line == "") {
                maxima.add(calories)
                calories = 0
            } else {
                calories += line.toInt()
            }
        }
        maxima.add(calories)
        var topThree = 0
        topThree += maxima.max()   // highest
        maxima.remove(maxima.max())
        topThree += maxima.max()   // second highest
        maxima.remove(maxima.max())
        topThree += maxima.max()   // third highest
        return topThree
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
