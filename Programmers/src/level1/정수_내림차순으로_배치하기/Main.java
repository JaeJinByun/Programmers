package level1.정수_내림차순으로_배치하기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.solution(118372));
    }
}



class Solution {
    public long solution(long n) {
        long answer = 0;

        String s = String.valueOf(n);

        Integer[] arr = new Integer[s.length()];

        for(int i=0; i<arr.length; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        Arrays.sort(arr,Collections.reverseOrder());
        s = "";

        for(int i : arr) {
            s += String.valueOf(i);
        }

        answer = Long.parseLong(s);
        return answer;
    }
}

// StringBuilder 이용
class Solution2 {
    public Long solution(long n) {
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for(String s : list) sb.append(s);

        return Long.parseLong(sb.reverse().toString());
    }
}