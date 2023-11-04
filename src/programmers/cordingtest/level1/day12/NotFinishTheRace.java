package programmers.cordingtest.level1.day12;

import java.util.*;

public class NotFinishTheRace {

    /*
        완주하지 못한 선수

        # 문제설명
        수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
        마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
        완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

        # 제한사항
        - 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
        - completion의 길이는 participant의 길이보다 1 작습니다.
        - 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
        - 참가자 중에는 동명이인이 있을 수 있습니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        String[] participant = {"leo", "kiki", "eden"}; // 마라톤에 참여한 선수들의 이름이 담긴 배열
        String[] completion = {"eden", "kiki"};         // 완주한 선수들의 이름이 담긴 배열

        //String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        //String[] completion = {"josipa", "filipa", "marina", "nikola"};

        //String[] participant = {"mislav", "stanko", "mislav", "ana"};
        //String[] completion = {"stanko", "ana", "mislav"};

        NotFinishTheRace notFinishTheRace = new NotFinishTheRace();
        String result = notFinishTheRace.solution(participant, completion);
        System.out.println(result);
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        /*
            1. HashMap 만들기
            - HashMap이란 Key-Value의 Pair를 관리하는 클래스이다.
            - HashMap<String, Integer>로 지정하면 Key는 String 형태, Value는 Integer 형태로 정의하는 것이다.
            - 이 문제에서 Key는 Participant의 이름, Value는 Count가 되기 때문에 String/Integer로 해야 한다.

            2.HashMap에 Participant 추가하기
            - 'Hashing을 한다'라고도 표현하는데, HashMap에 참가자를 전부 추가해야 한다.
            - HashMap.put(Key,Value) : HashMap에 Key와 Value 입력
            - HashMap.get(Key) : Key에 해당하는 Value 반환
            - HashMap.getOrDefault('A', 0) : 'A'라는 Key에 해당하는 Value가 있으면 가져오고, 아닐 경우 0을 Default로 지정하여 사용하겠다는 의미
            - 여기서 "Value를 전부 1로 하면 되지 않을까?"라는 의문이 생긴다면, 동명이인이 있는 예외 케이스를 고민해보면 좋다.
         */

        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant)
            map.put(player, map.getOrDefault(player, 0) + 1);
        for (String player : completion)
            map.put(player, map.get(player) - 1);

        /*
            map 출력
            leo : 1
            eden : 0
            kiki : 0
         */
        map.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        /*
            3. Value가 0이 아닌 참가자 찾기
            - HashMap.getKey()
            - HashMap.getValue()
         */

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }

    /*
        Map 데이터 가져오는 방법
        1. Iterator
        2. entrySet()
        3. keySet()
     */

    public void mapSample() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");
        map.put("key6", "value6");

        // Iterator
        System.out.println("Iterator");
        Iterator<String> keys = map.keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();
            System.out.println( String.format("key : %s, value : %s", key, map.get(key)) );
        }

        // entrySet()
        System.out.println("entrySet()");
        for( Map.Entry<String, String> elem : map.entrySet() ){
            System.out.println( String.format("key : %s, value : %s", elem.getKey(), elem.getValue()) );
        }

        // keySet()
        System.out.println("keySet()");
        for( String key : map.keySet() ){
            System.out.println( String.format("key : %s, value : %s", key, map.get(key)) );
        }
    }
}
