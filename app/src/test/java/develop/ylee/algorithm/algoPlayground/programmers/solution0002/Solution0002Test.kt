package develop.ylee.algorithm.algoplayground.programmers.solution0002

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class Solution0002Test {

    private val solution = Solution0002()

    @Test
    fun `1 returns correct result for multiple rounds`() {
        val n = 5
        val info = intArrayOf(2,1,1,1,0,0,0,0,0,0,0)
        val expected = intArrayOf(0,2,2,0,1,0,0,0,0,0,0)
        val result = solution.solution(n, info)
        assertArrayEquals(expected, result)
    }

    @Test
    fun `2 returns -1 for single round`() {
        val n = 1
        val info = intArrayOf(1,0,0,0,0,0,0,0,0,0,0)
        val expected = intArrayOf(-1)
        val result = solution.solution(n, info)
        assertArrayEquals(expected, result)
    }

    @Test
    fun `3 returns correct result for multiple rounds with same scores`() {
        val n = 9
        val info = intArrayOf(0,0,1,2,0,1,1,1,1,1,1)
        val expected = intArrayOf(1,1,2,0,1,2,2,0,0,0,0)
        val result = solution.solution(n, info)
        assertArrayEquals(expected, result)
    }

    @Test
    fun `4 returns correct result for multiple rounds with different scores`() {
        val n = 10
        val info = intArrayOf(0,0,0,0,0,0,0,0,3,4,3)
        val expected = intArrayOf(1,1,1,1,1,1,1,1,0,0,2)
        val result = solution.solution(n, info)
        assertArrayEquals(expected, result)
    }
}