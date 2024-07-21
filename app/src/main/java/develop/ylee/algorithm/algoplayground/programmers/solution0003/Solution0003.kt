package develop.ylee.algorithm.algoplayground.programmers.solution0003

class Solution0003 {
    var stones: IntArray = intArrayOf()
    fun solution(stones: IntArray, k: Int): Int {
        var arrayMin = 200000000
        var arrayMax = 1
        for (stone in stones) {
            if (stone < arrayMin) arrayMin = stone
            if (stone > arrayMax) arrayMax = stone
        }
        if (arrayMin == arrayMax) return arrayMin
        if (stones.size < 100) {
            var answer  = arrayMin
            while (solveThisCase(stones, k, answer)) {
                answer++
            }
            return answer
        }
        var minAsw = arrayMin
        var maxAsw = arrayMax
        var answer = (minAsw + maxAsw) / 2
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
        if (minAsw == answer) {

        } else if (answer == maxAsw) {

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