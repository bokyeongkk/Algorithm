package programmers.cordingtest.level1.day1;

public class MiddleLetter {

    /*
        가운데 글자 가져오기

        # 문제설명
        단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
        단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

        # 제한사항
        s는 길이가 1 이상, 100이하인 스트링입니다.

     */

    public static void main(String[] args) {
        // 입출력 예
        String s = "abcde";
        //String s = "qwer";

        MiddleLetter middleLetter = new MiddleLetter();
        String result = middleLetter.solution2(s);
        System.out.println(result);
    }

    public String solution1(String s) {
        String answer = "";
        int length = s.length();
        if (length % 2 == 0) {                                          // 단어의 길이가 짝수라면
            answer = s.substring(length/2-1, length/2+1);
        } else {                                                        // 그렇지 않다면 (= 홀수라면)
            answer = s.substring(length/2, length/2+1);
        }

        return answer;
    }

    public String solution2(String s) {
        return s.substring((s.length() - 1) / 2, s.length() / 2 + 1);
    }
}
