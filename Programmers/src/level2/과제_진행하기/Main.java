package level2.과제_진행하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/176962
 * Problem: 과제 진행하기
 * Level: 2
 * Algorithm: 자료구조, 구현
 */
public class Main {
    public static void main(String[] args) {
        Solution sol1 = new Solution();
        String[] plans = sol1.solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
        for (String s : plans) {
            System.out.println(s);
        }
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        ArrayList<String> list = new ArrayList<>();

        //시간을 분으로 치환, 끝나는 시간을 추가
        for (int i = 0; i < plans.length; i++) {
            String[] time = plans[i][1].split(":");
            int min = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            int end = min + Integer.parseInt(plans[i][2]);

            plans[i][1] = String.valueOf(min);
            plans[i][2] = String.valueOf(end);
        }


        //시작시간을 기준으로 오름차순 정렬
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }
        });


        //끝내지 못한 과제를 저장한 스택 자료구조 생성
        Stack<String[]> stack = new Stack<>();

        for (int i = 0; i < plans.length - 1; i++) {
            int currentTime = Integer.parseInt(plans[i][2]);
            int nextTime = Integer.parseInt(plans[i + 1][1]);


            //과제가 밀리지 않음 or 여유 시간존재
            if (currentTime <= nextTime) {
                list.add(plans[i][0]);


                //잔여시간
                int remainTime = nextTime - currentTime;

                while (remainTime > 0 && !stack.isEmpty()) {
                    int remain = Integer.parseInt(stack.peek()[1]) - remainTime;

                    //잔여시간 갱신
                    stack.peek()[1] = String.valueOf(Integer.parseInt(stack.peek()[1]) - remainTime);

                    if (remain <= 0) {
                        remainTime = Math.abs(remain);
                        list.add(stack.pop()[0]);
                    } else {
                        break;
                    }
                }
            } else {
                stack.push(new String[]{plans[i][0], String.valueOf(currentTime - nextTime)});
            }
        }

        list.add(plans[plans.length-1][0]);

        while (!stack.isEmpty()) {
            list.add(stack.pop()[0]);
        }


        return list.toArray(new String[0]);
    }
}


/**
 * 생각해보기
 *
 * 🔥시간을 분으로 치환하는게 키포인트
 *
 * 💡현재시간을 개념적으로 정의하는 것이 중요하다. 비교대상을 무엇으로 할지 기준을 정해야 하기 때문
 *
 */