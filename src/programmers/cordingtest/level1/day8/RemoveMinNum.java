package programmers.cordingtest.level1.day8;

import java.util.*;

public class RemoveMinNum {

    /*
        제일 작은 수 제거하기

        # 문제설명
        정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
        단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
        예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

        # 제한조건
        - arr은 길이 1 이상인 배열입니다.
        - 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.

     */

    public static void main(String[] args) {
        // 입출력 예
        int[] arr = {4,3,2,1};
        //int[] arr = {10};

        RemoveMinNum removeMinNum = new RemoveMinNum();
        int[] result = removeMinNum.solution2(arr);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution1(int[] arr) {
        // 배열 길이가 1인 경우 -1 반환한다.
        if(arr.length <= 1){
            int[] answer = {-1};
            return answer;
        }

        // 가장 작은 수를 뺀 길이의 배열로 생성한다.
        int[] answer = new int[arr.length-1];

        /*
            얕은 복사(Shallow Copy) : 복사된 배열이나 원본배열이 변경될 때 서로 간의 값이 같이 변경됩니다.
            ex) int[] a = b;
            깊은 복사(Deep Copy) : 복사된 배열이나 원본배열이 변경될 때 서로 간의 값은 바뀌지 않습니다.
            ex) Object.clone()
         */

        // 파라미터로 받은 배열을 오름차순으로 정렬한다.
        //int[] ascArr = arr;
        int[] ascArr = arr.clone();
        Arrays.sort(ascArr);

        // 오름차순으로 정렬된 배열에서 제일 작은 수
        int minNum = ascArr[0];

        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            // 가장 작은 수는 배열에 추가하지 않는다.
            if(arr[i] == minNum) {
                continue;
            }
            answer[idx++] = arr[i];
        }

        return answer;
    }

    public int[] solution2(int[] arr) {
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }

        int[] answer = new int[arr.length-1];

        // 가장 작은 임의의 수를 기준으로 잡는다.
        int min = arr[0];

        // 가장 작은 수 구하기
        for(int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == min) {
                continue;
            }else {
                //answer[idx] = arr[i];
                //idx += 1;
                answer[idx++] = arr[i];
            }
        }

        return answer;
    }


}
