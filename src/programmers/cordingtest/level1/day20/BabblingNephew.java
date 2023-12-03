package programmers.cordingtest.level1.day20;

public class BabblingNephew {
    /*
        옹알이

        # 문제설명
        머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다.
        조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다.
        문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.

        # 제한사항
        1 ≤ babbling의 길이 ≤ 100
        1 ≤ babbling[i]의 길이 ≤ 30
        문자열은 알파벳 소문자로만 이루어져 있습니다.

        # 입출력 예 1
        ["aya", "yee", "u", "maa"]에서 발음할 수 있는 것은 "aya"뿐입니다. 따라서 1을 return합니다.

        # 입출력 예 2
        ["ayaye", "uuuma", "yeye", "yemawoo", "ayaayaa"]에서 발음할 수 있는 것은
        "aya" + "ye" = "ayaye", "ye" + "ma" + "woo" = "yemawoo"로 2개입니다.
        "yeye"는 같은 발음이 연속되므로 발음할 수 없습니다. 따라서 2를 return합니다.

        # 유의사항
        네 가지를 붙여 만들 수 있는 발음 이외에는 어떤 발음도 할 수 없는 것으로 규정합니다.
        예를 들어 "woowo"는 "woo"는 발음할 수 있지만 "wo"를 발음할 수 없기 때문에 할 수 없는 발음입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        String[] babbling = {"aya", "yee", "u", "maa"};
        //String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        BabblingNephew babblingNephew = new BabblingNephew();
        int result = babblingNephew.solution1(babbling);
        System.out.println("result: "+result);
    }

    public int solution1(String[] babblings) {
        // "aya", "ye", "woo", "ma" 4가지 발음만 가능

        int answer = 0;

        // 연속된 발음이 있는 경우 continue
        for(int i = 0; i < babblings.length; i++) {
            if(babblings[i].contains("ayaaya") || babblings[i].contains("yeye") || babblings[i].contains("woowoo") || babblings[i].contains("mama")) {
                continue;
            }

            // replace(CharSequence target, CharSequence replacement)
            // CharSequence target:  변환하고자 하는 대상이 될 문자열
            // CharSequence replacement : 변환할 문자 값
            // 대상 문자열을 원하는 문자 값으로 변환하는 함수

            // " "이 아닌 ""으로 하는 경우 남은 양옆의 글자가 붙어 의도하는 바와 다르게 삭제될 수 있다.
            babblings[i] = babblings[i].replace("aya", " ");
            babblings[i] = babblings[i].replace("ye", " ");
            babblings[i] = babblings[i].replace("woo", " ");
            babblings[i] = babblings[i].replace("ma", " ");

            // 공백으로 만들어준 부분은 다시 제거해준다.
            babblings[i] = babblings[i].replace(" ", "");

            if(babblings[i].length() == 0) {
                answer++;
            }
        }
        return answer;
    }

    public int solution2(String[] babbling) {
        int answer = 0;

        String[] str = {"aya", "ye", "woo", "ma"};
        String[] repeatStr = {"ayaaya", "yeye", "woowoo", "mama"};

        for(int i=0; i<babbling.length; i++){
            for(int j=0; j<str.length; j++){
                // replaceAll(String regex, String replacement)
                // String regex : 변환하고자 하는 대상이 될 문자열
                // String replacement : 변환할 문자 값
                // 대상 문자열을 원하는 문자 값으로 변환하는 함수

                babbling[i] = babbling[i].replaceAll(repeatStr[j], "1").replaceAll(str[j], " ");
            }

            // trim()으로 공백 제거
            if(babbling[i].trim().length() == 0){
                answer++;
            }
        }
        return answer;
    }


}
