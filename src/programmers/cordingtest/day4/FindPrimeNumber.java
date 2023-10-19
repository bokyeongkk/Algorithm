package programmers.cordingtest.day4;

import java.util.Arrays;

public class FindPrimeNumber {

    /*
        소수 찾기

        # 문제설명
        1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
        소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다. (1은 소수가 아닙니다.)

        # 제한조건
        - n은 2이상 1000000이하의 자연수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int n = 10;
        //int n = 5;

        FindPrimeNumber findPrimeNumber = new FindPrimeNumber();
        int result = findPrimeNumber.solution1(n);
        System.out.println(result);
    }

    /*
         Math.pow(double a, double n): a의 n승, a를 n번 곱한 값을 리턴한다. =aⁿ
         Math.sqrt(double a): a의 제곱근
         ex) Math.sqrt(16) => 4
     */

    public int solution1(int n) {
        int answer = 0;
        boolean flag;

        for(int i=2; i<=n; i++) {
            flag = true;

            for(int j=2; j<=Math.sqrt(i); j++) {
                if(i%j==0) {
                    flag = false;
                    break;
                }
            }

            if(flag==true) answer++;
        }

        return answer;
    }

    /*
        에라토스테네스의 체를 이용한 방법
        1. 2부터 n까지의 모든 수를 나열한다.
        2. 2는 소수이므로 소수로 입력한다. 후에 2의 배수들은 소수가 아니게 되므로 n까지의 2의 배수를 모두 지운다.
        3. 3은 소수이고 2의 배수가 아니므로 지워지지 않았다. 똑같이 n까지의 3의 배수를 모두 지운다.
        4. 5, 7, 11, 13, 17, 19 ..... n의 제곱근전의 최대 소수까지 반복해준다.
     */

    public int solution2(int n) {
        // 배열 생성 (index는 0부터 시작하므로 n+1 길이로 지정)
        int[] numbers = new int[n+1];

        // 2부터 n까지의 수를 배열에 넣는다.
        for(int i=2; i<=n; i++) {
            numbers[i] = i;
        }
        //System.out.println(Arrays.toString(numbers)); // [0, 0, 2, 3, 4, 5, 6, 7, 8, 9, 10]


        // 2부터 시작해서 해당 배수는 0으로 만든다.
        // 이후에 0이면 넘어가고 아니면 해당 배수는 다시 0으로 만든다.
        for(int i=2; i<=n; i++) {
            if(numbers[i]==0) continue;

            // ex) i=3
            for(int j=2*i; j<=n; j+=i) {
                // ex)
                // 반복1: j=2*i → j=2*3 → 6
                // 반복2: j+=i → 6+=3 → 9
                numbers[j] = 0;
            }
        }

        //System.out.println(Arrays.toString(numbers)); // [0, 0, 2, 3, 0, 5, 0, 7, 0, 0, 0]

        // 배열에서 0이 아닌 것들의 개수를 세준다.
        int answer = 0;
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i]!=0) {
                answer++;
            }
        }

        return answer;
    }

}
