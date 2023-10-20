package programmers.cordingtest.level1.day6;

public class AddDigits {
    /*
        자릿수 더하기

        # 문제설명
        자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
        예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

        # 제한사항
        N의 범위 : 100,000,000 이하의 자연수
     */

    public static void main(String[] args) {
        // 입출력 예
        //int n = 123;
        int n = 987;

        AddDigits addDigits = new AddDigits();
        int result = addDigits.solution2(n);
        System.out.println(result);
    }

    public int solution1(int n) {
        int answer = 0;

        // Int -> String으로 변환
        String s = Integer.toString(n);

        for(int i=0; i<s.length(); i++){
            answer += Integer.parseInt(s.substring(i, i+1));
        }

        return answer;
    }

    public int solution2(int n) {
        int answer = 0;

        while(true){
            answer+=n%10; // 나머지로 가장 마지막 자릿수 추출
            if(n<10) break;
            n=n/10;
        }

        return answer;
    }

}
