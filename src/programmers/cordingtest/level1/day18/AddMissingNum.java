package programmers.cordingtest.level1.day18;

import java.util.*;

public class AddMissingNum {

    /*
        없는 숫자 더하기

        # 문제설명
        0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
        numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

        # 제한사항
        1 ≤ numbers의 길이 ≤ 9
        0 ≤ numbers의 모든 원소 ≤ 9
        numbers의 모든 원소는 서로 다릅니다.

        # 입출력 예 1
        5, 9가 numbers에 없으므로, 5 + 9 = 14를 return 해야 합니다.

        # 입출력 예 2
        1, 2, 3이 numbers에 없으므로, 1 + 2 + 3 = 6을 return 해야 합니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int[] numbers = {1,2,3,4,6,7,8,0};
        //int[] numbers = {5,8,4,0,6,7,9};

        AddMissingNum addMissingNum = new AddMissingNum();
        int result = addMissingNum.solution1(numbers);
        System.out.println(result);
    }

    public int solution1(int[] numbers) {
        int answer=0;
        for(int i=0;i<10;i++){
            // 포함 여부 검사
            if(!contains(numbers,i)) answer += i;
        }

        return answer;
    }

    public boolean contains(int[] arr, int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    public int solution2(int[] numbers) {
        // 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
        // 결국 더한 수를 구하면 되기 때문에 45에서 있는 숫자들을 빼주면 된다.
        int answer = 45;

        for (int n : numbers) {
            answer -= n;
        }

        return answer;
    }

}
