package level1.옹알이2;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/133499
 * Problem: 옹알이2
 * Level: 1
 * Algorithm: 문자열
 */
public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    static String[] arr = {"aya", "ye", "woo", "ma"};
    static String[] arr2 = {"ayaaya","yeye","woowoo","mama"};

    public int solution(String[] babbling) {
        int answer = 0;

        for(String str : babbling) {
            boolean b = false;
            for(String str2  : arr2) {
                if(str.contains(str2)) {
                    b = true;
                    break;
                }
            }
            if(b) continue;

            for(String str3 : arr) {
                str = str.replace(str3," ");
            }

            str = str.replace(" ","");
            if(str.length() == 0) answer++;

        }

        return answer;
    }
}
