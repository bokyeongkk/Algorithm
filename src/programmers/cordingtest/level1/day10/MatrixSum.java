package programmers.cordingtest.level1.day10;

import java.util.Arrays;

public class MatrixSum {
    /*
        행렬의 덧셈

        # 문제설명
        행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.
        2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

        # 제한조건
        행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
    */

    public static void main(String[] args) {
        // 입출력 예
        //int[][] arr1 = {{1,2},{2,3}};
        //int[][] arr2 = {{3,4},{5,6}};

        int[][] arr1 = {{1},{2}};
        int[][] arr2 = {{3},{4}};

        MatrixSum matrixSum = new MatrixSum();
        int[][] result = matrixSum.solution1(arr1, arr2);

        // 2차원 배열의 값을 문자열로 출력
        System.out.println("result: ");
        System.out.println(Arrays.deepToString(result));

        // [[4, 6], [7, 9]]
        // [[4], [6]]
    }

    public int[][] solution1(int[][] arr1, int[][] arr2) {
        // 두 행렬은 행과 열의 크기가 같으므로 임의로 한 배열의 크기로 배열을 선언한다.
        int[][] arr = new int[arr1.length][arr1[0].length];

        // 행렬의 행 만큼 반복한다.
        for(int i=0; i<arr1.length; i++) {
            // 행렬의 열 만큼 반복한다.
            for(int j=0; j<arr1[0].length; j++) {
                arr[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return arr;
    }
}
