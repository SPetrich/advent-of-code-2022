package dez04

import java.io.File

fun main() {
    cleanup1()
    cleanup2()
}

fun cleanup1() {
    val res = File(ClassLoader.getSystemResource("dez04/input.txt").toURI()).readLines().sumOf {
        val c = it.split("-", ",").map { it.toInt() }
        if ((c[0]..c[1]).toSet().subtract((c[2]..c[3]).toSet()).isEmpty() || (c[2]..c[3]).toSet().subtract((c[0]..c[1]).toSet()).isEmpty()) 1L else 0L
    }
    println(res)
}

fun cleanup2() {
    val res = File(ClassLoader.getSystemResource("dez04/input.txt").toURI()).readLines().sumOf {
        val c = it.split("-", ",").map { it.toInt() }
        if ((c[0]..c[1]).toSet().intersect((c[2]..c[3]).toSet()).isEmpty() || (c[2]..c[3]).toSet().intersect((c[0]..c[1]).toSet()).isEmpty()) 0L else 1L
    }
    println(res)
}