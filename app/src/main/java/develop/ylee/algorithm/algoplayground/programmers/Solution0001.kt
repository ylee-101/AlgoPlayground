package develop.ylee.algorithm.algoplayground.programmers

import java.util.Stack

class Solution0001 {

    private val waitList: Stack<Plan> = Stack<Plan>()
    private var endList: Array<String> = arrayOf()

    fun solution(plans: Array<Array<String>>): Array<String> {
        val planList = planArrayToPlanList(plans)
        println(planList.toString())
        startPlan(planList)
        return endList
    }

    fun startPlan(planList: Array<Plan>) {
        var curPlan : Plan? = null
        var planIdx = 0
        val startTime = planList.getOrNull(0)?.startTime?:0
        val endTime = 23*60 + 59
        for (curTime in startTime..endTime) {
            print(curPlan?.name)
            /*
            * 1. 현재 시간이 시작해야할 시간이면 진행중인 작업 멈추고 새로 시작하기.
            * 2. 현재 시간이 시작해야할 시간이 아니면 진행중 작업 있는지 확인
            * 2-1. 진행중인 작업 없으면 대기중 작업에서 가져와서 진행
            * 2-2. 진행중인 작업 있으면 진행중 작업 계속 진행 continue
            *
            * */
            if (curPlan != null && !curPlan.isActivate()) {
                endList = endList.plus(curPlan.name)
                curPlan = null
            }

            planList.getOrNull(planIdx)?.let { plan ->
                if (plan.startTime == curTime) { // 지금 새 계획 시작해야할 때
                    if (curPlan != null) {
                        curPlan!!.pause()
                        waitList.push(curPlan)
                    }
                    curPlan = plan
                    curPlan!!.activate()
                    planIdx++
                }
            }
            if (curPlan == null && waitList.isNotEmpty()) {
                curPlan = waitList.pop()
                curPlan!!.reActivate()
            }
            curPlan?.process()
        }
        if (curPlan != null) {
            endList = endList.plus(curPlan!!.name)
        }
        while (waitList.isNotEmpty()) {
            val waitPlan = waitList.pop()
            endList = endList.plus(waitPlan.name)
        }
    }


    fun planArrayToPlanList(planArray: Array<Array<String>>): Array<Plan> {
        var tmpPlans = Array(planArray.size) { idx ->
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