package level1.행렬의_덧셈;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int col = arr1.length;    //열
        int row = arr1[0].length; //행

        int[][] answer = new int[col][row];


        for(int i=0; i<col; i++) {
            for(int j=0; j<row; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}

