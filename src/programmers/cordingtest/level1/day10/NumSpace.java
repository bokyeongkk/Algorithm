package programmers.cordingtest.level1.day10;

import java.util.Arrays;

public class NumSpace {
    /*
        x만큼 간격이 있는 n개의 숫자

        # 문제설명
        함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.
        다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

        # 제한조건
        - x는 -10000000 이상, 10000000 이하인 정수입니다.
        - n은 1000 이하인 자연수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        //int x = 2;
        //int n = 5;

        //int x = 4;
        //int n = 3;

        int x = -4;
        int n = 2;

        NumSpace numSpace = new NumSpace();
        long[] result = numSpace.solution1(x, n);
        System.out.println(Arrays.toString(result));
    }

    public long[] solution1(int x, int n) {
        // 숫자를 n개를 가지는 배열 생성
        long[] answer = new long[n];

        long num = x;
        for(int i = 0; i < answer.length; i++){
            answer[i] = num;
            num += x;
        }
        return answer;
    }
}
