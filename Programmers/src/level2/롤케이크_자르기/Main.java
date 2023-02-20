package level2.롤케이크_자르기;

import java.util.*;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 * Problem: 롤케이크 자르기
 * Level: 2
 * Algorithm: HashMap
 */

public class Main {
    public static void main(String[] args) {

    }
}

/**
 * HashMap 이용
 */
class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i : topping) map1.put(i, map1.getOrDefault(i, 0) + 1);

        for (int i : topping) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);

            if (map1.get(i) == 1) map1.remove(i);
            else map1.put(i, map1.getOrDefault(i, 0) - 1);

            if (map1.size() == map2.size()) answer++;
        }

        return answer;
    }
}

/**
 * Array 이용
 */
class Solution2 {
    public int solution(int[] topping) {
        int answer = 0;

        int[] first = new int[10001];
        int[] second = new int[10001];

        int first_topping = 0;
        int sec_topping = 0;

        for (int i : topping) {
            if (first[i] == 0) first_topping++;
            first[i]++;
        }

        for (int i : topping) {
            first[i]--;
            if (first[i] == 0) first_topping--;
            if (second[i] == 0) sec_topping++;
            second[i]++;

            if (first_topping == sec_topping) answer++;
        }

        return answer;
    }
}