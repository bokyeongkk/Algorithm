package programmers.cordingtest.level2.day5;

public class CommonMultiple {
    /*
        N개의 최소공배수
        # 문제 설명
        두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
        예를 들어 2와 7의 최소공배수는 14가 됩니다.

        정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
        n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

        # 제한 사항
        · arr은 길이 1이상, 15이하인 배열입니다.
        · arr의 원소는 100 이하인 자연수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int arr[] = {2, 6, 8, 14};
        //int arr[] = {1, 2, 3};

        CommonMultiple commonMultiple = new CommonMultiple();
        int result = commonMultiple.solution(arr);
        System.out.println("최소공배수: "+result);
    }

    /*
        유클리드 호재법
        두 수 a와 b의 최소공배수는 a와 b의 곱을 a와 b의 최대공약수를 나눈 것과 같다는 성질을 가지고 있다.
     */

    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    // 최소공배수
    private static int lcm(int a, int b) {
        // a와 b의 최소공배수는 a와 b의 곱을 a와 b의 최대공약수를 나눈 것과 같다.
        return a * b / gcd(a, b);
    }

    // 최대공약수
    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
