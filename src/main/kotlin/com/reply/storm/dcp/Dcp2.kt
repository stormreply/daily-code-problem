package com.reply.storm.dcp

/**
 * Given an array of integers, return a new array such that each element at index i of the new array is the product
 * of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * Follow-up: what if you can't use division?
 */
class Dcp2(private vararg val numbers: Int) {
    fun productOfAllOthers(): IntArray {
        val prod = numbers.reduce { acc, i -> acc * i }
        return numbers.map { prod / it }.toIntArray()
    }

    fun productOfAllOthersWithoutDivision() = numbers.mapIndexed { index, _ ->
        (numbers.dropLast(numbers.size - index) + numbers.drop(index + 1)).reduce { acc, j -> acc * j }
    }.toIntArray()
}