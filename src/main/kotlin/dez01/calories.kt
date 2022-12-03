package dez01

import java.io.File

fun main () {

    val max = intArrayOf(0,0,0)
    var sum = 0
    File(ClassLoader.getSystemResource("dez01/input.txt").toURI()).forEachLine{
        if (it == ""){
            if (max[0] < sum) {
                max[2] = max[1]
                max[1] = max[0]
                max[0] = sum
            } else if (max[1] < sum) {
                max[1] = max[0]
                max[1] = sum
            } else if (max[2] < sum) {
                max[2] = sum
            }
            sum = 0
        } else {
            sum += it.toInt()
        }
    }
    println(max[0] + max[1] + max[2])

}