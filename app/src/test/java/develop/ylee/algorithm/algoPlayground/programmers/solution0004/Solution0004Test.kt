package develop.ylee.algorithm.algoplayground.programmers.solution0004

import org.junit.Assert.assertEquals
import org.junit.Test

class Solution0004Test {

    private val solution = Solution0004()

    @Test
    fun `returns correct movement for JEROEN`() {
        val result = solution.solution("JEROEN")
        assertEquals(56, result)
    }

    @Test
    fun `returns correct movement for JAN`() {
        val result = solution.solution("JAN")
        assertEquals(23, result)
    }

    @Test
    fun `returns correct movement for single character A`() {
        val result = solution.solution("A")
        assertEquals(0, result)
    }

    @Test
    fun `returns correct movement for single character Z`() {
        val result = solution.solution("Z")
        assertEquals(1, result)
    }

    @Test
    fun `returns correct movement for empty string`() {
        val result = solution.solution("")
        assertEquals(0, result)
    }

    @Test
    fun `returns correct movement for BAAAAABAA`() {
        val result = solution.solution("BAAAAABAA")
        assertEquals(5, result)
    }

    @Test
    fun `returns correct movement for BBBABAABABABB`() {
        val result = solution.solution("BBBABAABABABB")
        assertEquals(20, result)
    }

    @Test
    fun `returns correct movement for BBABAAAAAAB`() {
        val result = solution.solution("BBABAAAAAAB")
        assertEquals(9, result)
    }

    @Test
    fun `returns correct movement for BABBAABB`() {
        val result = solution.solution("BABBAABB")
        assertEquals(11, result)
    }

    @Test
    fun `returns correct movement for BBAAAAAAABAB`() {
        val result = solution.solution("BBAAAAAAABAB")
        assertEquals(9, result)
    }

    @Test
    fun `returns correct movement for BAABBAAA`() {
        val result = solution.solution("BAABBAAA")
        assertEquals(7, result)
    }
}