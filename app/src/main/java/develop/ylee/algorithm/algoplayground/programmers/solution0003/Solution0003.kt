package develop.ylee.algorithm.algoplayground.programmers.solution0003

class Solution0003 {
    var stones: IntArray = intArrayOf()
    fun solution(stones: IntArray, k: Int): Int {
        val stoneList = stones.toList()
        val min = stoneList.minOrNull()?:0
        val max = stoneList.maxOrNull()?:0
        if (min == max) return stones.size
        var answer = 0
        this.stones = stones
        while (goStones(k)) {
            answer++
        }
        return answer
    }

    fun goStones(k: Int): Boolean {
        val size = stones.size
        var idx = 0
        while (idx < size) {
            stones[idx]--
            var nextStone = 1
            while (idx + nextStone < size && stones[idx + nextStone] == 0) {
                nextStone++
            }
            if (nextStone > k) return false
            idx += nextStone
        }
        return true
    }
}