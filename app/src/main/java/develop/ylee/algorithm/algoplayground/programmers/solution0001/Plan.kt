package develop.ylee.algorithm.algoplayground.programmers.solution0001

enum class PlanStatus{
    WAIT, ACTIVATE, PAUSE, END
}
data class Plan(
    val name : String,
    val startTime : Int,
    val duration : Int,
    var endTime : Int = startTime + duration,
    var restartTime : Int = startTime,
    var leftTime : Int = duration,
    var status : PlanStatus = PlanStatus.WAIT
) {

    fun pause(curTime: Int) {
        val dueTime = curTime - restartTime
        leftTime -= dueTime
        if (leftTime > 0) {
            this.status = PlanStatus.PAUSE
        } else {
            end()
        }
    }

    fun end() {
        this.status = PlanStatus.END
    }

    fun activate() {
        if (status == PlanStatus.WAIT) {
            status = PlanStatus.ACTIVATE
        }
    }

    fun reActivate(curTime: Int) {
        if (this.status == PlanStatus.PAUSE) {
            restartTime = curTime
            endTime = restartTime + leftTime
            this.status = PlanStatus.ACTIVATE
        }
    }
}
