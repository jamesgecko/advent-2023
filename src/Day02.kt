import java.io.*

fun main() {
    fun parse_game(input: String): MutableList<MutableMap<String, Int>> {
        var result = mutableListOf<MutableMap<String, Int>>()
        val rounds = input.split(": ")[1];
        val hands = rounds.split("; ");
        for(hand in hands) {
            val shown = mutableMapOf<String, Int>()
            for (balls in hand.split(", ")) {
                val (number, color) = balls.split(" ")
                shown[color] = number.toInt()
            }
            result.add(shown)
        }
        return result
    }

    fun part1(input: List<String>): Int {
        val total = mapOf<String, Int>("red" to 12, "green" to 13, "blue" to 14)
        var answer = 0
        for((index, game: String) in input.withIndex()) {
            var good = true
            val parsed = parse_game(game);
            for (hand in parsed) {
                if (hand.getOrDefault("red", 0) > total.getOrDefault("red", 0)) { good = false }
                if (hand.getOrDefault("green", 0) > total.getOrDefault("green", 0)) { good = false }
                if (hand.getOrDefault("blue", 0) > total.getOrDefault("blue", 0)) { good = false }
            }
            if (good) {
                answer += index + 1
            }
        }
        return answer
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    println("test")
    val testInput = readInput("Day02_test1")
    println(part1(testInput))
    check(part1(testInput) == 8)

    val input = readInput("Day02")
    println("part 1")
    part1(input).println()
    println("part 2")
    part2(input).println()
}
