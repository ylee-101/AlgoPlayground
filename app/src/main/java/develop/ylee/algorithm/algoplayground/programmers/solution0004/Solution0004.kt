package develop.ylee.algorithm.algoplayground.programmers.solution0004

class Solution0004 {
    fun solution(name: String): Int {
        var answer = 0
        var prevIdx = 0
        var cnt = name.length * 2
        for (alpha in name) {
            answer += if (alpha <= 'N') { alpha - 'A' } else { 'Z' - alpha + 1 }
        }
        for (i in 0 until name.length) {
            if (name[i] != 'A') {
                if (i == 0) continue
                val rightFirst = prevIdx * 2 + (name.length - i)
                val leftFirst = (name.length - i) * 2 + prevIdx
                val curMin = returnMinNum(rightFirst, leftFirst)
                cnt = returnMinNum(cnt, curMin)
                prevIdx = i
            }
        }
        cnt = returnMinNum(prevIdx, cnt)
        return answer + cnt
    }

    fun returnMinNum(a: Int, b: Int): Int {
        return if (a <= b) a else b
    }
}
