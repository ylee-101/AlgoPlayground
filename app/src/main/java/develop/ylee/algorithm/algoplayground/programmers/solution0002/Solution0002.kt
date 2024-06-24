package develop.ylee.algorithm.algoplayground.programmers.solution0002

class Solution0002 {


    lateinit var appeachInfo : IntArray
    fun solution(n: Int, info: IntArray): IntArray {
        appeachInfo = info
        val lionInfo = IntArray(11){i -> 0}
        return dfs(0, n, lionInfo)
    }

    fun dfs(idx: Int, leftArrow: Int, lionInfo: IntArray): IntArray {
        if (idx == 11) {
            return if (calculateScore(lionInfo) > 0) lionInfo else intArrayOf(-1)
        } else if (idx == 10 && leftArrow > 0) {
            return dfs(idx+1, 0, lionInfo.copyOf().apply { this[10] = leftArrow })
        }
        val skipScore = dfs(idx+1, leftArrow, lionInfo)
        val spentArrow = appeachInfo[idx] + 1
        val addScore : IntArray =
            if (spentArrow <= leftArrow) {
                dfs(idx+1, leftArrow - spentArrow, lionInfo.copyOf().apply { this[idx] = spentArrow })
            } else {
                dfs(idx+1, leftArrow, lionInfo)
            }
        val answer = if (calculateScore(skipScore) < calculateScore(addScore)) {
            addScore
        } else {
            skipScore
        }
        if (idx == 5) {
            println(answer.toList().toString())
        }
        return answer
    }

    fun calculateScore(lionInfo : IntArray) : Int {
        if (lionInfo[0] == -1) {
            return -1
        }
        var lionScore = 0
        var apeachScore = 0
        for (i in 0..10) {
            if (lionInfo[i] > appeachInfo[i]) {
                lionScore += 10 - i
            } else if (lionInfo[i] <= appeachInfo[i] && appeachInfo[i] != 0) {
                apeachScore += 10 - i
            }
        }
        return lionScore - apeachScore
    }

}
