package develop.ylee.algorithm.algoplayground.programmers.solution0001

import java.util.Stack

class Solution0001 {
    fun solution(plans: Array<Array<String>>): Array<String> {
        val planList = planArrayToPlanList(plans)
        return startPlan(planList)
    }

    fun startPlan(planList: Array<Plan>): Array<String> {

        if (planList.size < 3) {
            return emptyArray()
        }

        val waitList: Stack<Plan> = Stack<Plan>()
        val endList: Array<String> = Array(planList.size){i -> ""}

        var curPlan : Plan = planList.get(0)
        var endIdx = 0

        planList.forEach { plan ->
            curPlan.activate()
            if (curPlan.name == plan.name) return@forEach
            while (curPlan.status == PlanStatus.ACTIVATE && curPlan.endTime <= plan.startTime) { // 지금 하고있는 과제가 다음 과제보다 일찍 끝나면 끝내고 다음 과제 보기
                curPlan.end()
                endList[endIdx++] = curPlan.name
                if (waitList.isNotEmpty()) {
                    val nextPlan = waitList.pop()
                    nextPlan.reActivate(curPlan.endTime)
                    curPlan = nextPlan
                }
            }
            if (curPlan.status != PlanStatus.END) {
                curPlan.pause(plan.startTime) // 지금 하고있는 과제 다음 과제 시작시간에 멈추기
                waitList.push(curPlan) // 대기열에 넣기
            }
            curPlan = plan // 새로운 과제를 시작하기
        }

        if (curPlan.status != PlanStatus.END) {
            endList[endIdx++] = curPlan.name
        }
        // 대기열에 있는 것 차례로 끝내기
        while (waitList.isNotEmpty()) {
            val waitPlan = waitList.pop()
            endList[endIdx++] = waitPlan.name
        }
        return endList
    }


    fun planArrayToPlanList(planArray: Array<Array<String>>): Array<Plan> {
        val tmpPlans = Array(planArray.size) { idx ->
            convertToPlan(planArray[idx])
        }
        tmpPlans.sortBy { it.startTime }
        return tmpPlans
    }

    fun convertToPlan(plan : Array<String>) : Plan {
        val startTimeStrArray = plan[1].split(":")
        return Plan(
            name = plan[0],
            startTime = startTimeStrArray[0].toInt() * 60 + startTimeStrArray[1].toInt(),
            duration = plan[2].toInt()
        )
    }
}