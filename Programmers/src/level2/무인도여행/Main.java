package level2.무인도여행;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] a=  {"X591X","X1X5X","X231X", "1XXX1"};
        Solution sol = new Solution();
        sol.solution(a);
    }
}
class Node {
    int x;
    int y;
    int point;
    public Node(int x,int y, int point) {
        this.x = x;
        this.y = y;
        this.point = point;
    }
}

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static ArrayList<Integer> arr = new ArrayList<>();

    public int[] solution(String[] maps) {
        int[] answer = {};
        map = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                char a = maps[i].charAt(j);
                if(a == 'X') {
                    map[i][j] = 0;
                    continue;
                }
                map[i][j] = Character.getNumericValue(a);
            }
        }

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    bfs(i,j);
                }
            }
        }
        if(arr.isEmpty()) {
            arr.add(-1);
        }else {
            Collections.sort(arr);
        }
        answer = arr.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public void bfs(int x, int y) {
        visited[x][y] = true;
        int sum = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,map[x][y]));

        while(!q.isEmpty()) {
            Node n = q.poll();
            sum += n.point;

            for(int i=0; i<4; i++) {
                int newX = n.x + dx[i];
                int newY = n.y + dy[i];
                if(Possibilty(newX,newY) &&  !visited[newX][newY] ) {
                    visited[newX][newY] = true;
                    q.add(new Node(newX,newY,map[newX][newY]));
                }
            }
        }
        arr.add(sum);
    }

    public boolean Possibilty(int x, int y) {
        if( (x >= 0 && y >= 0 && x < map.length && y < map[0].length) &&  (map[x][y] != 0 ) ) {
            return true;
        }
        return false;
    }
}
