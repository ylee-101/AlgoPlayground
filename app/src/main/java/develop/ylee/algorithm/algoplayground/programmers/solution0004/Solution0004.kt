package develop.ylee.algorithm.algoplayground.programmers.solution0003
class Solution0004 {
//    var curWord : Array<Char> = Array(20) {'A'}

    // A-Z is 65~90 : i + 65 (i in 0..25) 총 26개 i = num % 26
    // J : A -> J = 74-65 = 9 // Z -> J = 90 - 74 = 16 => 17(A->Z)
    // N : A -> N = 78 - 65 = 13 // Z -> N = 90 - 78 = 12 => 13
    // alpha in A..N -> alpha - A
    // alpha in O..Z -> Z - alpha + 1

    fun rightMoveNum(name : String): Int {
        var answer = 0
        val size = name.length
        var curWord = CharArray(size){'A'}
        for (i in 0..(size - 1)) {
            curWord[i] = name[i]
            if (String(curWord) == name) break;
            answer ++
        }
        return answer
    }

    fun leftMoveNum(name : String): Int {
        var answer = 1
        val size = name.length
        val curWord = CharArray(size){'A'}
        curWord[0] = name[0]
        for (i in 0..(size - 1)) {
            curWord[size - 1 - i] = name[size - 1 - i]
            println(String(curWord) + ", " + name)
            if (String(curWord) == name) break;
            answer ++
        }
        return answer
    }

    fun solution(name: String): Int {
//        curWord = Array(name.length){'A'}
        if (name.length == 0) return 0
        var answer = 0
        for (alpha in name) {
            if (alpha <= 'N') {
                answer += (alpha - 'A')
            } else {
                answer += (('Z' - alpha) + 1)
            }
        }
        val rightNum = rightMoveNum(name)
        val leftNum = leftMoveNum(name)
        println("rightNum : " + rightNum + " // leftNum : " + leftNum)
        answer += if (rightNum <= leftNum) rightNum else leftNum
        return answer
    }
}
