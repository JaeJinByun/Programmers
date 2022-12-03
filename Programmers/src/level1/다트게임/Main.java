package level1.다트게임;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("1S2D3T"));
    }
}
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String pivot = "";
        int idx  = 0;
        int[] arr = new int[3];

        for(int i=0; i<dartResult.length(); i++) {
            char target = dartResult.charAt(i);
            switch(target) {
                case 'S':
                    arr[idx] = Integer.parseInt(pivot);
                    idx++;
                    pivot = "";
                    break;
                case 'D':
                    arr[idx] = (int)Math.pow(Integer.parseInt(pivot),2);
                    idx++;
                    pivot = "";
                    break;
                case 'T':
                    arr[idx] = (int)Math.pow(Integer.parseInt(pivot),3);
                    idx++;
                    pivot = "";
                    break;
                case '*':
                    arr[idx-1] *= 2;
                    if(idx>1 && arr[idx-2] != 0) {
                        arr[idx-2] *= 2;
                    }
                    break;
                case '#':
                    arr[idx-1] *= -1;
                    break;
                default:
                    pivot += Character.toString(target);
                    break;
            }
        }
        for(int i : arr) {
            answer += i;
        }

        return answer;
    }
}
