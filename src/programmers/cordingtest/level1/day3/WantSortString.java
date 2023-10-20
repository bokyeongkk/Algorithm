package programmers.cordingtest.level1.day3;

import java.util.*;

public class WantSortString {

    /*
        문자열 내 마음대로 정렬하기

        # 문제설명
        문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,
        각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.

        예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면
        각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.

        # 제한조건
        - strings는 길이 1 이상, 50이하인 배열입니다.
        - strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
        - strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
        - 모든 strings의 원소의 길이는 n보다 큽니다.
        - 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        //String[] strings = {"abce", "abcd", "cdx"};
        //int n = 2;

        WantSortString wantSortString = new WantSortString();
        String[] result = wantSortString.solution(strings, n);
        System.out.println(Arrays.toString(result));
    }

    public String[] solution(String[] strings, int n) {
        // strings 배열의 길이와 동일한 배열 생성
        String[] answer = new String[strings.length];

        // charAt(): String으로 저장된 문자열 중에서 한 글자만 선택해서 char타입으로 변환
        for (int i=0; i<strings.length; i++){
            // 인덱스[1] 문자 + 전체단어
            answer[i] = strings[i].charAt(n) + strings[i];
        }

        // Arrays.sort(): 오름차순 정렬
        Arrays.sort(answer);

        // substring(): 문자열 자르기
        for (int i=0; i<answer.length; i++){
            answer[i] = answer[i].substring(1);
        }

        return answer;
    }



}
