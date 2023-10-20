package programmers.cordingtest.level1.day6;

public class SumOfDivisors {

    /*
        약수의 합

        # 문제설명
        정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
        12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.
        5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.

        # 제한사항
        n은 0 이상 3000이하인 정수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        //int n = 12;
        int n = 5;

        SumOfDivisors sumOfDivisors = new SumOfDivisors();
        int result = sumOfDivisors.solution(n);
        System.out.println(result);
    }

    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n; i++) {
            if(n%i == 0) {
                answer+=i;
            }
        }

        return answer;
    }
}
