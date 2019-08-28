package com.reply.storm.dcp

/**
 * Given an integer k and a string s, find the length of the longest
 * substring that contains at most k distinct characters.
 *
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */
class Dcp17(private val s: String, private val k: Int) {
    fun longestDistinctCharacterSubstring(): String {
        if (s.length <= k) {
            println("no need to check")
            print("- $s -> found")
            return s
        }

        var result: String = s.substring(0, k)

        for (i in k + 1..s.length) {
            if (result.length < i - 1) {
                println("no need to check further")
                break
            }
            println("checking size $i")
            for (j in 0..s.length - i) {
                val substr = s.substring(j, j + i)
                print("- $substr")
                if (substr.toCharArray().distinct().size <= k) {
                    println(" <- found")
                    result = substr
                } else {
                    println("")
                }
            }
        }

        return result
    }
}