package programmers.cordingtest.level2.day4;

public class MakeJadenCase {
    /*
        JadenCase 문자열 만들기

        # 문제 설명
        JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
        단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
        문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

        # 제한 조건
        · s는 길이 1 이상 200 이하인 문자열입니다.
        · s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
            · 숫자는 단어의 첫 문자로만 나옵니다.
            · 숫자로만 이루어진 단어는 없습니다.
            · 공백문자가 연속해서 나올 수 있습니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        String s = "3people unFollowed me";
        //String s = "for the last week";

        MakeJadenCase makeJadenCase = new MakeJadenCase();
        String result = makeJadenCase.solution2(s);
        System.out.println("JadenCase로 바꾼 문자열: "+result);
    }

    public String solution1(String s) {
        String answer = "";

        // " " 기준으로 문자열 잘라서 배열에 넣는다.
        String[] arr = s.split(" ");

        for(int i=0; i<arr.length; i++) {
            String str = arr[i];

            // 문자가 공백인 경우
            if(arr[i].length() == 0) {
                answer += " ";
            }
            // 문자가 공백이 아닌 경우
            else {
                // 0번째 문자는 대문자로
                answer += str.substring(0, 1).toUpperCase();
                // 1번째 문자부터 마지막까지는 소문자로
                answer += str.substring(1, str.length()).toLowerCase();
                // 마지막에 " " 추가
                answer += " ";
            }

        }

        // 입력 받은 문자열의 맨 마지막이 " " 라면 바로 answer 반환
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }

        // 맨 마지막 " " 제거하고 answer 반환
        return answer.substring(0, answer.length()-1);
    }

    public String solution2(String s) {
        String answer = "";
        String[] words = s.toLowerCase().split("");

        boolean flag = true;

        for (String word : words) {
            answer += flag ? word.toUpperCase() : word;
            flag = word.equals(" ") ? true : false;
        }

        return answer;
    }
}
