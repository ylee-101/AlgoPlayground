package develop.ylee.algorithm.algoplayground.programmers

class Solution0001 {
    fun solution(plans: Array<Array<String>>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        return answer
    }

    fun toPlan(plan : Array<String>) : Plan {
        val startTimeStrArray = plan[1].split(":")
        return Plan(
            name = plan[0],
            startTime = startTimeStrArray[0].toInt() * 60 + startTimeStrArray[1].toInt(),
            duration = plan[2].toInt()
        )
    }
}