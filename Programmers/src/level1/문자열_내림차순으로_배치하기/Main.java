package level1.문자열_내림차순으로_배치하기;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        System.out.println(Stream.of("Zbcdefg".split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));

    }
}

class Solution {
    public String solution(String s) {
        ArrayList<Character> arr = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr.add(c);
        }
        Collections.sort(arr);
        Collections.reverse(arr);


        String answer = "";
        for (char c : arr) {
            answer += c;
        }
        return answer;
    }
}

/* StringBuilder 를 이용한 풀이 */
class Solution2 {
    public String solution(String s) {

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new StringBuilder(new String(arr)).reverse().toString();
    }
}

/* Stream 를 이용한 풀이 */
class Solution3 {
    public String solution(String s) {

        return Stream.of(s.split(""))        //split("") -> 각 문자단위로 끊음 리턴 타입은 String[]
                .sorted(Comparator.reverseOrder()) //정렬 -> 역순의 과정을 거침
                .collect(Collectors.joining());    //문자열로 join
    }
}
