package programmers.cordingtest.level1.day26;

import java.util.*;

public class RunningRace {
    /*
        달리기 경주

        # 문제 설명
        얀에서는 매년 달리기 경주가 열립니다. 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.
        예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때,
        해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다.
        즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.

        선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때,
        경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.

        # 제한사항
        · 5 ≤ players의 길이 ≤ 50,000
            · players[i]는 i번째 선수의 이름을 의미합니다.
            · players의 원소들은 알파벳 소문자로만 이루어져 있습니다.
            · players에는 중복된 값이 들어가 있지 않습니다.
            · 3 ≤ players[i]의 길이 ≤ 10
        · 2 ≤ callings의 길이 ≤ 1,000,000
            · callings는 players의 원소들로만 이루어져 있습니다.
            · 경주 진행중 1등인 선수의 이름은 불리지 않습니다.

        # 입출력 예 1
        4등인 "kai" 선수가 2번 추월하여 2등이 되고 앞서 3등, 2등인 "poe", "soe" 선수는 4등, 3등이 됩니다.
        5등인 "mine" 선수가 2번 추월하여 4등, 3등인 "poe", "soe" 선수가 5등, 4등이 되고 경주가 끝납니다.
        1등부터 배열에 담으면 ["mumu", "kai", "mine", "soe", "poe"]이 됩니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};   // 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열
        String[] callings = {"kai", "kai", "mine", "mine"};         // 해설진이 부른 이름을 담은 문자열 배열

        RunningRace runningRace = new RunningRace();
        String[] result = runningRace.solution(players, callings);
        System.out.println("경주가 끝났을 때 선수 1등부터 등수 순서: ");
        System.out.println(Arrays.toString(result));
    }

    public String[] solution(String[] players, String[] callings) {
        // 경주가 끝났을 때 1등부터 등수 선수들의 이름 배열
        String[] answer = players;

        // <이름, 등수>
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<players.length; i++) map.put(players[i], i);

        // map.entrySet() : key와 value의 값이 모두 필요한 경우
        // map.keySet() : key의 값만 필요한 경우

        for(int i=0; i<callings.length; i++) {
            // 이름 불린 선수의 원래 등수
            int rank = map.get(callings[i]);
            // 순위가 바뀔 선수의 이름
            String name = answer[rank-1];
            // 선수 등수 변경
            answer[rank-1] = answer[rank];
            answer[rank] = name;
            map.put(answer[rank-1], rank-1);
            map.put(answer[rank], rank);
        }

        return answer;
    }
}