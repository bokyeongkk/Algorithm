package programmers.cordingtest.level2.day3;

public class FibonacciNum {
    /*
        피보나치 수

        # 문제 설명
        피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

        예를들어
        F(2) = F(0) + F(1) = 0 + 1 = 1
        F(3) = F(1) + F(2) = 1 + 1 = 2
        F(4) = F(2) + F(3) = 1 + 2 = 3
        F(5) = F(3) + F(4) = 2 + 3 = 5
        와 같이 이어집니다.

        2 이상의 n이 입력되었을 때,
        n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

        # 제한 사항
        · n은 2 이상 100,000 이하인 자연수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int n = 3;
        //int n = 5;

        FibonacciNum fibonacciNum = new FibonacciNum();
        int result = fibonacciNum.solution(n);
        System.out.println("n번째 피보나치 수를 1234567으로 나눈 나머지: "+result);
    }

    /*
         [ 값을 1234567로 나누어야하는 이유 ]
         int라는 자료형은 -2,147,483,648 ~ 2,147,483,647까지의 값만을 표현할 수 있다.
         문제에서 1234567로 나눈 나머지를 정답으로 내놓으라는 것은 int 자료형의 범위 내에 항상 값이 있을 수 있도록 한 것이며,
         자료형의 크기에 제한이 있는 언어를 쓸 경우 (A + B) % C ≡ ( ( A % C ) + ( B % C) ) % C라는 성질을 이용해서
         매번 계산 결과에 1234567으로 나눈 나머지를 대신 넣는 것으로 int 범위 내에 항상 값이 존재함을 보장할 수 있다.
     */
    public int solution(int n) {
        int answer = 0;

        int[] dp = new int[n+1];

        for(int i = 0; i < dp.length; i++){
            if(i == 0){
                dp[i] = 0;
            }else if(i == 1){
                dp[i] = 1;
            }else{
                // 2 이상의 n이 입력되었을 때
                // (A + B) % C의 값은 ( ( A % C ) + ( B % C) ) % C 이다.
                dp[i] = (dp[i-1] % 1234567) + (dp[i-2] % 1234567) % 1234567;
            }
        }

        answer = dp[dp.length-1] % 1234567;

        return answer;
    }
}
