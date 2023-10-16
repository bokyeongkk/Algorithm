package programmers.cordingtest.day2;

import java.util.Arrays;

public class SumTwoNum {

    /*
        두 정수 사이의 합

        # 문제설명
        두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
        예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.

        # 제한조건
        - a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
        - a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
        - a와 b의 대소관계는 정해져있지 않습니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int a = 3;
        int b = 5;

        //int a = 3;
        //int b = 3;

        //int a = 5;
        //int b = 3;

        SumTwoNum sumTwoNum = new SumTwoNum();
        long result = sumTwoNum.solution(a, b);
        System.out.println(result);
    }

    public long solution(int a, int b) {
        long answer = 0;
        int min = Math.min(a, b);   // 최소값
        int max = Math.max(a, b);   // 최대값

        for(int i = min; i <= max; ++i) {
            answer += i;
        }

        return answer;
    }

}
