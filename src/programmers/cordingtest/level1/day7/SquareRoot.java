package programmers.cordingtest.level1.day7;

public class SquareRoot {
    /*
        정수 제곱근 판별

        # 문제설명
        임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
        n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

        121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.
        3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.

        # 제한사항
        - n은 1이상, 50000000000000 이하인 양의 정수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        long n = 121;
        //long n = 3;

        SquareRoot squareRoot = new SquareRoot();
        long result = squareRoot.solution(n);
        System.out.println(result);
    }

    public long solution(long n) {
        long answer = 0;

        /*
            ※참고※ day4_FindPrimeNum_소수찾기

            Math.pow(double a, double n): a의 n승, a를 n번 곱한 값을 리턴한다. =aⁿ
            Math.sqrt(double a): a의 제곱근
            ex) Math.sqrt(16) => 4
         */

        double sqrt = Math.sqrt(n);
        System.out.println(sqrt); // 11.0

        if(sqrt % 1 == 0) {
            answer = (long) Math.pow(sqrt+1, 2);
        }else {
            answer = -1;
        }

        return answer;
    }

}
