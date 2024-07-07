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
        if (stones.size == 1) return stones[0]
        if (stones.size < 100) {
            var answer  = min
            while (solveThisCase(stones, k, answer)) {
                answer++
            }
            return answer
        }
        var minAsw = min
        var maxAsw = max
        var answer = (min + max) / 2
        while (minAsw < answer && answer < maxAsw) {
            val more = solveThisCase(stones, k, answer)
            if (more) {
                minAsw = answer
                answer = (minAsw + maxAsw) / 2
            } else {
                maxAsw = answer
                answer = (minAsw + maxAsw) / 2
            }
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