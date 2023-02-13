package level2.마법의_엘리베이터;


public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(678));
    }
}

class Solution {
    public int solution(int storey) {
        int answer = 0;
        int size = String.valueOf(storey).length();
        char[] temp = String.valueOf(storey).toCharArray();
        int[] arr = new int[size];

        for(int i=0; i<temp.length; i++) {
            arr[i] = temp[i] - '0';
        }

        for(int i=arr.length-1; i>=0; i--) {
            if(i == 0) {
                if(arr[i] == 10) answer++;
                else if(arr[i] > 5 && arr[i] < 10) answer += (10 - arr[i]) + 1;
                else answer += arr[i];
                continue;
            }

            if(arr[i] == 10) {
                arr[i-1]++;
                continue;
            }

            if(arr[i] > 5) {
                answer += ( 10 - arr[i] );
                arr[i-1]++;
            }else if(arr[i] == 5){ //2555
                if(arr[i-1] >= 5) {
                    arr[i-1]++;
                }
                answer += arr[i];
            }else {
                answer += arr[i];
            }

        }


        return answer;
    }
}

/*
*  생각해보면 좋은 반례
*  678 -> 8
*  199 -> 2
* */