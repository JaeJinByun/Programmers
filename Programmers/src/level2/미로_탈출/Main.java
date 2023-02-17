package level2.미로_탈출;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        //String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        sol.solution(maps);

    }
}

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static char[][] maze;
    static int answer = 0;
    static Node lever;
    static Node start;
    static Node end;

    public int solution(String[] maps) {
        maze = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                maze[i][j] = c;
                if(c == 'L') lever = new Node(i,j,0);
                if(c == 'E') end = new Node(i,j,0);
                if(c == 'S') start = new Node(i,j,0);
            }
        }
        bfs(start.x,start.y, lever);
        if(!visited[lever.x][lever.y]) return -1;

        visited = new boolean[maps.length][maps[0].length()];

        bfs(lever.x, lever.y, end);
        if(!visited[end.x][end.y]) return -1;
        return answer;
    }

    public void bfs(int x,int y, Node endNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y,0));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(n.x == endNode.x && n.y == endNode.y) {
                answer += n.cost;
                return;
            }

            for(int i=0; i<4; i++) {
                int new_x = n.x + dx[i];
                int new_y = n.y + dy[i];
                if(possibility(new_x,new_y) &&  maze[new_x][new_y] != 'X' &&!visited[new_x][new_y]) {
                    visited[new_x][new_y] = true;
                    queue.add(new Node(new_x,new_y,n.cost + 1));
                }
            }
        }
    }

    public boolean possibility(int x, int y) {
        if(x >= 0 && y >= 0 && x < maze.length && y < maze[0].length) {
            return true;
        }
        return false;
    }
}

class Node {
    int x;
    int y;
    int cost;
    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

// S -> L 최소거리 (도착후 초기화)
// L -> E 최소거리