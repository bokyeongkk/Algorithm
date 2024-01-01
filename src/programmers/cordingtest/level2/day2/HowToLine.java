package programmers.cordingtest.level2.day2;

import java.util.*;

public class HowToLine {
    /*
        줄 서는 방법

        # 문제 설명
        n명의 사람이 일렬로 줄을 서고 있습니다.
        n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨져 있습니다.
        n명이 사람을 줄을 서는 방법은 여러가지 방법이 있습니다.
        예를 들어서 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.

        [1, 2, 3]
        [1, 3, 2]
        [2, 1, 3]
        [2, 3, 1]
        [3, 1, 2]
        [3, 2, 1]

        사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때,
        k번째 방법을 return하는 solution 함수를 완성해주세요.

        제한사항
        · n은 20이하의 자연수 입니다.
        · k는 n! 이하의 자연수 입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int n = 3;
        long k = 5;

        HowToLine howToLine = new HowToLine();
        int[] result = howToLine.solution(n, k);
        System.out.println("k번째 방법: ");
        System.out.println(Arrays.toString(result));
    }

    /*
        경우의 수를 구하는 방법 -> n!
        3! = 3∗2∗1 = 6
        4! = 4∗3∗2∗1 = 24
     */

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            list.add(i);
        }

        System.out.println("factorial: "+factorial);    // 6
        System.out.println("list: "+list);              // [1, 2, 3]

        // 배열은 0부터 시작이므로 k번째인 인덱스를 맞추기 위해 k--
        k--;

        int idx = 0;
        while (idx < n) {
            factorial /= n - idx;
            answer[idx++] = list.remove((int) (k / factorial));
            // 빠진 단위만큼 변경
            k %= factorial;
        }
        return answer;
    }
}
