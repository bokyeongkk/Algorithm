package programmers.cordingtest.level1.day7;

import java.util.*;

public class SortByInt {

    /*
        정수 내림차순으로 배치하기

        # 문제설명
        함수 solution은 정수 n을 매개변수로 입력받습니다.
        n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
        예를들어 n이 118372면 873211을 리턴하면 됩니다.

        # 제한조건
        - n은 1이상 8,000,000,000 이하인 자연수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        long n = 118372;

        SortByInt sortByInt = new SortByInt();
        long result = sortByInt.solution1(n);
        System.out.println(result);
    }

    public long solution1(long n) {
        // Long -> String 형변환
        String str = Long.toString(n);

        // Int 배열에 값 넣어주기
        int[] arr = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i+1);
            arr[i] = Integer.parseInt(s);
        }

        // 내림차순 정렬 (메소드 없이 구현해보기)
        for(int j = 0; j < str.length()-1; j++){
            for(int i = 0; i < str.length()-1; i++) {
                if (arr[i] < arr[i+1]) {
                    int tmp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = tmp;
                }
            }
        }

        String answer = "";
        for(int i = 0; i < str.length(); i++){
            answer += arr[i];
        }

        return Long.parseLong(answer);
    }

    public long solution2(long n) {
        String[] list = String.valueOf(n).split("");    // long -> String 배열로 변환
        Arrays.sort(list);                                    // 오름차순 정렬

        /*
            StringBuilder: 문자열을 버퍼에 담아 그 안에서 추가 수정 삭제 작업을 할 수 있도록 도와주는 클래스
            - append(String str): 변수의 제일 뒤에 문자열 추가
            - insert(int index, String str): 특정 위치에 문자열 추가
            - replace(int start, int end, String str): 파라미터로 받은 시작과 끝 인덱스 문자열 대체
            - reverse(): 글자 순서 뒤집기
            - toString(): StringBuilder->String으로 변환
         */
        StringBuilder sb = new StringBuilder();
        for (String str : list) sb.append(str);

        long answer = Long.parseLong(sb.reverse().toString());
        return answer;
    }

    public long solution3(long n) {
        String[] list = String.valueOf(n).split("");    // long -> String 배열로 변환

        /*
            내림차순으로 정렬하려면 sort()의 인자에 추가로 Collections.reverseOrder()를 전달해야함
            Collections.reverseOrder()는 Comparator 객체이며, 역순으로 정렬해줌
         */
        Arrays.sort(list, Collections.reverseOrder());

        // String.join(): 배열->문자열 변환
        String str = String.join("", list);
        long answer = Long.parseLong(str);
        return answer;
    }

}
