package programmers.cordingtest.level2.day10;

import java.util.*;

public class BiggestNum {
    /*
        가장 큰 수

        # 문제 설명
        0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

        예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
        이중 가장 큰 수는 6210입니다.

        0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
        순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

        # 제한 사항
        · numbers의 길이는 1 이상 100,000 이하입니다.
        · numbers의 원소는 0 이상 1,000 이하입니다.
        · 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        //int[] numbers = {6, 10, 2};
        int[] numbers = {3, 30, 34, 5, 9};

        BiggestNum biggestNum = new BiggestNum();
        String result = biggestNum.solution(numbers);
        System.out.println("순서를 재배치하여 만들 수 있는 가장 큰 수: "+result);
    }

    /*
        정렬 (sort)

        - Comparable : 기본 정렬기준을 구현하는데 사용한다.
        - Comparator : 기본 정렬기준 외에 다른 기준으로 정렬하고자할 때 사용한다.

        .compareTo() : 두개의 값을 비교하여 int 값으로 반환해주는 함수
     */

    public String solution(int[] numbers) {

        // int -> String 배열로 변환
        String[] arr = new String[numbers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        /*
            람다식 활용
            o1+o2 조합이 o2+o1 조합 보다 크면 음수 -> o1이 o2보다 좌측에
            o2+o1 조합이 o1+o2 조합 보다 크면 양수 -> o2이 o1보다 좌측에
         */
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        /*
            [6, 10, 2]
            10과 6 비교 : (106) (610) => 양수 => [6, 10]
            2와 10 비교 : (210) (102) => 음수 => [2, 10]
            [6, 2, 10]
         */

        // 입력값이 {0, 0, 0} 같은 경우가 생길 수 있기 때문에 0을 리턴하도록 해준다.
        if (arr[0].equals("0")) {
            return "0";
        }

        // StringBuilder로 정렬된 숫자를 이어붙여준다.
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }

        return answer.toString();
    }
}
