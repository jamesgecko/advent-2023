import java.io.*

fun main() {
    fun part1(input: List<String>): Int {
        val digits = input.map { line -> line.filter { it.isDigit() } }
        val calibration = digits.map { "${it.first()}${it.last()}".toInt() }
        return calibration.sum()
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = readInput("Day01_test1")
    check(part1(testInput) == 142)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
