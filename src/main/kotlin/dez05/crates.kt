package dez04

import java.io.File

fun main() {
    crates1()
    crates2()
}

fun crates1() {
    val c = arrayListOf<ArrayList<Char>>()
    var move = false
    File(ClassLoader.getSystemResource("dez05/input.txt").toURI()).forEachLine {
        if (!move) {
            if (it.startsWith(" 1")) {
                move = true
            } else {
                for (i in 0..it.length / 4) {
                    val x = it.toCharArray()[i * 4 + 1]
                    if (c.size <= i){
                        c.add(arrayListOf())
                    }
                    if (x != ' '){
                        c[i] += x
                    }
                }
            }
        } else if (it.isNotBlank()) {
            val (anz, from, to) = Regex("^move (.+) from (.+) to (.+)$").find(it)!!.groupValues.subList(1, 4).map { it.toInt() }
            for (y in 1..anz){
                c[to - 1].add(0, c[from - 1].removeFirst())
            }

        }
    }
    println(c.map { it.first() }.joinToString(""))
}

fun crates2() {
    val c = arrayListOf<ArrayList<Char>>()
    var move = false
    File(ClassLoader.getSystemResource("dez05/input.txt").toURI()).forEachLine {
        if (!move) {
            if (it.startsWith(" 1")) {
                move = true
            } else {
                for (i in 0..it.length / 4) {
                    val x = it.toCharArray()[i * 4 + 1]
                    if (c.size <= i){
                        c.add(arrayListOf())
                    }
                    if (x != ' '){
                        c[i] += x
                    }
                }
            }
        } else if (it.isNotBlank()) {
            val (anz, from, to) = Regex("^move (.+) from (.+) to (.+)$").find(it)!!.groupValues.subList(1, 4).map { it.toInt() }
            for (y in 1..anz){
                c[to - 1].add(0, c[from - 1].removeAt(anz-y))
            }

        }
    }
    println(c.map { it.first() }.joinToString(""))
}
