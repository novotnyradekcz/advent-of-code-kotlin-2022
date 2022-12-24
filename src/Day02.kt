fun main() {
    fun part1(input: List<String>): Int {
        var score = 0
        for (line in input) {
            when (line[2]) {
                'X' -> {
                    score += 1  // rock
                    if (line[0] == 'A') score += 3  // rock - draw
                    if (line[0] == 'B') score += 0  // paper - loss
                    if (line[0] == 'C') score += 6  // scissors - win
                }
                'Y' -> {
                    score += 2  // paper
                    if (line[0] == 'A') score += 6  // rock - win
                    if (line[0] == 'B') score += 3  // paper - draw
                    if (line[0] == 'C') score += 0  // scissors - loss
                }
                'Z' -> {
                    score += 3  // scissors
                    if (line[0] == 'A') score += 0  // rock - loss
                    if (line[0] == 'B') score += 6  // paper - win
                    if (line[0] == 'C') score += 3  // scissors - draw
                }
            }
        }
        return score
    }

    fun part2(input: List<String>): Int {
        var score = 0
        for (line in input) {
            when (line[2]) {
                'X' -> {
                    score += 0  // lose
                    if (line[0] == 'A') score += 3  // scissors
                    if (line[0] == 'B') score += 1  // rock
                    if (line[0] == 'C') score += 2  // paper
                }
                'Y' -> {
                    score += 3  // draw
                    if (line[0] == 'A') score += 1  // rock
                    if (line[0] == 'B') score += 2  // paper
                    if (line[0] == 'C') score += 3  // scissors
                }
                'Z' -> {
                    score += 6  // win
                    if (line[0] == 'A') score += 2  // paper
                    if (line[0] == 'B') score += 3  // scissors
                    if (line[0] == 'C') score += 1  // rock
                }
            }
        }
        return score
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
