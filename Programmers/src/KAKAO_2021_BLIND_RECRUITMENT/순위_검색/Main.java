package KAKAO_2021_BLIND_RECRUITMENT.순위_검색;

import java.util.*;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/72412
 * Problem: 순위 검색
 * Level: 2
 * Algorithm: 조합, 이분탐색
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String s : info) {
            combination(s.split(" "), 0, "");
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");

            answer[i] = map.containsKey(q[0]) ? binarySearch(map.get(q[0]), Integer.parseInt(q[1])) : 0;
        }

        return answer;
    }

    //이분탐색
    int binarySearch(List<Integer> list, int score) {
        int start = 0;
        int end = list.size() - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;

            if (list.get(mid) >= score) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return list.size() - start;
    }

    //조합 (순서는 유지한채 "-" 가 섞인 모든 경우의수를 추출)
    void combination(String[] str, int depth, String result) {

        if (depth == 4) {
            if (!map.containsKey(result)) {
                List<Integer> list = new ArrayList<>();
                map.put(result, list);
            }
            int score = Integer.parseInt(str[4]);
            map.get(result).add(score);
            return;
        }

        combination(str, depth + 1, result + "-");
        combination(str, depth + 1, result + str[depth]);

    }
}
