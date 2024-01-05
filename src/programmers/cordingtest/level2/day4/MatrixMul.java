package programmers.cordingtest.level2.day4;

import java.util.Arrays;

public class MatrixMul {
    /*
        행렬의 곱셈

        # 문제 설명
        2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.

        # 제한 조건
        · 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
        · 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
        · 곱할 수 있는 배열만 주어집니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        //int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        //int[][] arr2 = {{3, 3}, {3, 3}};

        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        MatrixMul matrixMul = new MatrixMul();
        int[][] result = matrixMul.solution(arr1, arr2);
        System.out.println("arr1에 arr2를 곱한 결과: ");
        System.out.println(Arrays.deepToString(result));
    }

    /*
        행렬 곱셈법칙
        R[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0] + A[0][2] * B[2][0]
        R[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1] + A[0][2] * B[2][1]
        ....
     */
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0 ; i < arr1.length ; ++i){
            for(int j = 0 ; j < arr2[0].length ; ++j){
                for(int k = 0 ; k < arr1[0].length ; ++k) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];

                    // 10 += 2 * 5
                    // 16 += 3 * 2
                    // 22 += 2 * 3

                    // 8 += 2 * 4
                    // 20 += 3 * 4
                    // 22 += 2 * 1

                    // 6 += 2 * 3
                    // 9 += 3 * 1
                    // 11 += 2 * 1
                }
            }
        }

        return answer;
    }
}
