import java.io.*
import kotlin.math.*

fun main() {
    fun parse(card: String): Array<List<Int>> {
        val numbers: String = card.split(": ")[1]
        val split_numbers = numbers.split(" | ")
        val whitespace = "[ ]+".toRegex()
        val winners = split_numbers[0].trim().split(whitespace).map { it.toInt() }
        val candidates = split_numbers[1].trim().split(whitespace).map { it.toInt() }
        return arrayOf(winners, candidates)
    }

    fun part1(input: List<String>): Int {
        val cards = input.map { parse(it) }
        var score = 0
        for (card in cards) {
            val matches = card[0].intersect(card[1]).count()
            val card_score = when (matches) {
                0 -> 0
                1 -> 1
                else -> 2.toDouble().pow(matches - 1).toInt()
            }
            score += card_score
        }
        return score
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    println("test")
    val testInput = readInput("Day04_test1")
    // println(part1(testInput))
    check(part1(testInput) == 13)

    val input = readInput("Day04")
    println("part 1")
    part1(input).println()
    println("part 2")
    part2(input).println()
}
