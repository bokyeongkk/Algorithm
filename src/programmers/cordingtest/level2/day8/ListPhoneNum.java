package programmers.cordingtest.level2.day8;

import java.util.*;

public class ListPhoneNum {
    /*
        전화번호 목록

        # 문제 설명
        전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
        전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

        구조대 : 119
        박준영 : 97 674 223
        지영석 : 11 9552 4421

        전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
        어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

        # 제한 사항
        · phone_book의 길이는 1 이상 1,000,000 이하입니다.
        · 각 전화번호의 길이는 1 이상 20 이하입니다.
        · 같은 전화번호가 중복해서 들어있지 않습니다.

        # 입출력 예 2
        한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.

        # 입출력 예 3
        첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        String[] phone_book = {"119", "97674223", "1195524421"};
        //String[] phone_book = {"123","456","789"};
        //String[] phone_book = {"12","123","1235","567","88"};

        ListPhoneNum listPhoneNum = new ListPhoneNum();
        boolean result = listPhoneNum.solution2(phone_book);
        System.out.println("어떤 번호가 다른 번호의 접두어인 경우가 (없으면-true/ 있으면-false): "+result);
    }

    /*
        반복문
        public boolean startsWith(String prefix)
        : prefix로 시작하는지 확인하여 true 반환
        public boolean startsWith(String prefix, int toffset)
        : toffset을 문자열의 시작점으로 하여 prefix로 시작하는지 확인하여 true 반환
     */
    public boolean solution1(String[] phone_book) {
        // 문자열 길이 오름차순 정렬
        Arrays.sort(phone_book);

        // 접두어 체크
        for(int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }

    /*
        해시(Hash)
        .containsKey(key) : 맵에서 인자로 보낸 키가 있으면 true 없으면 false를 반환
        .containsValue(value) : 맵에서 인자로 보낸 값이 있으면 true 없으면 false를 반환한다.
     */

    public boolean solution2(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        // HashMap에 전화번호 문자열 저장
        for(String phone_num : phone_book) {
            map.put(phone_num, 1);
        }

        map.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        for(String phone_num : phone_book) {
            for(int i = 0; i < phone_num.length(); i++) {
                // 각 번호의 접두사는 (0, length-1)로 존재한다.
                String prefix = phone_num.substring(0, i);
                if(map.containsKey(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }
}
