class Solution {
    fun solution(plans: Array<Array<String>>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        return answer
    }
}

/*
* plans 가 [["korean", "11:40", "30"], ["english", "12:10", "20"], ["math", "12:30", "40"]] 인 경우
* result : ["korean", "english", "math"]
*
* plans 가 [["science", "12:40", "50"], ["music", "12:20", "40"], ["history", "14:00", "30"], ["computer", "12:30", "100"]] 인 경우
* result : ["science", "history", "computer", "music"]
*
* plans 가 [["aaa", "12:00", "20"], ["bbb", "12:10", "30"], ["ccc", "12:40", "10"]] 인 경우
* result : ["bbb", "ccc", "aaa"]
*
* */