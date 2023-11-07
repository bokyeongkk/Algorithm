package programmers.cordingtest.level1.day15;

import java.util.*;

public class TwoTakeAdd {
    /*
        두 개 뽑아서 더하기

        # 문제설명
        정수 배열 numbers가 주어집니다.
        numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를
        배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

        # 제한사항
        - numbers의 길이는 2 이상 100 이하입니다.
        - numbers의 모든 수는 0 이상 100 이하입니다.

        # 입출력 예1
        [2,1,3,4,1]
        2 = 1 + 1 입니다. (1이 numbers에 두 개 있습니다.)
        3 = 2 + 1 입니다.
        4 = 1 + 3 입니다.
        5 = 1 + 4 = 2 + 3 입니다.
        6 = 2 + 4 입니다.
        7 = 3 + 4 입니다.
        따라서 [2,3,4,5,6,7] 을 return 해야 합니다.

        # 입출력 예2
        2 = 0 + 2 입니다.
        5 = 5 + 0 입니다.
        7 = 0 + 7 = 5 + 2 입니다.
        9 = 2 + 7 입니다.
        12 = 5 + 7 입니다.
        따라서 [2,5,7,9,12] 를 return 해야 합니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int[] numbers = {2,1,3,4,1};
        //int[] numbers = {5,0,2,7};

        TwoTakeAdd twoTakeAdd = new TwoTakeAdd();
        int[] result = twoTakeAdd.solution(numbers);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] numbers) {
        // 결과를 담을 list 선언
        List<Integer> list = new ArrayList<>();

        // 배열 numbers의 모든 두 요소의 합을 구하기 위해 2중 반복문
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                // 두 요소의 합이 list에 존재하지 않으면 담기
                if (!list.contains(numbers[i] + numbers[j])) {
                    list.add(numbers[i] + numbers[j]);
                }
            }
        }

        // list를 오름차순 정렬하면서 int 배열로 변환
        int[] answer = list.stream().sorted().mapToInt(i -> i).toArray();
        return answer;
    }
}
