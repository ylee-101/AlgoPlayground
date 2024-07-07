package develop.ylee.algorithm.algoplayground.programmers.solution0003

class Solution0003 {

    fun solution(stones: IntArray, k: Int): Int {
        val stoneList = stones.toList()
        var min = stoneList.min()
        var max = stoneList.max()
        var answer : Int = (min + max) / 2
        while (min < max){
            if (canGo(stones, answer, k)) {
                min = answer
                answer = (min + max) / 2
                if (min == answer) return answer
            } else {
                max = answer
                answer = (min + max) / 2
                if (max == answer) return answer
            }
        }
        return answer
    }

    fun canGo(stones: IntArray, num: Int, base: Int): Boolean {
        val curSize = stones.size
        val tmp = IntArray(curSize){idx -> stones[idx] - num}
        var idx = 0
        while (idx < curSize) {
            while (tmp[idx] > 0) {
                idx++
                if (idx == curSize) return true
            }
            var cur = idx
            while (tmp[cur] <= 0) {
                cur++
                if (cur - idx > base) return false
                if (cur == curSize) return true
            }
            idx = cur
        }
        return true
    }
}