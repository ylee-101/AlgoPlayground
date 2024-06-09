package develop.ylee.algorithm.algoplayground.programmers

import android.util.Log
import java.lang.Exception

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
        restartTime = curTime
        endTime = restartTime + leftTime
        if (this.status == PlanStatus.PAUSE) {
            this.status = PlanStatus.ACTIVATE
        }
    }

    fun isActivate(curTime: Int): Boolean {
        if (endTime <= curTime) status = PlanStatus.END
        return status == PlanStatus.ACTIVATE
    }
}
