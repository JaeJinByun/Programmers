package level1.키패드_누르기;

public class Main {
    public static void main(String[] args) {
    }
}

class Solution {
    private static int l_idx = 10;  //왼손 현재 위치   * -> 10
    private static int r_idx = 12;  //오른손 현재 위치  # -> 12
    private static String h = "";

    public String solution(int[] numbers, String hand) {
        String answer = "";
        if (hand.equals("right")) h = "R";
        else h = "L";

        for (int n : numbers) {
            if (n == 0) {
                answer += push(11);
                continue;
            }
            answer += push(n);
        }

        return answer;
    }

    /* 💡 거리 구하기 식 도출이 포인트 */
    public int getDistance(int idx, int target) {
        return Math.abs((idx - target) / 3 + (idx - target) % 3);
    }

    public String push(int n) {
        if (n % 3 == 1) {
            l_idx = n;
            return "L";
        }
        if (n % 3 == 0) {
            r_idx = n;
            return "R";
        }

        int l = getDistance(l_idx, n);
        int r = getDistance(r_idx, n);

        if (l == r) {
            if (h.equals("R")) {
                r_idx = n;
                return "R";
            } else {
                l_idx = n;
                return "L";
            }
        }

        if (l > r) {
            r_idx = n;
            return "R";
        }

        l_idx = n;
        return "L";
    }
}
