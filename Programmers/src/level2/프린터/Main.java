package level2.프린터;
import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    static Queue<Node> q = new LinkedList<>();
    static LinkedList<Integer> arr = new LinkedList<>();
    public int solution(int[] priorities, int location) {
        for(int i=0; i<priorities.length; i++) {
            arr.add(priorities[i]);

            if(i == location) {
                q.add(new Node(priorities[i],true));
            }else{
                q.add(new Node(priorities[i],false));
            }
        }

        Collections.sort(arr);
        Collections.reverse(arr);

        int cnt = 0 ;
        while(!q.isEmpty()) {
            Node node = q.poll();

            if(arr.peek() == node.x) {
                arr.remove();
                cnt++;
                if(node.y) {
                    break;
                }

            }else {
                q.add(node);
            }

        }

        return cnt;
    }
}

class Node {
    int x;
    boolean y;
    public Node(int x, boolean y){
        this.x = x;
        this.y = y;
    }
}