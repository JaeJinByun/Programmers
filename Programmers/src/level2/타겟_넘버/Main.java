package level2.타겟_넘버;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    static int answer = 0;

    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);

        return answer;
    }

    public void dfs(int[] numbers, int target, int depth, int sum) {

        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
            }
        }else {
            /* 각 노드에 대하여 2가지수로 분기 +, - */
            dfs(numbers, target, depth+1, sum + numbers[depth]);
            dfs(numbers, target, depth+1, sum - numbers[depth]);
        }
    }
}