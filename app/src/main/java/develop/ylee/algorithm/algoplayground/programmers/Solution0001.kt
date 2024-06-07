package develop.ylee.algorithm.algoplayground.programmers

enum class PlanStatus{
    WAIT, ACTIVATE, PAUSE, END
}
data class Plan(
    val name : String,
    val startTime : Int,
    val duration : Int,
    var leftTime : Int = duration,
    var status : PlanStatus = PlanStatus.WAIT
)

class Solution0001 {
    fun solution(plans: Array<Array<String>>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        return answer
    }

    fun toPlan(plan : Array<String>) : Plan {
        return Plan(
            name = plan[0],
            startTime = 0,
            duration = 0
        )
    }
}