package programmers.cordingtest.level1.day9;

import java.util.*;

public class FindAverage {

    /*
        평균 구하기

        # 문제설명
        정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

        # 제한사항
        - arr은 길이 1 이상, 100 이하인 배열입니다.
        - arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int[] arr = {1,2,3,4};
        //int[] arr = {5,6};

        FindAverage findAverage = new FindAverage();
        double result = findAverage.solution1(arr);
        System.out.println(result);
    }

    public double solution1(int[] arr) {
        double answer = 0;
        double sum = 0;

        /*
        for문 보다는 foreach문을 활용하자

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }
        */

        for(int x : arr) {
            sum += x;
        }

        answer = sum/arr.length;
        return answer;
    }

    /*
       ※ 스트림(Stream)이란 무엇인가?
       - 컬렉션 데이터를 선언형으로 쉽게 처리할 수 있다.
       - 스트림을 이용하면 루프문(for/foreach)을 사용하지 않아도 된다. > 성능 개선 및 코드가 간결해진다.

        java.util.stream 패키지
       : 배열을 스트림으로 변환

       sum(), average(), count(), max(), min() ...
     */

    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

}
