package level2.두개_이하로_다른비트;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/77885
 * Problem: 두개 이하로 다른 비트
 * Level: 2
 * Algorithm: 수학, 구현
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            long num = numbers[i];
            if(num%2 == 0) answer[i] = num+1;
            else {
                String s = Long.toBinaryString(num);
                int zeroIndex = s.lastIndexOf("0");
                //1로만 채워진 2진수 , 0이 섞여있는 2진수
                if(zeroIndex == -1) {
                    s = "10" + s.substring(1,s.length());
                }else{
                    s = s.substring(0,zeroIndex) + "10" + s.substring(zeroIndex+2,s.length()); //101011 -> 101101
                }
                answer[i] = Long.parseLong(s,2);
            }
        }

        return answer;
    }
}


/**
 * 수학적 접근
 *
 * 1. 주어진 수가 짝수인 경우 +1만 해준 값이 정답
 * 2. 홀수의 경우 모든 수가 1인 경우와 중간에 0이 포함되어 있는 경우로 나뉜다.
 *
 * * 모든 수가 1인 경우
 * 두번째 자리에 0을 넣어주면 됩니다.
 * ex) 111 -> 1011
 *
 * *중간에 0이 포함
 * 마지막 0을 1로 바꾸고 바꾼 수 바로 뒤에 1을 0으로 바꿔주면 됩니다.
 * ex) 100111 -> 101011
 */