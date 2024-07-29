package develop.ylee.algorithm.algoplayground.programmers.solution0005

class Solution0005 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val userSize = id_list.size
        val reportResultTable = Array(userSize) { i -> IntArray(userSize){j -> 0} }
        for (note in report) {
            val noteSplit = note.split(" ")
            val from = id_list.indexOf(noteSplit[0])
            val to = id_list.indexOf(noteSplit[1])
            reportResultTable[from][to] = 1
        }
        val alertCountTable = IntArray(userSize) { j -> 0 }
        for (j in 0 until userSize) {
            for (i in 0 until userSize) {
                alertCountTable[j] += reportResultTable[i][j]
            }
        }
        val reportReceiveTable = IntArray(userSize){ i -> 0}
        for (i in 0 until userSize) {
            for (j in 0 until userSize) {
                if (alertCountTable[j] >= k && reportResultTable[i][j] != 0) reportReceiveTable[i] += 1
            }
        }
        return reportReceiveTable
    }
}
