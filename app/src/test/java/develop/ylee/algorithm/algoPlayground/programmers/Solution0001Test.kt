package develop.ylee.algorithm.algoplayground.programmers

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class Solution0001Test {
    private val solution = Solution0001()

    @Test
    fun `returns correct order for plans with different times`() {
        val plans = arrayOf(arrayOf("korean", "11:40", "30"), arrayOf("english", "12:10", "20"), arrayOf("math", "12:30", "40"))
        val expected = arrayOf("korean", "english", "math")
        assertArrayEquals(expected, solution.solution(plans))
    }

    @Test
    fun `returns correct order for plans with same times but different durations`() {
        val plans =
            arrayOf(
                arrayOf("science", "12:40", "50"),
                arrayOf("music", "12:20", "40"),
                arrayOf("history", "14:00", "30"),
                arrayOf("computer", "12:30", "100"),
            )
        val expected = arrayOf("science", "history", "computer", "music")
        assertArrayEquals(expected, solution.solution(plans))
    }

    @Test
    fun `returns correct order for plans with same times and same durations`() {
        val plans = arrayOf(arrayOf("aaa", "12:00", "20"), arrayOf("bbb", "12:10", "30"), arrayOf("ccc", "12:40", "10"))
        val expected = arrayOf("bbb", "ccc", "aaa")
        assertArrayEquals(expected, solution.solution(plans))
    }

    @Test
    fun `returns empty array for empty plans`() {
        val plans = arrayOf<Array<String>>()
        val expected = arrayOf<String>()
        assertArrayEquals(expected, solution.solution(plans))
    }
}
