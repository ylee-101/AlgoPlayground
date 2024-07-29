package develop.ylee.algorithm.algoplayground.programmers.solution0005

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class Solution0005Test {

    private val solution = Solution0005()

    @Test
    fun `returns correct report count for multiple reports`() {
        val idList = arrayOf("muzi", "frodo", "apeach", "neo")
        val report = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi")
        val result = solution.solution(idList, report, 2)
        assertArrayEquals(intArrayOf(2,1,1,0), result)
    }

    @Test
    fun `returns zero report count for insufficient reports`() {
        val idList = arrayOf("con", "ryan")
        val report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con")
        val result = solution.solution(idList, report, 3)
        assertArrayEquals(intArrayOf(0,0), result)
    }

    @Test
    fun `returns correct report count for single report`() {
        val idList = arrayOf("muzi", "frodo")
        val report = arrayOf("muzi frodo")
        val result = solution.solution(idList, report, 1)
        assertArrayEquals(intArrayOf(1,0), result)
    }

    @Test
    fun `returns zero report count for no reports`() {
        val idList = arrayOf("muzi", "frodo")
        val report = arrayOf<String>()
        val result = solution.solution(idList, report, 1)
        assertArrayEquals(intArrayOf(0,0), result)
    }
}