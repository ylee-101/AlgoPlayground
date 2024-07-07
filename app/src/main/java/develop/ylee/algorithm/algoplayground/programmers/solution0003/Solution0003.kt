package develop.ylee.algorithm.algoplayground.programmers.solution0003

import android.util.Half

enum class STATUS {
    LEFT, RIGHT,
}
class Solution0003 {
    val min = 1
    val max = 200000000
    var stones: IntArray = intArrayOf()
    fun solution(stones: IntArray, k: Int): Int {
        // max 보다 큰 경우 개수 세기
        var maxAsw = max
        while (!solveThisCase(stones, k, maxAsw)) {
            maxAsw = maxAsw / 2
        }
        while (solveThisCase(stones, k, maxAsw)) {
            maxAsw++
        }
        return maxAsw
    }

    fun solveThisCase(stones: IntArray, k: Int, base: Int): Boolean {
        val size = stones.size
        if (base >= size) return false
        this.stones = IntArray(size) {idx -> stones[idx] - base}
        if (goStonesWithN(k, base)) return true
        return false
    }

    fun goStonesWithN(k: Int, n: Int): Boolean {
        val size = stones.size
        var idx = 0
        while (idx < size) {
            stones[idx] -= n
            var nextStone = 1
            while (idx + nextStone < size && stones[idx + nextStone] <= 0) {
                nextStone++
            }
            if (nextStone > k) return false
            idx += nextStone
        }
        return true
    }
}