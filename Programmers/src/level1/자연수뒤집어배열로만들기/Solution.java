package level1.자연수뒤집어배열로만들기;

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(1234234);

    }
}

class Solution {
    public int[] solution(long n) {
        String n2 = String.valueOf(n);
        int[] answer = new int[n2.length()];

        int cnt = 0;
        for(int i=n2.length()-1; i>=0; i--){
            answer[cnt] = (int)(n2.charAt(i) - '0');
            cnt++;
        }
        return answer;
    }
}
