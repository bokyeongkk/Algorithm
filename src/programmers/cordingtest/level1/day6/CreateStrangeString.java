package programmers.cordingtest.level1.day6;

public class CreateStrangeString {
    /*
        이상한 문자 만들기

        # 문제설명
        문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
        각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

        "try hello world"는 세 단어 "try", "hello", "world"로 구성되어 있습니다.
        각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 "TrY", "HeLlO", "WoRlD"입니다.
        따라서 "TrY HeLlO WoRlD" 를 리턴합니다.

        # 제한사항
        - 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
        - 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        String s = "try hello world";

        CreateStrangeString createStrangeString = new CreateStrangeString();
        String result = createStrangeString.solution2(s);
        System.out.println(result);
    }

    public String solution1(String s) {
        String answer = "";

        // 문자열 -> 배열로 생성
        String[] str = s.split("");

        int idx = 0; // 인덱스
        for(int i=0; i<str.length; i++){
            if(str[i].equals(" ")){ // 띄어쓰기 있다면
                idx = 0; //인덱스 0 초기화
            }
            else if(idx % 2 == 0){ // idx가 짝수면
                str[i] = str[i].toUpperCase(); // 대문자로 변경
                idx++; //idx 증가
            }
            else if(idx % 2 != 0){ // idx가 홀수면
                str[i] = str[i].toLowerCase(); // 소문자로 변경
                idx++; //idx 증가
            }
            answer += str[i];
        }
        return answer;
    }

    public String solution2(String s) {
        String answer = "";
        int idx = 0;
        String[] array = s.split("");

        for(String str : array) {
            idx = str.contains(" ") ? 0 : idx + 1;
            answer += idx%2 == 0 ? str.toLowerCase() : str.toUpperCase();
        }
        return answer;
    }

}
