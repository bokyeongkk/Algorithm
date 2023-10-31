package programmers.cordingtest.level1.day11;

import java.util.*;

public class MakingDecimal {
    /*
        소수 만들기

        # 문제설명
        주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
        숫자들이 들어있는 배열 nums가 매개변수로 주어질 때 nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때
        소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

        # 제한사항
        - nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
        - nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.

        # 입출력 예1
        [1,2,4]를 이용해서 7을 만들 수 있습니다.

        # 입출력 예2
        [1,2,4]를 이용해서 7을 만들 수 있습니다.
        [1,4,6]을 이용해서 11을 만들 수 있습니다.
        [2,4,7]을 이용해서 13을 만들 수 있습니다.
        [4,6,7]을 이용해서 17을 만들 수 있습니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        //int[] nums = {1,2,3,4};
        int[] nums = {1,2,7,6,4};

        MakingDecimal makingDecimal = new MakingDecimal();
        int result = makingDecimal.solution1(nums);

        System.out.println(result);
    }

    public int solution1(int[] nums) {
        int answer = 0;

        // 시작하는 인덱스가 겹치지 않도록 설정한다. (i=0)
        for (int i = 0; i < nums.length; i++)
        {
            // 시작하는 인덱스가 겹치지 않도록 설정한다. (j=i+1)
            for (int j = i + 1; j < nums.length; j++)
            {
                // 시작하는 인덱스가 겹치지 않도록 설정한다. (k=j+1)
                for (int k = j + 1; k < nums.length; k++)
                {
                    int sum = nums[i] + nums[j] + nums[k];

                    // 소수 찾기
                    if(isPrime(sum)){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    // 소수 찾기
    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            // 나누어 떨어질 경우
            if (num % i == 0) return false;
        }
        return true;
    }

}
