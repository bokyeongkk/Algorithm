package programmers.cordingtest.level1.day7;


import java.util.Arrays;

public class NumIntoArray {

    /*
        자연수 뒤집어 배열로 만들기

        # 문제설명
        자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

        # 제한조건
        n은 10,000,000,000이하인 자연수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        long n = 12345;

        NumIntoArray numIntoArray = new NumIntoArray();
        int[] result = numIntoArray.solution1(n);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution1(long n) {
        String s = ""+n+""; // String으로 변경
        int[] answer = new int[s.length()]; // 입력받은 숫자의 길이만큼

        int idx = 0;
        while(n>0) {
            answer[idx]=(int)(n%10); // 12345의 나머지 5 -> 4 -> 3 -> 2 -> 1
            n/=10; // n=1234 -> 123 -> 12 -> 1
            idx++;
        }
        return answer;
    }

    public int[] solution2(long n) {

        /*
            toString()과 String.valueOf(): Object 값을 String 형으로 변환할 때 사용하는 메소드

            - 두 메소드의 차이점 (넘어오는 Object의 값이 null 일 때)
            toString(): null 값을 형 변환 시 NullPointerException(NPE)이 발생
            String.valueOf(): 파라미터로 null이 오면 "null"이라는 문자열을 출력
         */

        String s = String.valueOf(n);
        int[] answer = new int[s.length()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(s.substring(answer.length-1-i, answer.length-i));
        }

        return answer;
    }
}
