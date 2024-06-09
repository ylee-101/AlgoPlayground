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

    fun process() {
        leftTime -= 1
        if (leftTime == 0) end()
    }
    fun pause() {
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

    fun reActivate() {
        if (this.status == PlanStatus.PAUSE) {
            this.status = PlanStatus.ACTIVATE
        }
    }

    fun isActivate(): Boolean {
        return status == PlanStatus.ACTIVATE
    }
}
