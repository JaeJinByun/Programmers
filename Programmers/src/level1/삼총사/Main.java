package level1.삼총사;

public class Main {
    public static void main(String[] args){

    }
}
class Solution {
    public int solution(int[] number) {
        int cnt = 0;
        for(int i=0; i<number.length; i++) {
            for(int j=i+1; j<number.length; j++) {
                for(int k=j+1; k<number.length; k++) {
                    int isZero = number[i] + number[j] + number[k];
                    if(isZero == 0) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}