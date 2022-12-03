package dez02

import java.io.File

fun main () {
    rps1()
    rps2()
}

fun rps1 () {
    val map = mapOf(
        "A X" to 4,
        "A Y" to 8,
        "A Z" to 3,
        "B X" to 1,
        "B Y" to 5,
        "B Z" to 9,
        "C X" to 7,
        "C Y" to 2,
        "C Z" to 6
    )

    var res = 0
    File(ClassLoader.getSystemResource("dez02/input.txt").toURI()).forEachLine{
        res += map[it]!!
    }

    println(res)
}


fun rps2 () {
    val map = mapOf(
        "A X" to 3,
        "A Y" to 4,
        "A Z" to 8,
        "B X" to 1,
        "B Y" to 5,
        "B Z" to 9,
        "C X" to 2,
        "C Y" to 6,
        "C Z" to 7
    )

    var res = 0
    File(ClassLoader.getSystemResource("dez02/input.txt").toURI()).forEachLine{
        res += map[it]!!
    }

    println(res)
}
