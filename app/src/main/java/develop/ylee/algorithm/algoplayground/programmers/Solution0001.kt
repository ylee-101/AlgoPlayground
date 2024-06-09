package develop.ylee.algorithm.algoplayground.programmers

import java.util.Stack

class Solution0001 {

    private val waitList: Stack<Plan> = Stack<Plan>()
    private var endList: Array<String> = arrayOf()

    fun solution(plans: Array<Array<String>>): Array<String> {
        val planList = planArrayToPlanList(plans)
        endList = Array(planList.size){ idx -> ""}
//        println(planList.toString())
        startPlan(planList)
        return endList
    }

    fun startPlan(planList: Array<Plan>) {
        var curPlan : Plan? = null
        var planIdx = 0
        var endIdx = 0
        val startTime = planList.getOrNull(0)?.startTime?:0
        val endTime = 23*60 + 59
        // 매 시각마다 확인할 필요 없음. 로직 바꿔보자.
        for (curTime in startTime..endTime) {
//            print(curPlan?.name)
            // 계획에 있는 과제 다 실행했으면 빠져나가기
            if (planList.getOrNull(planIdx) == null) break

            // 진행중인 과제가 끝난 상태라면 endList 에 돌리고 진행중 과정 null 로 처리
            if (curPlan != null && !curPlan.isActivate(curTime)) {
                endList[endIdx++] = curPlan.name
                curPlan = null
            }


            /*
            * 1. 현재 시간이 시작해야할 시간이면 진행중인 작업 멈추고 새로 시작하기.
            * 2. 현재 시간이 시작해야할 시간이 아니면 진행중 작업 있는지 확인
            * 2-1. 진행중인 작업 없으면 대기중 작업에서 가져와서 진행
            * 2-2. 진행중인 작업 있으면 진행중 작업 계속 진행 continue
            *
            * */

            // 매 시각마다 배열 확인할 필요 없는 로직 만들기
            planList.getOrNull(planIdx)?.let { plan ->
                if (plan.startTime == curTime) { // 지금 새 계획 시작해야할 때
                    if (curPlan != null) {
                        curPlan!!.pause(curTime)
                        if (curPlan!!.status == PlanStatus.PAUSE) {
                            waitList.push(curPlan)
                        } else if (curPlan!!.status == PlanStatus.END) {
                            endList[endIdx++] = curPlan!!.name
                        }
                    }
                    curPlan = plan
                    curPlan!!.activate()
                    planIdx++
                }
            }
            if (curPlan == null && waitList.isNotEmpty()) {
                curPlan = waitList.pop()
                curPlan!!.reActivate(curTime)
            }
        }
        // 리스트에 있는거 다 했으면 지금 하던거 끝내기
        if (curPlan != null) {
            endList[endIdx++] = curPlan!!.name
        }
        // 대기열에 있는 것 차례로 끝내기
        while (waitList.isNotEmpty()) {
            val waitPlan = waitList.pop()
            endList[endIdx++] = waitPlan.name
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