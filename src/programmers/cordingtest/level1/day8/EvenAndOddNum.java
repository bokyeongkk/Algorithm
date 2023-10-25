package programmers.cordingtest.level1.day8;

import java.util.Arrays;

public class EvenAndOddNum {

    /*
        짝수와 홀수

        # 문제설명
        정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.

        # 제한조건
        - num은 int 범위의 정수입니다.
        - 0은 짝수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int num = 3;
        //int num = 4;

        EvenAndOddNum evenAndOddNum = new EvenAndOddNum();
        String result = evenAndOddNum.solution2(num);
        System.out.println(result);
    }

    public String solution1(int num) {
        String answer = "";

        if(num == 0 || num%2 == 0) {
            return answer = "Even";
        }else {
            return answer = "Odd";
        }
    }

    // 삼항연산자 활용
    public String solution2(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
