package programmers.cordingtest.level1.day8;

import java.util.Arrays;

public class GcdAndLcm {
    /*
        최대공약수와 최소공배수

        # 문제설명
        두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
        배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
        예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

        # 제한사항
        두 수는 1이상 1000000이하의 자연수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        //int n = 3;
        //int m = 12;
        int n = 2;
        int m = 5;

        GcdAndLcm gcdAndLcm = new GcdAndLcm();
        int[] result = gcdAndLcm.solution1(n, m);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution1(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcd(n, m);                  // 최대공약수
        answer[1] = (n*m)/answer[0];            // 최소공배수(n*m/최대공약수)

        return answer;
    }

    public static int gcd(int p, int q)
    {
        // 유클리드 호제법
        if (q == 0) return p;
        return gcd(q, p%q);
    }
}
