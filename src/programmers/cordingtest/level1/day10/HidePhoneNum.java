package programmers.cordingtest.level1.day10;


public class HidePhoneNum {
    /*
        핸드폰 번호 가리기

        # 문제설명
        프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.

        전화번호가 문자열 phone_number로 주어졌을 때,
        전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

        # 제한조건
        phone_number는 길이 4 이상, 20이하인 문자열입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        String phone_number = "01033334444";
        //String phone_number = "027778888";

        HidePhoneNum hidePhoneNum = new HidePhoneNum();
        String result = hidePhoneNum.solution1(phone_number);
        System.out.println(result);
    }

    public String solution1(String phone_number) {
        char[] ch = phone_number.toCharArray();
        // 뒷 4자리를 제외하고 나머지 숫자를 전부 *으로 가린다.
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }

    // 정규표현식 사용
    public String solution2(String phone_number) {
        return phone_number.replaceAll(".(?=.{4})", "*");
    }
}
