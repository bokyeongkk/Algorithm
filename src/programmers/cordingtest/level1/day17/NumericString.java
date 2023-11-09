package programmers.cordingtest.level1.day17;

public class NumericString {
    /*
        숫자 문자열과 영단어

        # 문제 설명
        네오와 프로도가 숫자놀이를 하고 있습니다.
        네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.

        다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
        1478 → "one4seveneight"
        234567 → "23four5six7"
        10203 → "1zerotwozero3"
        이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
        s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.

        참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.
        0	zero
        1	one
        2	two
        3	three
        4	four
        5	five
        6	six
        7	seven
        8	eight
        9	nine

        # 제한사항
        - 1 ≤ s의 길이 ≤ 50
        - s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
        - return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.

        # 입출력 예 3
        "three"는 3, "six"는 6, "seven"은 7에 대응되기 때문에 정답은 입출력 예 #2와 같은 234567이 됩니다.

        # 입출력 예 4
        s에는 영단어로 바뀐 부분이 없습니다.

        # 제한시간 안내
        정확성 테스트 : 10초
     */

    public static void main(String[] args) {
        // 입력 예
        String s = "one4seveneight";
        //String s = "23four5six7";
        //String s = "2three45sixseven";
        //String s = "123";

        NumericString numericString = new NumericString();
        int result = numericString.solution(s);
        System.out.println(result);

        // 출력 예
        // 1478
        // 234567
        // 234567
        // 1234
    }

    public int solution(String s) {
        // 영단어를 담는 String 타입의 배열 생성한다. (영단어와 배열의 인덱스값 동일)
        String[] arr = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        // 반복문을 사용해 배열 안의 모든 영단어를 검사한다.
        // String replace(CharSequnce target, CharSequence replacement) : 문자열 치환
        for(int i=0;i<arr.length;i++) {
            if(s.contains(arr[i])) {
                s = s.replace(arr[i], Integer.toString(i));
            }
        }

        return Integer.parseInt(s);
    }
}
