package programmers.cordingtest.level2.day1;

import java.util.*;

public class NextBigNum {
    /*
        다음 큰 숫자

        # 문제 설명
        자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.

        조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
        조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
        조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
        예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.

        자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

        # 제한 사항
        n은 1,000,000 이하의 자연수 입니다.

        # 입출력 예 2
        15(1111)의 다음 큰 숫자는 23(10111)입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int n = 78;
        //int n = 15;

        NextBigNum nextBigNum = new NextBigNum();
        int result = nextBigNum.solution1(n);
        System.out.println("n의 다음 큰 숫자: "+result);
    }

    public int solution1(int n) {
        int answer = 0;

        // n을 2진수 변환
        String str = Integer.toBinaryString(n);
        System.out.println(str);

        // n의 1 갯수를 저장하는 변수
        int cnt =0;

        // 1 갯수를 카운팅
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '1') cnt++;
        }

        // n+1부터 반복
        for(int i =n+1; i<1000000; i++){
            String temp = Integer.toBinaryString(i);
            int temp_cnt = 0;
            for(int j =0;j<temp.length();j++){
                if(temp.charAt(j) == '1') temp_cnt++;
            }
            // 1인 비트의 수가 일치하면 해당 수를 담아 반복문 종료
            if(temp_cnt == cnt) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public int solution2(int n) {
        int answer = 0;

        // Integer.bitCount() : 입력된 정수를 2진수로 변환한 뒤, 2진수에 포함된 1을 카운팅 해주는 메소드
        int n_cnt = Integer.bitCount(n);
        // 증가하는 n의 1 개수를 저장 할 변수
        int b_cnt = 0;

        while(true){
            n++;
            b_cnt = Integer.bitCount(n);

            if(n_cnt == b_cnt){
                answer = n;
                break;
            }
        }

        return answer;
    }
}
