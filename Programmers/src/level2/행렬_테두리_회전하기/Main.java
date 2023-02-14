package level2.행렬_테두리_회전하기;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    private static int[][] map;
    private static int idx = 0;
    private static int[] answer;

    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];

        map = new int[rows][columns];
        int c = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = c;
                c++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            rotation(queries[i]);
        }

        return answer;
    }

    public void rotation(int[] square) {
        int x1 = square[0] - 1;
        int y1 = square[1] - 1;
        int x2 = square[2] - 1;
        int y2 = square[3] - 1;

        int firstNum = map[x1][y2];
        int min = firstNum;

        //첫번째 회전 스텝 (상단)
        for (int i = y2 - 1; i >= y1; i--) {
            min = Math.min(min, map[x1][i]);
            map[x1][i + 1] = map[x1][i];
        }
        //네번째 회전 스텝 (왼쪽)
        for (int i = x1 + 1; i <= x2; i++) {
            min = Math.min(min, map[i][y1]);
            map[i - 1][y1] = map[i][y1];
        }
        //세번째 회전 스텝 (하단)
        for (int i = y1 + 1; i <= y2; i++) {
            min = Math.min(min, map[x2][i]);
            map[x2][i - 1] = map[x2][i];
        }
        //두번째 회전 스텝 (오른쪽)
        for (int i = x2 - 1; i >= x1; i--) {
            min = Math.min(min, map[i][y2]);
            map[i + 1][y2] = map[i][y2];
        }
        map[x1 + 1][y2] = firstNum;

        answer[idx] = min;
        idx++;
    }
}

/**
 *  회전할때 주의할점
 *  하나의 격자는 겹치기 때문에 임시변수에 저장해놔야한다. 회전이 끝난후 마지막 자리에 집어넣어주어야한다.
 *  회전의 순서또한 주의해야 한다. 상단 -> 좌측 -> 하단 -> 우측 순으로 회전 반대방향으로 채워주어야하 한다.
 * */
