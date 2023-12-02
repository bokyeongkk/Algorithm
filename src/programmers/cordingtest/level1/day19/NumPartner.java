package programmers.cordingtest.level1.day19;

import java.util.Arrays;

public class NumPartner {
    /*
        숫자 짝꿍

        # 문제설명
        두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를
        두 수의 짝꿍이라 합니다(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).
        X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.

        예를 들어, X = 3403이고 Y = 13203이라면,
        X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다.
        다른 예시로 X = 5525이고 Y = 1255이면
        X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다.
        (X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
        두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.

        # 제한사항
        3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다.
        X, Y는 0으로 시작하지 않습니다.
        X, Y의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.

        # 입출력 예 1
        X, Y의 짝꿍은 존재하지 않습니다. 따라서 "-1"을 return합니다.

        # 입출력 예 2
        X, Y의 공통된 숫자는 0으로만 구성되어 있기 때문에, 두 수의 짝꿍은 정수 0입니다. 따라서 "0"을 return합니다.

        # 입출력 예 3
        X, Y의 짝꿍은 10이므로, "10"을 return합니다.

        # 입출력 예 4
        X, Y의 짝꿍은 321입니다. 따라서 "321"을 return합니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        //String X = "100";
        //String Y = "2345";

        //String X = "100";
        //String Y = "203045";

        //String X = "100";
        //String Y = "123450";

        String X = "12321";
        String Y = "42531";

        //String X = "5525";
        //String Y = "1255";

        NumPartner numPartner = new NumPartner();
        String result = numPartner.solution2(X, Y);
        System.out.println(result);
    }

    public String solution1(String X, String Y) {
        String answer = "";

        // 리스트로 만들어 놓고
        // 하나씩 지우면서 공통 된 수 만들면 되겠지..

        // 그리고 배열을 내림차순해서 큰 수로 만들기



        return answer;
    }

    public String solution2(String X, String Y) {
        StringBuilder str = new StringBuilder();

        int[] xArr = new int[10];
        int[] yArr = new int[10];

        for(String x : X.split("")) {
            xArr[Integer.parseInt(x)]++;
        }
        for(String y: Y.split("")) {
            yArr[Integer.parseInt(y)]++;
        }

        for(int i=9; i>=0; i--) {
            while(xArr[i] > 0 && yArr[i] > 0) {
                str.append(i);
            }
        }

        if("".equals(str.toString())) return "-1";
        if("0".equals(str.toString().substring(0,1))) return "0";

        String answer = str.toString();
        return answer;
    }

}
