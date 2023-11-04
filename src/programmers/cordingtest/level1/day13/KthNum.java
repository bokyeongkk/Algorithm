package programmers.cordingtest.level1.day13;

import java.util.*;

public class KthNum {
    /*
        K번째수

        # 문제설명
        배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

        예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
        array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.

        1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
        2에서 나온 배열의 3번째 숫자는 5입니다.
        배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
        commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록
        solution 함수를 작성해주세요.

        # 제한사항
        - array의 길이는 1 이상 100 이하입니다.
        - array의 각 원소는 1 이상 100 이하입니다.
        - commands의 길이는 1 이상 50 이하입니다.
        - commands의 각 원소는 길이가 3입니다.
     */

    public static void main(String[] args) {
        // 입력 예
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};   // [i, j, k]를 원소로 가진 2차원 배열

        KthNum kthNum = new KthNum();
        int[] result = kthNum.solution1(array, commands);
        System.out.println(Arrays.toString(result));

        // 출력 예
        // [5, 6, 3]
    }

    public int[] solution1(int[] array, int[][] commands) {
        // 2차원 배열의 길이로 배열 생성
        int[] answer = new int[commands.length];
        int answer_idx = 0;

        for (int i = 0; i < commands.length; i++) {
            int list_idx = 0;

            // new int[5-2+1=4]
            // new int[4-4+1=1]
            // new int[7-1+1=7]
            int[] list = new int[commands[i][1] - commands[i][0] + 1];

            // j = 2~5 // j = 4~4 / j= 1~7
            for (int j = commands[i][0]; j <= commands[i][1]; j++) {
                // {5,2,6,3} // {6} // {1,5,2,6,3,7,4}
                list[list_idx] = array[j - 1];
                list_idx++;
            }

            // Array 오름차순 정렬
            // {2,3,5,6} // {6} // {1,2,3,4,5,6,7}
            Arrays.sort(list);

            // k번째 수 찾기
            answer[answer_idx] = list[commands[i][2] - 1];
            answer_idx++;
        }

        return answer;
    }

    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0]; j <= commands[i][1]; j++) {
                list.add(array[j-1]);

                // ArrayList 오름차순 정렬
                Collections.sort(list);
            }
            answer[i] = list.get(commands[i][2] - 1);
            list.clear();
        }

        return answer;
    }

    public int[] solution3(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            // Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스)
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);

            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }

        return answer;
    }
}
