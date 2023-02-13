package level1.성격_유형_검사하기;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    //지표
    /* R T
       C F
       J M
       A N  */
    private static int[][] map = new int[4][2];
    private static String[][] s_arr = {{"R","T"},{"C","F"},{"J","M"},{"A","N"}};

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        for(int i=0; i<survey.length; i++) {
            int c = choices[i];
            if(c == 4) {
                continue;
            }

            String[] str = survey[i].split("");
            String s1 = str[0];
            String s2 = str[1];

            if(c < 4) plus(s1,4-c);
            else plus(s2,c-4);
        }

        for(int i=0; i<4; i++) {
            if(map[i][0] == map[i][1]) {
                answer += s_arr[i][0];
                continue;
            }
            if(map[i][0] > map[i][1]) answer += s_arr[i][0];
            else answer += s_arr[i][1];
        }

        return answer;
    }
    public void plus(String s, int c) {
        if(s.equals("R")) {
            map[0][0] += c;
        }else if(s.equals("T")) {
            map[0][1] += c;
        }else if(s.equals("C")) {
            map[1][0] += c;
        }else if(s.equals("F")) {
            map[1][1] += c;
        }else if(s.equals("J")) {
            map[2][0] += c;
        }else if(s.equals("M")) {
            map[2][1] += c;
        }else if(s.equals("A")) {
            map[3][0] += c;
        }else if(s.equals("N")) {
            map[3][1] += c;
        }
    }
}