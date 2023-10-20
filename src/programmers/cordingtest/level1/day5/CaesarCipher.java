package programmers.cordingtest.level1.day5;

public class CaesarCipher {
    /*
        시저 암호

        # 문제설명
        어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
        예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
        문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

        # 제한조건
        - 공백은 아무리 밀어도 공백입니다.
        - s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
        - s의 길이는 8000이하입니다.
        - n은 1 이상, 25이하인 자연수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        String s = "AB";
        int n = 1;

        //String s = "z";
        //int n = 1;

        //String s = "a B z";
        //int n = 4;

        CaesarCipher caesarCipher = new CaesarCipher();
        String result = caesarCipher.solution(s, n);
        System.out.println(result);
    }

    public String solution(String s, int n) {
        String answer = "";

        /*
            toCharArray(): String문자열을 char형배열로 반환해주는 메서드
            ex) "ABCD" 라는 문자열을
            arr[0] = 'A'
            arr[1] = 'B'
            arr[2] = 'C'
            arr[3] = 'D'
            위 값처럼 char배열로 반환해준다.
         */

        for(char c : s.toCharArray()) {
            if(c==' ') {
                answer += c;
            }else if(c>='a'&& c<='z'){
                answer += (char)('a' + (c+n-'a')%26);
            }else if(c>='A'&& c<='Z'){
                answer += (char)('A' + (c+n-'A')%26);
            }
        }

        return answer;
    }
}
