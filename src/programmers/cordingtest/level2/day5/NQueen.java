package programmers.cordingtest.level2.day5;

import java.util.*;

public class NQueen {
    /*
        N-Queen

        # 문제 설명
        가로, 세로 길이가 n인 정사각형으로된 체스판이 있습니다.
        체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하고 싶습니다.

        예를 들어서 n이 4인경우 다음과 같이 퀸을 배치하면 n개의 퀸은 서로를 한번에 공격 할 수 없습니다.

        체스판의 가로 세로의 세로의 길이 n이 매개변수로 주어질 때,
        n개의 퀸이 조건에 만족 하도록 배치할 수 있는 방법의 수를 return하는 solution함수를 완성해주세요.

        # 제한사항
        · 퀸(Queen)은 가로, 세로, 대각선으로 이동할 수 있습니다.
        · n은 12이하의 자연수 입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int n = 4;

        NQueen nQueen = new NQueen();
        int result = nQueen.solution(n);
        System.out.println("조건에 만족 하도록 배치할 수 있는 방법의 수: "+result);
    }

    /*
        Queen의 특징
        하나의 퀸이 놓여진 가로, 세로, 대각선에는 다른 퀸이 놓여질 수 없다.

        -> 특징을 이용하여 2차원배열을 1차원배열로 압축시킬 수 있다.
        [1, 3, 0, 2]
        [2, 0, 3, 1]
     */

    int[] board;
    int count = 0;

    public int solution(int n) {
        board = new int[n];
        backTracking(n,0);

        return count;
    }

    public void backTracking(int n,int row){
        if(row==n){
            count++;
            return;
        }

        for(int i = 0; i < n; i++){
            board[row]=i;
            if(check(row)){
                backTracking(n,row+1);
            }
        }

    }

    public boolean check(int row){
        for(int i=0;i<row;i++){
            // 가로가 같을때
            if(board[i] == board[row]){
                return false;
            }
            // 대각선이 같을때
            if(Math.abs(row-i) == Math.abs(board[row]-board[i])){
                return false;
            }
        }

        return true;
    }
}
