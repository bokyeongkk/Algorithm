package programmers.cordingtest.level2.day9;

import java.util.*;

public class TruckPassingBridge {
    /*
        다리를 지나는 트럭

        # 문제 설명
        트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
        모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
        다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
        단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.

        예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
        무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

        ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        | 경과 시간 | 다리를 지난 트럭 | 다리를 건너는 트럭 | 대기 트럭 |
        ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        |    0    |       []       |       []        |[7,4,5,6]|
        |   1~2   |       []       |       [7]       | [4,5,6] |
        |    3    |       [7]      |       [4]       |  [5,6]  |
        |    4    |       [7]      |      [4,5]      |   [6]   |
        |    5    |      [7,4]     |       [5]       |   [6]   |
        |   6~7   |     [7,4,5]    |       [6]       |   []    |
        |    8    |    [7,4,5,6]   |       []        |   []    |
        ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

        따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
        solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length,
        다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
        이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

        # 제한 조건
        · bridge_length는 1 이상 10,000 이하입니다.
        · weight는 1 이상 10,000 이하입니다.
        · truck_weights의 길이는 1 이상 10,000 이하입니다.
        · 모든 트럭의 무게는 1 이상 weight 이하입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int bridge_length = 2;                  // 다리에 올라갈 수 있는 트럭 수
        int weight = 10;                        // 다리가 견딜 수 있는 무게
        int[] truck_weights = {7,4,5,6};        // 트럭 별 무게

        //int bridge_length = 100;
        //int weight = 100;
        //int[] truck_weights = {10};

        //int bridge_length = 100;
        //int weight = 100;
        //int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        TruckPassingBridge truckPassingBridge = new TruckPassingBridge();
        int result = truckPassingBridge.solution2(bridge_length, weight, truck_weights);
        System.out.println("모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지: "+result+"초");
    }

    /*
        Stack(스택)과 큐(Queue)

        Stack : LIFO(Last In First Out) 후입선출 구조, 마지막에 저장된 것을 제일 먼저 꺼냅니다.
        Queue : FIFO(First IN First Out) 선입선출 구조, 제일 먼저 저장한 것을 제일 먼저 꺼냅니다.

        queue.add(Object o) : 지정된 객체를 Queue에 추가한다. ( 저장공간이 부족하면 IllegalStateException 발생 )
        queue.remove() :Queue에서 객체를 꺼내 반환한다.( 비었으면 NoSuchElementException 발생 )
        queue.element() : 삭제없이 요소를 읽어 온다.( 비었으면 NoSuchElementException 발생 )

        queue.offer(Object o) : Queue에 객체를 저장
        queue.poll() :Queue에서 객체를 꺼내서 반환하고 저장된건 삭제된다. (비었으면 null)
        queue.peek() : 삭제없이 요소를 읽어 온다. (비었으면 null)
     */

    public int solution1(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> bridge = new LinkedList<>();
        // 비어있는 다리의 공간을 0으로 채운다.
        for(int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }

        // 다리에 있는 현재 트럭의 무게
        int currentWeight = 0;
        int index = 0;

        // 트럭이 더이상 남아있지 않을 때 탈출해주기 위해 조건을 만들었다.
        while(index < truck_weights.length){
            // 현재 다리에 있는 트럭 무게에서 곧 나갈 트럭의 무게를 빼준다.
            currentWeight -= bridge.poll();
            // 새 트럭이 들어올 것이므로 1초를 추가한다.
            answer++;
            // 현재 다리에 있는 트럭 무게와 곧 들어올 트럭 무게의 합과 다리의 하중을 비교
            if(currentWeight + truck_weights[index] <= weight){
                // 무게를 버틴다면 다리에 트럭을 추가한다.
                bridge.offer(truck_weights[index]);
                // 현재 다리에 있는 트럭 무게에도 새 트럭 무게를 더해준다.
                // 그리고 다음 트럭을 지정하기 위해 후위 연산자를 써주어 index를 증가시켰다.
                currentWeight += truck_weights[index++];
            } else{
                // 버티지 못한다면 0을 추가한다.
                bridge.offer(0);
            }
        }
        // 처음 설정한 0으로 채워진 다리가 전부 치환되면 결국 처음 다리 길이와 같으므로
        // 트럭이 지나간 시간 + 다리 길이
        return answer + bridge_length;
    }

    public int solution2(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;             // 트럭이 지나간 시간
        int bridge_weight = 0;      // 다리 위 트럭의 무게

        Queue<Integer> bridge = new LinkedList<Integer>();

        for(int truck : truck_weights){
            while(true){
                // 다리를 건너는 트럭
                //System.out.println("bridge: "+bridge);

                // 다리에 트럭 없는 경우
                if(bridge.isEmpty()){
                    bridge.add(truck);
                    bridge_weight += truck;
                    // 1초 추가
                    answer++;
                    break;
                }
                // 다리가 꽉 찬 경우
                else if(bridge.size()==bridge_length){
                    // 값을 반환 저장된 건 삭제한다. -> 다리를 지난 트럭
                    bridge_weight -= bridge.poll();
                }
                else{
                    // 다리에 트럭을 실을 수 있을 경우
                    if(bridge_weight+truck<=weight){
                        bridge.add(truck);
                        bridge_weight+=truck;
                        answer++;
                        break;
                    }
                    // 다리에 트럭 무게가 초과인 경우
                    else{
                        // 가상으로 0을 채워준다.
                        bridge.add(0);
                        // 1초 추가
                        answer++;
                    }
                }
            }
        }

        //마지막 트럭이 빠져나오는 시간
        answer += bridge_length;

        return answer;
    }
}
