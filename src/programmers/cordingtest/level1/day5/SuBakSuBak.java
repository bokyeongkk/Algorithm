package programmers.cordingtest.level1.day5;

public class SuBakSuBak {
    /*
        수박수박수박수박수박수?

        # 문제설명
        길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
        예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.

        # 제한조건
        n은 길이 10,000이하인 자연수입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int n = 3;
        //int n = 4;

        SuBakSuBak suBakSuBak = new SuBakSuBak();
        String result = suBakSuBak.solution(n);
        System.out.println(result);
    }

    public String solution(int n) {
        String answer = "";

        for(int i=1; i<=n; i++) {
            answer += i%2!=0 ? "수" : "박";
        }

        return answer;
    }

}
