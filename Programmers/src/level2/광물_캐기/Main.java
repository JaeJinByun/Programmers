package level2.광물_캐기;


/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 * Problem: 광물 캐기
 * Level: Level2
 * Algorithm: 부르트포스
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    static int[] idx;
    static String[] mineral;
    static int answer = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        mineral = minerals;
        int len = 0;
        for (int i : picks) {
            len += i;
        }
        idx = new int[len];

        dfs(0, picks);

        return answer;
    }

    void dfs(int depth, int[] picks) {
        if (depth == idx.length) {
            answer = Math.min(answer, getCount());
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                idx[depth] = i;
                dfs(depth + 1, picks);
                picks[i]++;
            }
        }
    }

    int getCount() {
        int count = 0;
        int result = 0;
        for (int i = 0; i < idx.length; i++) {
            for (int j = 0; j < 5; j++, count++) {
                if (count > mineral.length - 1)
                    return result;

                if (mineral[count].equals("diamond")) {
                    if (idx[i] == 0) result += 1;
                    if (idx[i] == 1) result += 5;
                    if (idx[i] == 2) result += 25;
                }
                if (mineral[count].equals("iron")) {
                    if (idx[i] == 0) result += 1;
                    if (idx[i] == 1) result += 1;
                    if (idx[i] == 2) result += 5;
                }
                if (mineral[count].equals("stone")) {
                    if (idx[i] == 0) result += 1;
                    if (idx[i] == 1) result += 1;
                    if (idx[i] == 2) result += 1;
                }
            }
        }
        return result;
    }
}