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
    var restartTime : Int = startTime,
    var leftTime : Int = duration,
    var status : PlanStatus = PlanStatus.WAIT
) {
    fun pause(curTime: Int) {
        val dueTime = curTime - restartTime
        if (leftTime > dueTime) {
            leftTime -= dueTime
            this.status = PlanStatus.PAUSE
        } else {
            end()
        }
    }

    fun end() {
        this.status = PlanStatus.END
    }

    fun activate(curTime : Int) {
        try {
            if (status == PlanStatus.WAIT) {
                restartTime = curTime
                status = PlanStatus.ACTIVATE
            } else {
                throw Exception("status is not WAIT. cur status is " + status)
            }
        } catch (e: Exception) {
            Log.e("Plan_activate", e.toString())
        }
    }

    fun reActivate(curTime : Int) {
        try {
            if (this.status == PlanStatus.PAUSE) {
                restartTime = curTime
                this.status = PlanStatus.ACTIVATE
            } else {
                throw Exception("status is not PAUSE. cur status is " + status)
            }
        } catch (e: Exception) {
            Log.e("Plan_reActivate", e.toString())
        }
    }
}
