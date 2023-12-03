package programmers.cordingtest.level1.day12;

public class DartGame {
    /*
        다트 게임

        # 문제설명
        카카오톡에 뜬 네 번째 별! 심심할 땐? 카카오톡 게임별~

        카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다.
        다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
        갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다.
        다트 게임의 점수 계산 로직은 아래와 같다.

        다트 게임은 총 3번의 기회로 구성된다. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
        점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고
        각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
        옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
        아차상(#) 당첨 시 해당 점수는 마이너스된다.
        스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
        스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
        스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
        Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
        스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
        0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.

        # 입력형식
        "점수|보너스|[옵션]"으로 이루어진 문자열 3세트.
        예) 1S2D*3T

        점수는 0에서 10 사이의 정수이다.
        보너스는 S, D, T 중 하나이다.
        옵선은 *이나 # 중 하나이며, 없을 수도 있다.

        # 출력형식
        3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.
        예) 37
     */

    public static void main(String[] args) {
        // 입출력 예
        String dartResult = "1S2D*3T";
        //String dartResult = "1D2S#10S";
        //String dartResult = "1D2S0T";
        //String dartResult = "1S*2T*3S";
        //String dartResult = "1D#2S*3S";
        //String dartResult = "1T2D3D#";
        //String dartResult = "1D2S3T*";

        DartGame dartGame = new DartGame();
        int result = dartGame.solution1(dartResult);
        System.out.println("result: "+result);

        // 37 (1¹ * 2 + 2² * 2 + 3³)
        // 9 (1² + 2¹ * (-1) + 10¹
        // 3 (1² + 2¹ + 0³)
        // 23 (1¹ * 2 * 2 + 2³ * 2 + 3¹)
        // 5 (1² * (-1) * 2 + 2¹ * 2 + 3¹)
        // -4 (1³ + 2² + 3² * (-1))
        // 59 (1² + 2¹ * 2 + 3³ * 2)
    }

    public int solution1(String dartResult) {
        int[] dart = new int[3];    // 3번의 다트 게임 점수를 저장할 배열 생성
        int idx = 0;                // dart 배열 인덱스
        String numstr="";           // 숫자를 저장하는 문자열 변수 -> 나중에 문자열을 정수형으로 변환하기 위해

        // 입력 값 dartResult를 반복문을 통해 문자 하나씩 추출하여 숫자, 보너스, 옵션일 경우로 조건을 나눠 검사한다.
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);

            // 숫자일 때
            if(c>='0'&&c<='9'){
                // 검사하는 문자가 숫자일 때,  numstr에 문자를 더한다.
                // (numstr에 더하는 이유는 숫자가 한 자릿수가 아닌 10일 수도 있기 때문이다.)
                numstr+=String.valueOf(c);

            }
            // 보너스일 때
            else if(c=='S'||c=='D'||c=='T'){
                // 검사하는 문자가 S or D or T 일 때,
                // numstr을 정수로 변환하고 점수를 계산하여 각 게임 점수 배열에 대입한다.
                int n = Integer.parseInt(numstr);

                // Single(S), Double(D), Triple(T)
                // 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3)

                // Math.power(double, double)(밑수, 지수) : 제곱을 계산하는 함수
                // Ex. Math.pow(3,2) 인 경우 3의 2제곱을 계산을 한다.

                if(c=='S'){
                    dart[idx++]=(int)Math.pow(n,1);
                }
                else if(c=='D'){
                    dart[idx++]=(int)Math.pow(n,2);
                }
                else{
                    dart[idx++]=(int)Math.pow(n,3);
                }

                numstr="";
            }
            // 옵션일 때
            else {
                // 검사하는 문자가 * or #일 경우 해당 점수에 각각 2과 -1을 곱한다.
                // (dart배열에 점수를 저장할 때 idx++을 했기 때문에 * or #일 경우 값을 저장할 때는 idx-1을 통해 접근한다.)
                // 단, * 경우 첫 번째 게임 제외하고 해당 점수와 이전 점수의 2배이므로 dart [idx-2]*=2도 해야 한다.
                if(c=='*'){
                    dart[idx-1]*=2;
                    if(idx-2>=0) dart[idx-2]*=2;
                }
                else {
                    dart[idx-1]*=(-1);
                }
            }
        }

        // answer은 각 게임의 점수 dart[0] + dart[1] + dart[2]의 합이다.
        int answer=dart[0]+dart[1]+dart[2];

        return answer;
    }


}
