package programmers.cordingtest.level1.day14;

import java.util.*;

public class FailureRate {

    /*
        실패율

        # 문제설명
        슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다.
        그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다.
        원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
        이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다.
        역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다.
        오렐리를 위해 실패율을 구하는 코드를 완성하라.

        실패율은 다음과 같이 정의한다.
        스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
        실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

        # 제한사항
        - 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
        - stages의 길이는 1 이상 200,000 이하이다.
        - stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
        - 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
        - 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
        - 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
        - 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

        # 입출력 예1
        [2,1,2,6,2,4,3,3]
        1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다.
        따라서 1번 스테이지의 실패율은 다음과 같다.
        1번 스테이지 실패율 : 1/8

        2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다.
        따라서 2번 스테이지의 실패율은 다음과 같다.
        2번 스테이지 실패율 : 3/7

        마찬가지로 나머지 스테이지의 실패율은 다음과 같다.
        3번 스테이지 실패율 : 2/4
        4번 스테이지 실패율 : 1/2
        5번 스테이지 실패율 : 0/1

        각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.
        [3,4,2,1,5]

        # 입출력 예2
        [4,4,4,4,4]
        모든 사용자가 마지막 스테이지에 있으므로
        4번 스테이지 실패율은 : 5/5(1)
        나머지 스테이지 실패율 : 0/5(0)
        [4,1,2,3]
     */

    public static void main(String[] args) {
        // 입출력 예
        int N = 5;                                   // 전체 스테이지의 개수
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};     // 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호
        //int N = 4;
        //int[] stages = {4, 4, 4, 4, 4};

        FailureRate failureRate = new FailureRate();
        int[] result = failureRate.solution3(N, stages);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution1(int N, int[] stages) {
        int[] answer = new int[N];             // 실패율이 높은 스테이지부터 내림차순으로 정렬할 배열
        int[] fail_players = new int[N];       // 같은 스테이지에 있는 플레이어 수를 담을 배열
        double[] fail_rate = new double[N];    // 실패율을 담을 배열

        // stages 배열 내의 중복되는 숫자들의 갯수 (스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i + 1) {
                    fail_players[i]++;
                }
            }
        }

        // System.out.println(Arrays.toString(fail_players));
        // [1, 3, 2, 1, 0]

        // 분모 = 스테이지에 도달한 플레이어 수
        int denominator = stages.length;

        for (int i = 0; i < fail_players.length; i++) {
            // 분자 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
            int numerator = fail_players[i];

            // doniminator(분모)가 0이 될 경우를 검증하는 조건문을 넣어 배열의 값이 NaN가 되는 상황을 방지한다.
            if (denominator == 0) {
                fail_rate[i] = 0;
            } else {
                fail_rate[i] = (double) numerator / denominator;
            }

            // 스테이지가 올라가면서 도달하지 못한 플레이어는 분모에서 제외해줘야한다.
            denominator -= fail_players[i];
        }

        /*
            selection sort (선택정렬)
            배열 탐색에서 가장 작은 원소의 '위치'를 찾고, 그 위치와 배열의 가장 첫 번째 원소부터 차례로 바꿔주는 방식
         */
        double max = 0;
        int num = 1;
        for (int i = 0; i < fail_rate.length; i++) {
            max = fail_rate[0];
            num = 1;
            for (int j = 0; j < fail_rate.length; j++) {
                if (fail_rate[j] > max) {
                    max = fail_rate[j];
                    num = j + 1;
                }
            }
            fail_rate[num - 1] = -1;
            answer[i] = num;
        }

        return answer;
    }

    public int[] solution2(int N, int[] stages) {

        int[] answer = new int[N];
        double[] players = new double[N+1];      // 같은 스테이지에 머물러 있는 플레이어를 담을 배열

        // 인덱스 -> 스테이지번호
        for(int i : stages){
            if(i == N+1){
                continue;
            }
            players[i]++;
        }

        // System.out.println(Arrays.toString(players));
        // [0.0, 1.0, 3.0, 2.0, 1.0, 0.0]

        // 실패율을 계산해 담을 List 생성
        ArrayList<Double> fail = new ArrayList<Double>();

        // 스테이지에 도달한 플레이어 수
        double num = stages.length;
        // 다음 스테이지로 올라갈때 줄어드는 플레이어의 수를 계산하기 위해 사용
        double temp = 0;

        // 실패율을 구한 후 다시 players 배열에 담고, fail 리스트에도 담아준다.
        for(int i=1; i<players.length; i++){
            temp = players[i];
            // 도달한 사용자 수가 0 일때, 실패율도 0
            if(num == 0) {
                players[i]=0;
            }else {
                players[i] = players[i]/num;
                num = num - temp;
            }
            fail.add(players[i]);
        }

        System.out.println(Arrays.toString(players));
        // [0.0, 0.125, 0.42857142857142855, 0.5, 0.5, 0.0]

        Iterator iterator = fail.iterator(); // Iterator 사용
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // 0.5 | 0.5 | 0.42857142857142855 | 0.125 | 0.0

        /*
            Collections.sort(List이름, Comparator): Comparator 인터페이스를 구현한 인스턴스에서 지정한대로 정렬한다.
            Collections.reverseOrder() : 내림차순 정렬
         */

        // fail 리스트를 내림차순으로 정렬해준다.
        Collections.sort(fail,Collections.reverseOrder());

        // 정렬된 fail값과 player값을 비교해서 player의 인덱스번호(스테이지번호)를 가져와 answer배열에 담는다.
        for(int i=0; i<fail.size(); i++){
            for(int j=1; j<players.length; j++){
                if(fail.get(i) == players[j]){
                    answer[i] = j;
                    players[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }

    public int[] solution3(int N, int[] stages) {

        // HashMap<자료형, 자료형> map = new HashMap<>();
        Map<Integer, Double> map = new HashMap<>();

        // stages 1부터 N까지
        for (int i = 1; i <= N; i++) {
            double total = 0;   // 스테이지에 도달한 플레이어 수
            double fail = 0;    // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수

            for (int j = 0; j < stages.length; j++) {
                if(i <= stages[j]) total++;
                if(i == stages[j]) fail++;
            }
            if(total == 0 && fail == 0) total = 1;

            // map.put(key, value);
            map.put(i, fail/total);
        }

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            double max = -1;
            int stage = 0;

            // map.keySet() : map의 key를 가져올 때 사용
            for (int key : map.keySet()){
                if(max < map.get(key)){
                    max = map.get(key);
                    stage = key;
                }
            }
            answer[i] = stage;

            // ansewer에 담은 stage는 제거
            map.remove(stage);
        }

        return answer;
    }

    public int[] solution4(int N, int[] stages) {
        int[] stage_status = new int[N+1];
        for(int num : stages) {
            if(num == N+1) continue;
            stage_status[num]++;
        }

        Map<Integer, Double> map = new HashMap<>();
        int total = stages.length;
        for(int i=1; i<N+1; i++) {
            if(total==0) {
                map.put(i, (double)0);
            }else {
                double rate = (double)stage_status[i]/(double)total;
                total-=stage_status[i];
                map.put(i, rate);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return Double.compare(map.get(o2), map.get(o1));
            }
        });

        // List -> Array 변환
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

}
