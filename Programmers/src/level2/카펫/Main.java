package level2.카펫;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int brown, int yellow) {
        //격자의 총개수 = 넓이 = brown + yellow

        int total = brown + yellow;

        int[] answer = new int[2];
        //약수 구하기
        for(int i=1; i<total/2+1; i++) {
            if(total % i == 0 && total/i >= 3) {
                int w = Math.max(i,total/i);
                int h = Math.min(i,total/i);

                //(가로-2)*(세로-2) = yellow
                if( ((w-2) * (h-2) ) == yellow ) {
                    answer[0] = w;
                    answer[1] = h;
                }

            }
        }

        //12 (1,12) (2,6) (3,4)
        return answer;
    }
}

