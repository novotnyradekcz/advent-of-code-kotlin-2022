fun main() {
    fun part1(input: List<String>): Int {
        var total = 0
        val lower = "abcdefghijklmnopqrstuvwxyz"
        val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        for (line in input) {
            var temp = ' '
            for (i in 0 until line.length / 2) {
                for (j in line.length / 2 until line.length) {
                    if (line[i] == line[j] && line[i] != temp) {
                        if (line[i] in lower) total += lower.indexOf(line[i]) + 1
                        if (line[i] in upper) total += upper.indexOf(line[i]) + 27
                        temp = line[i]
                    }
                }
            }
        }
        return total
    }

    fun part2(input: List<String>): Int {
        var total = 0
        var i = 0
        val lower = "abcdefghijklmnopqrstuvwxyz"
        val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        while (i < input.size - 2) {
            var temp = ' '
            for (j in lower) {
                if (j in input[i] && j in input[i + 1] && j in input[i + 2] && j != temp) {
                    total += lower.indexOf(j) + 1
                    temp = j
                }
            }
            for (j in upper) {
                if (j in input[i] && j in input[i + 1] && j in input[i + 2] && j != temp) {
                    total += upper.indexOf(j) + 27
                    temp = j
                }
            }
            i += 3
        }
        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
