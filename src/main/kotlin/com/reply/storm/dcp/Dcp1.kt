package com.reply.storm.dcp

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * Bonus: Can you do this in one pass?
 */
class Dcp1(val numbers: List<Int>) {
    fun containsSum(k: Int): Boolean {
        val complements: MutableSet<Int> = mutableSetOf()
        for (i in 0 until numbers.size) {
            if (complements.contains(numbers[i])) {
                return true
            }
            complements.add(k - numbers[i])
        }
        return false
    }
}