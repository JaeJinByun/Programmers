package KAKAO_2023_BLIND_RECRUITMENT.표현_가능한_이진트리;


/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/150367
 * Problem: 표현 가능한 이진트리
 * Level: 3
 * Algorithm: dfs, 이진트리
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(42));
        Solution solution = new Solution();
        solution.solution(new long[]{95L});
    }
}

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);

            //포화 이진트리의 총 개수 2^n - 1 개 (n은 높이)
            //n을 구한다
            int n = 0;
            while ((int) Math.pow(2, n) - 1 < binary.length()) {
                n++;
            }

            //포화 이진트리의 총개수와 같게 binary 문자열 앞에 '0'을 추가
            while ((int) Math.pow(2, n) - 1 != binary.length()) {
                binary = "0" + binary;
            }

            answer[i] = solve(binary);
        }

        return answer;
    }

    public int solve(String binary) {
        if (binary.length() < 3)
            return 1;

        //0101010
        int idx = (binary.length() - 1) / 2; //루트 노드의 인덱스

        String left = binary.substring(0, idx);
        String right = binary.substring(idx + 1);

        //1.루트노드가 1인지 확인 +  🔥루트노드가 0이라면 좌우 노드전부가 0이어야한다.
        if (binary.charAt(idx) == '0' && (left.charAt((left.length()-1)/2) == '1' || right.charAt((right.length()-1)/2) == '1'))
            return 0;

        if (solve(left) == 0 || solve(right) == 0)
            return 0;

        return 1;
    }
}

/**
 * 포화 이진 트리 조건
 * => 리프노드의 레벨은 무조건 더미노드 와 리프노드로 채워야함
 * => 이는 곧 노드의 개수가 홀수임을 보장함 (0으로 시작해도 가능) / 짝수라면 앞에 0을 붙인다 ?
 * 루트노드는 무조건 1
 * 101 x
 */
