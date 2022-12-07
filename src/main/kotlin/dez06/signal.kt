package dez06

import java.io.File
import kotlin.test.assertEquals

fun main() {
    test06()

    val input = File(ClassLoader.getSystemResource("dez06/input.txt").toURI()).readText()
    println(signal(input, 4))
    println(signal(input, 14))
}

fun signal(input: String, distincts: Int): Int {
    for (i in 0..input.length - distincts) {
        if (input.substring(i, i + distincts).isDistinct()) {
            return i + distincts
        }
    }
    return 0
}

private fun String.isDistinct() =
    this.toCharArray().toSet().size == this.toCharArray().size




private fun test06() {
    mapOf(
        "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 7,
        "bvwbjplbgvbhsrlpgdmjqwftvncz" to 5,
        "nppdvjthqldpwncqszvftbrmjlhg" to 6,
        "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 10,
        "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 11
    ).forEach { (k, v) ->
        assertEquals(signal(k, 4), v)
    }
    mapOf(
        "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to 19,
        "bvwbjplbgvbhsrlpgdmjqwftvncz" to 23,
        "nppdvjthqldpwncqszvftbrmjlhg" to 23,
        "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 29,
        "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 26
    ).forEach { (k, v) ->
        assertEquals(signal(k, 14), v)
    }
}