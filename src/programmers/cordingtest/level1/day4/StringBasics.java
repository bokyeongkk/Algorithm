package programmers.cordingtest.level1.day4;

public class StringBasics {

    /*
        문자열 다루기 기본

        # 문제설명
        문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
        예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

        # 제한사항
        - s는 길이 1 이상, 길이 8 이하인 문자열입니다.
        - s는 영문 알파벳 대소문자 또는 0부터 9까지 숫자로 이루어져 있습니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        //String s = "a234";
        String s = "1234";

        StringBasics stringBasics = new StringBasics();
        boolean result = stringBasics.solution2(s);
        System.out.println(result);
    }

    public boolean solution1(String s) {
        if(s.length() == 4 || s.length() == 6){
            try{
                // Integer.parseInt(): 문자열을 정수로 변환
                int x = Integer.parseInt(s);
                return true;
            } catch(NumberFormatException e){
                return false;
            }
        }
        else return false;
    }

    public boolean solution2(String s) {
        // String.matches(): 특정한 패턴의 문자열을 포함하는지 검사
        // regex: 정규표현식
        if(s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
        else return false;
    }

}
