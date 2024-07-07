package develop.ylee.algorithm.algoplayground.programmers.solution0003

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class Solution0003Test {

    private val solution = Solution0003()

    @Test
    fun `return cannot go0`() {
        val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
        val expected: Boolean = true
        val result: Boolean = solution.canGo(stones, 0, 3)
        assertEquals(expected, result)
    }

    @Test
    fun `return cannot go1`() {
        val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
        val expected: Boolean = true
        val result: Boolean = solution.canGo(stones, 1, 3)
        assertEquals(expected, result)
    }

    @Test
    fun `return cannot go2`() {
        val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
        val expected: Boolean = true
        val result: Boolean = solution.canGo(stones, 2, 3)
        assertEquals(expected, result)
    }

    @Test
    fun `return cannot go3`() {
        val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
        val expected: Boolean = true
        val result: Boolean = solution.canGo(stones, 3, 3)
        assertEquals(expected, result)
    }

    @Test
    fun `return cannot go4`() {
        val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
        val expected: Boolean = false
        val result: Boolean = solution.canGo(stones, 4, 3)
        assertEquals(expected, result)
    }

    @Test
    fun `return cannot go5`() {
        val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
        val expected: Boolean = false
        val result: Boolean = solution.canGo(stones, 5, 3)
        assertEquals(expected, result)
    }

    @Test
    fun `return cannot go6`() {
        val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
        val expected: Boolean = false
        val result: Boolean = solution.canGo(stones, 6, 3)
        assertEquals(expected, result)
    }

    @Test
    fun `return cannot go7`() {
        val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
        val expected: Boolean = false
        val result: Boolean = solution.canGo(stones, 7, 3)
        assertEquals(expected, result)
    }

    @Test
    fun `return cannot go8`() {
        val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
        val expected: Boolean = false
        val result: Boolean = solution.canGo(stones, 8, 3)
        assertEquals(expected, result)
    }

//    @Test
//    fun `returns correct min`() {
//        val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
//        val expected = 1
//        val result = stones.min()
//        assertEquals(expected, result)
//    }
//
//    @Test
//    fun `returns correct minArray`() {
//        val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
//        val expected : IntArray = intArrayOf(1, 3, 4, 2, 1, 0, 3, 1, 4, 0)
//        val min = stones.min()
//        var result : IntArray = IntArray(expected.size) {idx -> stones[idx] - min}
//        assertArrayEquals(expected, result)
//    }
//
    @Test
    fun `returns correct result for multiple stones`() {
        val stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1)
        val k = 3
        val expected = 3
        val result = solution.solution(stones, k)
        assertEquals(expected, result)
    }

    @Test
    fun `returns correct result for single stone`() {
        val stones = intArrayOf(1)
        val k = 1
        val expected = 1
        val result = solution.solution(stones, k)
        assertEquals(expected, result)
    }

    @Test
    fun `returns correct result for all stones same`() {
        val stones = intArrayOf(5, 5, 5, 5, 5)
        val k = 2
        val expected = 5
        val result = solution.solution(stones, k)
        assertEquals(expected, result)
    }

    @Test
    fun `returns correct result for stones in descending order`() {
        val stones = intArrayOf(5, 4, 3, 2, 1)
        val k = 2
        val expected = 2
        val result = solution.solution(stones, k)
        assertEquals(expected, result)
    }

    @Test
    fun `returns correct result for stones in ascending order`() {
        val stones = intArrayOf(1, 2, 3, 4, 5)
        val k = 2
        val expected = 2
        val result = solution.solution(stones, k)
        assertEquals(expected, result)
    }
}