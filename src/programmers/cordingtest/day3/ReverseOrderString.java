package programmers.cordingtest.day3;

import java.util.*;

public class ReverseOrderString {

    /*
        문자열 내림차순으로 배치하기

        # 문제설명
        문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
        s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

        # 제한사항
        str은 길이 1 이상인 문자열입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        String s = "Zbcdefg";

        ReverseOrderString reverseOrderString = new ReverseOrderString();
        String result = reverseOrderString.solution(s);
        System.out.println(result);
    }

    public String solution(String s) {
        String answer = "";

        // split(String regex): 입력받은 정규표현식 또는 특정 문자를 기준으로 문자열을 나누어 배열에 저장하여 리턴
        String[] str = s.split("");

        // reverseOrder(): 내림차순 정렬
        Arrays.sort(str, Collections.reverseOrder());

        for(String i : str)
            answer += i;

        return answer;
    }

}
