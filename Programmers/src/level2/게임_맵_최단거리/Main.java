package level2.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] a = {{1,0,1,1,1}, {1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(sol.solution(a));
    }
}
class Node{
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    int dx[] = {-1,0,1,0};
    int dy[] = {0,-1,0,1};
    static int visited[][];
    static Queue<Node> queue = new LinkedList<>();
    static int[][] maze;
    public int solution(int[][] maps) {
        int answer = 0;

        visited = new int[maps.length][maps[0].length];
        this.maze = maps;

        bfs(0,0);
        if(visited[maze.length -1][maze[0].length -1] == 0) {
            answer = -1;
        }else {
            answer = visited[maze.length -1][maze[0].length -1];
        }
        for(int i=0; i< visited.length; i++){
            for(int j : visited[i]) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
        return answer;
    }

    public void bfs(int x, int y) {
        // 1. 첫 시작 노드 체크
        visited[x][y] = 1;
        // 2. 큐에 첫 시작 노드 삽입
        queue.add(new Node(x,y));

        // 3. 탐색
        while(!queue.isEmpty()) {
            // 4. 큐에서 한개 빼기
            Node node = queue.remove();
            int newX = node.x;
            int newY = node.y;

            // 5. 상하좌우 탐색
            for(int i=0; i<4; i++){
                // 6. 다음 탐색할 위치
                int _x = newX + dx[i];
                int _y = newY + dy[i];

                // 7. 맵 밖으로 벗어나는지 체크
                if(_x < 0 || _x > maze.length - 1 || _y < 0 || _y > maze[0].length -1) continue;

                // 8. 탐색하지 않은곳이면서 + 벽이 아닌지 체크
                if(visited[_x][_y] == 0 && maze[_x][_y] == 1) {
                    // 9. 현재 노드의 위치 값을 바로 전 노드의 값 + 1
                    visited[_x][_y] = visited[newX][newY] + 1;
                    // 10. 현재 노드를 큐에 삽입
                    queue.add(new Node(_x,_y));
                }
            }
        }
    }
}

// bfs 넓이 우선 탐색 -> 큐를 이용한 최단거리 계산
// 우선 [n][m] 의 주위의 벽이 0 으로 마킹되어 있는지 체크

