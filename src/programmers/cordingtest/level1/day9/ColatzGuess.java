package programmers.cordingtest.level1.day9;

import java.util.*;

public class ColatzGuess {

    /*
        콜라즈 추측

        # 문제설명
        1937년 Collatz란 사람에 의해 제기된 이 추측은,
        주어진 수가 1이 될 때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다.

        작업은 다음과 같습니다.
        1-1. 입력된 수가 짝수라면 2로 나눕니다.
        1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
        2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
        예를 들어, 주어진 수가 6이라면 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1 이 되어 총 8번 만에 1이 됩니다.

        위 작업을 몇 번이나 반복해야 하는지 반환하는 함수, solution을 완성해 주세요.
        단, 주어진 수가 1인 경우에는 0을, 작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환해 주세요.

        # 제한사항
        입력된 수, num은 1 이상 8,000,000 미만인 정수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int n = 6;
        //int n = 16;
        //int n = 626331;

        ColatzGuess colatzGuess = new ColatzGuess();
        int result = colatzGuess.solution1(n);
        System.out.println(result);
    }

    public int solution1(int num) {
        // 작업 횟수
        int answer = 0;

        while(num != 1) {
            if(num % 2 == 0) {      // 1-1. 입력된 수가 짝수라면
                num = num % 2;
            } else {                // 1-2. 입력된 수가 홀수라면
                num = num * 3 + 1;
            }
            answer++;

            // 작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환
            if(answer >= 500) {
                answer = -1;
                break;
            }
        }
        return answer;
    }

    /*
        파라미터를 int로 받는 경우 overflow가 발생하는 걸 볼 수 있다.
        문제는 int 파라미터를 받게 되어있지만, long으로 놓고 풀어야 맞습니다.
        int의 경우 입출력 예 3번 연산 과정에서 21억을 넘게 되는데, 이 과정에서 연산값 제한으로 계산이 뒤틀립니다.
     */

    public int solution2(long num) {
        int answer = 0;

        while(num != 1) {
            if(num % 2 == 0) {
                num /= 2;
            }else {
                num = num * 3 + 1;
            }
            answer++;

            if(answer >= 500) {
                answer = -1;
                break;
            }
        }

        return answer;
    }

    // 삼항연산자 활용
    public int solution3(int num) {
        long n = (long)num;
        for(int i=0; i<500; i++) {
            if(n==1) return i;
            n = (n%2==0) ? n/2 : n*3+1;
        }
        return -1;
    }

}
