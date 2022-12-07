package dez07

import java.io.File

fun main() {
    device1()
    device2()
}

fun device1() {
    println(dirSums().map { it.value }.filter { it <= 100000 }.sum())
}

fun device2() {
    val dirSums = dirSums()
    println(dirSums.map { it.value }.filter { it >= 30000000 - (70000000 - dirSums["/"]!!) }.minOrNull())
}

private fun dirSums(): MutableMap<String, Int> {
    val dirSums = mutableMapOf<String, Int>()
    val dirStruct = arrayListOf<String>()
    File(ClassLoader.getSystemResource("dez07/input.txt").toURI()).readLines().forEach {
        when {
            it.startsWith("\$ cd ..") ->
                dirStruct.removeLast()
            it.startsWith("\$ cd") -> {
                val dir = (dirStruct.lastOrNull()?.plus("/") ?: "") + Regex("([a-z/]+)$").find(it)!!.groupValues[0]
                dirSums[dir] = 0
                dirStruct.add(dir)
            }
            it.toCharArray().first() in '0'..'9' -> {
                val size = Regex("^([0-9]+)").find(it)!!.groupValues[0].toInt()
                dirStruct.forEach { dirSums[it] = dirSums[it]?.plus(size) ?: 0 }
            }
        }
    }
    return dirSums
}