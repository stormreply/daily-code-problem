/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.reply.storm.dcp

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 */
fun containsSum(numbers: List<Int>, k: Int): Boolean {
    val complements: MutableSet<Int> = mutableSetOf()
    for (i in 0 until numbers.size) {
        if (complements.contains(numbers[i])) {
            return true
        }
        complements.add(k - numbers[i])
    }
    return false
}

fun main() {
    // contains sum
    val numbers: List<Int> = listOf(10, 15, 3, 7)
    val k = 17
    println("List of numbers $numbers contains sum $k: ${containsSum(numbers, k)}")

}
