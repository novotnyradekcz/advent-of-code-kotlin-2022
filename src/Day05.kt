fun main() {
    fun part1(input: List<String>): String {
        // I was too lazy to figure out a way to read the input, so I copied the crate columns manually and deleted them from the input file
        val columns = mutableListOf<MutableList<Char>>()
        if (input.size == 4) {
            columns.add(mutableListOf('Z', 'N'))
            columns.add(mutableListOf('M', 'C', 'D'))
            columns.add(mutableListOf('P'))
        } else {
            columns.add(mutableListOf('R', 'P', 'C', 'D', 'B', 'G'))
            columns.add(mutableListOf('H', 'V', 'G'))
            columns.add(mutableListOf('N', 'S', 'Q', 'D', 'J', 'P', 'M'))
            columns.add(mutableListOf('P', 'S', 'L', 'G', 'D', 'C', 'N', 'M'))
            columns.add(mutableListOf('J', 'B', 'N', 'C', 'P', 'F', 'L', 'S'))
            columns.add(mutableListOf('Q', 'B', 'D', 'Z', 'V', 'G', 'T', 'S'))
            columns.add(mutableListOf('B', 'Z', 'M', 'H', 'F', 'T', 'Q'))
            columns.add(mutableListOf('C', 'M', 'D', 'B', 'F'))
            columns.add(mutableListOf('F', 'C', 'Q', 'G'))
        }
        for (line in input) {
            // move: 5(6), from: 12(13), to 17(18)
            val move: Int
            val from: Int
            val to: Int
            if (line[6] != ' ') {
                move = line.substring(5, 7).toInt()
                from = line[13].toString().toInt()
                to = line[18].toString().toInt()
            }
            else {
                move = line.substring(5, 6).toInt()
                from = line[12].toString().toInt()
                to = line[17].toString().toInt()
            }
            for (i in 1..move) {
                columns[to - 1].add(columns[from - 1].last())
                columns[from - 1].removeLast()
            }
        }
        var output = ""
        for (column in columns) output += (column.last())
        return output
    }

    fun part2(input: List<String>): String {
        val columns = mutableListOf<MutableList<Char>>()
        if (input.size == 4) {
            columns.add(mutableListOf('Z', 'N'))
            columns.add(mutableListOf('M', 'C', 'D'))
            columns.add(mutableListOf('P'))
        } else {
            columns.add(mutableListOf('R', 'P', 'C', 'D', 'B', 'G'))
            columns.add(mutableListOf('H', 'V', 'G'))
            columns.add(mutableListOf('N', 'S', 'Q', 'D', 'J', 'P', 'M'))
            columns.add(mutableListOf('P', 'S', 'L', 'G', 'D', 'C', 'N', 'M'))
            columns.add(mutableListOf('J', 'B', 'N', 'C', 'P', 'F', 'L', 'S'))
            columns.add(mutableListOf('Q', 'B', 'D', 'Z', 'V', 'G', 'T', 'S'))
            columns.add(mutableListOf('B', 'Z', 'M', 'H', 'F', 'T', 'Q'))
            columns.add(mutableListOf('C', 'M', 'D', 'B', 'F'))
            columns.add(mutableListOf('F', 'C', 'Q', 'G'))
        }
        for (line in input) {
            // move: 5(6), from: 12(13), to 17(18)
            val move: Int
            val from: Int
            val to: Int
            if (line[6] != ' ') {
                move = line.substring(5, 7).toInt()
                from = line[13].toString().toInt()
                to = line[18].toString().toInt()
            }
            else {
                move = line.substring(5, 6).toInt()
                from = line[12].toString().toInt()
                to = line[17].toString().toInt()
            }
            columns[to - 1].addAll(columns[from - 1].subList(columns[from - 1].size - move, columns[from - 1].lastIndex + 1))
            for (i in 1..move) {
                columns[from - 1].removeLast()
            }
        }
        var output = ""
        for (column in columns) output += (column.last())
        return output
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()
}
