package programmers.cordingtest.level1.day9;

public class HarshadNum {

    /*
        하샤드 수

        # 문제설명
        양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
        예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
        자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.

        # 제한조건
        x는 1 이상, 10000 이하인 정수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int x = 10;
        //int x = 12;
        //int x = 11;
        //int x = 13;

        HarshadNum harshadNum = new HarshadNum();
        boolean result = harshadNum.solution1(x);
        System.out.println(result);
    }

    public boolean solution1(int x) {
        boolean answer = true;
        int sum = 0;

        // Int -> String 변환
        String[] num = Integer.toString(x).split("");

        // 자리수의 합
        for(int i = 0; i < num.length; i++) {
            sum += Integer.parseInt(num[i]);
        }

        // 자리수의 합으로 나누어지는지 검사
        if(x%sum != 0) {
            answer = false;
        }

        return answer;
    }

    public boolean solution2(int x) {
        int sum = 0;
        int a = x;

        while (a >= 1) {
            sum += a % 10;
            a /= 10;
        }

        if (x%sum == 0) {
            return true;
        } else {
            return false;
        }
    }

}
