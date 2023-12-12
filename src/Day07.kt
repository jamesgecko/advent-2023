import java.io.*
import kotlin.math.*

enum class HandType {
    FIVE_OF_A_KIND, FOUR_OF_A_KIND, FULL_HOUSE,
    THREE_OF_A_KIND, TWO_PAIR, ONE_PAIR, HIGH_CARD
}

val order = listOf('A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2')

fun main() {
    fun parse(input: String): Array<List<String>> {
    }

    fun sortHands(hands: List<String>) {
        val withType = hands.map { listOf(it, classifier(it)) }
        withType.sortedBy {  }
    }

    fun classifier(hand: String): HandType {
        var cardsByType = hashMapOf<String, Int>():
        for (card in hand) {
            cardsByType.
            val key = card.toString()
            val count = cardsByType.getOrDefault(key, 0)
            cardsByType[key] = count + 1
        }
        val pattern = cardsByType.values.sortedDescending().toString()
        return when (pattern) {
            "[5]" -> HandType.FIVE_OF_A_KIND
            "[4, 1]" -> HandType.FOUR_OF_A_KIND
            "[3, 2]" -> HandType.FULL_HOUSE
            "[3, 1, 1]" -> HandType.THREE_OF_A_KIND
            "[2, 2, 1]" -> HandType.TWO_PAIR
            "[2, 1, 1, 1]" -> HandType.ONE_PAIR
            else -> HandType.HIGH_CARD
        }
    }

    fun tiebreaker_compare(hand1: String, hand2: String): String {
        for (i in 0..4) {
            val card1Rank = order.indexOf(hand1[i])
            val card2Rank = order.indexOf(hand2[i])
            if (card1Rank < card2Rank) {
                return hand1
            } else if (card2Rank > card1Rank) {
                return hand2
            }
        }
        return hand1
    }

    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    println("test")
    val testInput = readInput("Day07_test1")
    println(part1(testInput))
    check(part1(testInput) == 6440)

    val input = readInput("Day04")
    println("part 1")
    part1(input).println()
    println("part 2")
    part2(input).println()
}
