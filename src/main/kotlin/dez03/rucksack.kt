package dez03

import java.io.File

fun main() {
    rucksack1()
    rucksack2()
}

fun rucksack1() {
    val res = File(ClassLoader.getSystemResource("dez03/input.txt").toURI()).readLines().sumOf {
        val items = mutableSetOf<Char>()
        it.toCharArray().forEachIndexed { i, c ->
            when {
                i < it.toCharArray().size / 2 -> items.add(c)
                items.contains(c) -> items.retainAll(setOf(c))
            }
        }
        if (items.first().code > 96) items.first().code - 96 else items.first().code - 38
    }
    println(res)
}

fun rucksack2() {
    var items = setOf<Char>()
    val res = File(ClassLoader.getSystemResource("dez03/input.txt").toURI()).readLines().mapIndexed { i, l ->
        when (i % 3) {
            0 -> {items = l.toCharArray().toSet(); 0 }
            1 -> {items = items.intersect(l.toCharArray().toSet()); 0}
            else -> {
                items = items.intersect(l.toCharArray().toSet())
                if (items.first().code > 96) items.first().code - 96 else items.first().code - 38
            }
        }
    }.sum()
    println(res)
}
