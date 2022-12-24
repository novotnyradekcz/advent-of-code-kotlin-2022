fun main() {
    fun part1(input: List<String>): Int {
        var total = 0
        for (line in input) {
            val sections = line.split(",")  //  [1-2, 3-4]
            val firstElf = sections[0].split("-")   //  [1, 2]
            val secondElf = sections[1].split("-")  //  [3, 4]
            if ((firstElf[0].toInt() <= secondElf[0].toInt() && firstElf[1].toInt() >= secondElf[1].toInt()) ||
                (firstElf[0].toInt() >= secondElf[0].toInt() && firstElf[1].toInt() <= secondElf[1].toInt())) total++
        }
        return total
    }

    fun part2(input: List<String>): Int {
        var total = 0
        for (line in input) {
            val sections = line.split(",")  //  [1-2, 3-4]
            val firstElf = sections[0].split("-")   //  [1, 2]
            val secondElf = sections[1].split("-")  //  [3, 4]
            if ((firstElf[1].toInt() >= secondElf[0].toInt() && firstElf[0].toInt() <= secondElf[1].toInt()) ||
                (secondElf[1].toInt() >= firstElf[0].toInt() && secondElf[0].toInt() <= firstElf[1].toInt())) total++
        }
        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
