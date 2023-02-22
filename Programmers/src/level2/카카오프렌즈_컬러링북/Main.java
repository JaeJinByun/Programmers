package level2.카카오프렌즈_컬러링북;

import java.util.*;

/**
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/1829
 * Problem: 2017 카카오코드 예선 - 카카오프렌즈 컬러링북
 * Level: 2
 * Algorithm: dfs, bfs
 */
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    private static int numberOfArea;
    private static int maxSizeOfOneArea;
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static boolean[][] visited;
    private static int[][] map;

    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        map = picture;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(picture[i][j] == 0) visited[i][j] = true;
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,bfs(i,j,picture[i][j]));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int bfs(int m, int n, int color) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(m,n,color));
        numberOfArea++;
        int cnt = 0;

        while(true) {
            if(queue.isEmpty()) {
                return cnt;
            }
            Node node = queue.poll();

            for(int i=0; i<4; i++) {
                int newR = node.row + dx[i];
                int newC = node.col + dy[i];
                int newColor = node.color;
                if(possibility(newR,newC,newColor) && !visited[newR][newC]) {
                    visited[newR][newC] = true;
                    queue.add(new Node(newR,newC,newColor));
                    cnt++;
                }
            }
        }
    }

    public boolean possibility(int x, int y, int color) {
        if(x >= 0 && y >= 0 && x < visited.length && y < visited[0].length && color == map[x][y]){
            return true;
        }
        return false;
    }
}

class Node {
    int row; //행
    int col; //열
    int color;
    public Node (int row, int col, int color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }
}