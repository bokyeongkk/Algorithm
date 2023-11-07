package programmers.cordingtest.level1.day15;

import java.util.*;

public class TernaryReversal {
    /*
        3진법 뒤집기

        # 문제설명
        자연수 n이 매개변수로 주어집니다.
        n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

        # 제한사항
        n은 1 이상 100,000,000 이하인 자연수입니다.

        # 입출력 예 1
        n (10진법) -> 45
        n (3진법) -> 1200
        앞뒤 반전(3진법) -> 0021
        10진법으로 표현 -> 7
        따라서 7을 return 해야 합니다.

        # 입출력 예 2
        n (10진법) -> 125
        n (3진법) -> 11122
        앞뒤 반전(3진법) -> 22111
        10진법으로 표현 -> 229
        따라서 229를 return 해야 합니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int n = 45;
        //int n = 125;

        TernaryReversal ternaryReversal = new TernaryReversal();
        int result = ternaryReversal.solution1(n);
        System.out.println(result);
    }

    public int solution1(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        // 10진법 -> 3진법
        while(n != 0) {
            list.add(n%3);
            n /= 3;
        }

        // 3진법 -> 10진법
        int tmp = 1;
        for(int i=list.size()-1;i>=0;i--) {
            answer += list.get(i)*tmp;
            tmp *= 3;
        }

        return answer;
    }

    /*
        N진법 -> 10진법
        Integer.parseInt(i, N);

        10진법 -> N진법
        Integer.toBinaryString(number); // 2진법
        Integer.toOctalString(number);  // 8진법
        Integer.toHexString(number);    // 16진법
     */

    public int solution2(int n) {
        String answer = "";
        while(n != 0) {
            answer += n%3;
            n /= 3;
        }

        return Integer.parseInt(answer, 3);
    }
}
