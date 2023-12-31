package programmers.cordingtest.level1.day2;

import java.util.*;

public class ArrayOfNum {
    /*
        나누어 떨어지는 숫자 배열

        # 문제설명
        array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
        divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

        # 제한사항
        - arr은 자연수를 담은 배열입니다.
        - 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
        - divisor는 자연수입니다.
        - array는 길이 1 이상인 배열입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int[] arr = new int[]{5, 9, 7, 10};
        int divisor = 5;

        //int[] arr = new int[]{2, 36, 1, 3};
        //int divisor = 1;

        //int[] arr = new int[]{3, 2, 6};
        //int divisor = 10;

        ArrayOfNum arrayOfNum = new ArrayOfNum();
        int[] result = arrayOfNum.solution(arr, divisor);
        System.out.println(Arrays.toString(result));
    }
    public int[] solution(int[] arr, int divisor) {
        int cnt = 0;    // 배열길이
        int num = 0;    // 배열인수

        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                cnt++;
            }
        }

        // divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환한다.
        if(cnt == 0){
            int[] answer = {-1};
            return answer;
        }

        int[] answer = new int[cnt];

        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                answer[num] = arr[i];
                num++;
            }
        }

        // 오름차순 정렬
        Arrays.sort(answer);
        return answer;
    }

}
