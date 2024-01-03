package programmers.cordingtest.level2.day4;

import programmers.cordingtest.level2.day3.FibonacciNum;

import java.util.*;

public class TowerOfHanoi {
    /*
        하노이의 탑

        # 문제 설명
        하노이 탑(Tower of Hanoi)은 퍼즐의 일종입니다.
        세 개의 기둥과 이 기동에 꽂을 수 있는 크기가 다양한 원판들이 있고,
        퍼즐을 시작하기 전에는 한 기둥에 원판들이 작은 것이 위에 있도록 순서대로 쌓여 있습니다.
        게임의 목적은 다음 두 가지 조건을 만족시키면서,
        한 기둥에 꽂힌 원판들을 그 순서 그대로 다른 기둥으로 옮겨서 다시 쌓는 것입니다.

        한 번에 하나의 원판만 옮길 수 있습니다.
        큰 원판이 작은 원판 위에 있어서는 안됩니다.

        하노이 탑의 세 개의 기둥을 왼쪽 부터 1번, 2번, 3번이라고 하겠습니다.
        1번에는 n개의 원판이 있고 이 n개의 원판을 3번 원판으로 최소 횟수로 옮기려고 합니다.

        1번 기둥에 있는 원판의 개수 n이 매개변수로 주어질 때,
        n개의 원판을 3번 원판으로 최소로 옮기는 방법을 return하는 solution를 완성해주세요.

        # 제한사항
        · n은 15이하의 자연수 입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int n = 2;

        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        int[][] result = towerOfHanoi.solution(n);
        System.out.println("n개의 원판을 3번 원판으로 최소로 옮기는 방법: ");
        System.out.println(Arrays.deepToString(result));
    }

    /*
        "하노이의 탑"은 규칙이 존재하는 대표적인 재귀 문제다.

        [출발지, 경유지, 도착지] 3개의 위치

        "N개, 출발지 -> 도착지"의 경우
        "N-1개, 출발지 -> 경유지" + "1개, 출발지 -> 도착지" + "N-1개, 경유지 -> 도착지"의 규칙을 가진다.

        이를 점화식으로 표현하고 코드로 구현한다.
     */

    private static List<int[]> arr = new ArrayList<>();

    public int[][] solution(int n) {
        move(n, 1, 2, 3);
        int[][] answer = arr.stream()
                .toArray(int[][]::new);
        return answer;
    }

    private static void move(int cnt, int start, int mid, int end) {
        if (cnt == 0) {
            return;
        }
        move(cnt - 1, start, end, mid);
        arr.add(new int[]{start, end});
        move(cnt - 1, mid, start, end);
    }
}
