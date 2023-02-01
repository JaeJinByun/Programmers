package level2.이모티콘할인행사;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] a = sol.solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000});
        System.out.println(a[0] + " " + a[1]);
    }
}


class Solution {
    static int[] e;     //이모티콘
    static int[][] u;   //유저
    static int[] sales; //할인율
    static int maxUser = 0; //최대 가입자수
    static int maxPrice = 0; //판매액

    public int[] solution(int[][] users, int[] emoticons) {
        e = emoticons;
        u = users;
        sales = new int[e.length];

        dfs(0);

        int[] answer = {maxUser, maxPrice};
        return answer;
    }

    public void dfs(int depth) {
        if (depth == e.length) {
            //각 할인율에 대한 결과
            calc();
            return;
        }

        for (int i = 10; i <= 40; i += 10) {
            sales[depth] = i;
            dfs(depth + 1);
        }
    }

    public void calc() {
        //이모티콘 플러스 가입자
        int join = 0;
        //이모티콘 판매 금액
        int totalPrice = 0;

        //각 유저별로 계산
        for (int[] i : u) {
            int discount = i[0]; //유저의 할인율
            int limit = i[1];    //유저의 이모티콘 구매 마지노선 가격
            int sum = 0;         //유저의 이모티콘 총 구매액 --> 구독할지 말지 결정해야함

            for (int j = 0; j < e.length; j++) { //이모티콘 순회
                if (discount > sales[j]) continue; //할인율이 작다면

                //구매 하는 경우
                sum += e[j] * (100 - sales[j]) / 100;
            }
            if (sum >= limit) join++;
            else totalPrice += sum;
        }

        //-- 가입자수 비교 --
        if (join > maxUser) {
            maxUser = join;
            maxPrice = totalPrice;
        } else if (join == maxUser && totalPrice > maxPrice) {
            maxPrice = totalPrice;
        }
    }
}

