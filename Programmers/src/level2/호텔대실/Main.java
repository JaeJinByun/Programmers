package level2.호텔대실;

public class Main {
    public static void main(String[] args) {
    }
}

class Solution {
    static final int totalTime = 1450;
    static final int cleanTime = 10;

    public int solution(String[][] book_time) {
        int ans = 0;
        int[] room = new int[totalTime + cleanTime];

        //시작 시간(+1)과 마감 시간(-1)을 마킹
        for(String[] s : book_time) {
            room[calcTime(s[0])]++;
            room[calcTime(s[1]) + 10]--;
        }

        //마킹된곳들을 누적합
        for(int i=1; i<room.length; i++) {
            room[i] += room[i-1];
            ans = Math.max(ans,room[i]);
        }

        return ans;
    }

    private int calcTime(String min) {
        String t[] = min.split(":");
        int hour = Integer.parseInt(t[0]) * 60;
        int minute = Integer.parseInt(t[1]);
        return hour + minute;
    }
}

//하루를 분으로 계산 => 분으로 된 하루 배열 생성
//범위를 분으로 계산
//각 범위를 +1
//배열의 최대값이 곧 최소 방 개수
