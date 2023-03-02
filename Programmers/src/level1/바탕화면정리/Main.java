package level1.바탕화면정리;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/161990
 * Problem: 바탕화면 정리
 * Level: 1
 * Algorithm: 좌표
 */
public class Main {
    public static void main(String[] args) {

    }
}

//상 하 좌 우 의 각 최대값을 구한다. 시작점은 (왼쪽,상), 끝점은 (하,오른쪽)
class Solution {
    public int[] solution(String[] wallpaper) {

        int lux, luy, rdx, rdy;

        lux = luy = Integer.MAX_VALUE;
        rdx = rdy = Integer.MIN_VALUE;

        for(int col=0; col<wallpaper.length; col++) { //행 (세로줄)
            for(int row=0; row<wallpaper[0].length(); row++) { //열 (가로줄)
                if(wallpaper[col].charAt(row) == '#') {
                    lux = Math.min(lux, col);
                    luy = Math.min(luy, row);
                    rdx = Math.max(rdx, col);
                    rdy = Math.max(rdy, row);
                }
            }
        }

        return new int[]{lux, luy, rdx+1, rdy+1};
    }
}

