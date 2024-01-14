package programmers.cordingtest.level2.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FuncDevelop {
    /*
        기능개발

        # 문제 설명
        프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

        또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
        이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

        먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
        각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
        각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

        # 제한 사항
        · 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
        · 작업 진도는 100 미만의 자연수입니다.
        · 작업 속도는 100 이하의 자연수입니다.
        · 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
          예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.

        # 입출력 예 1
        첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
        두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다.
        하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
        세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
        따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다. => [2, 1]

        # 입출력 예 2
        모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는 각각 5일, 10일, 1일, 1일, 20일, 1일입니다.
        어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.
        따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다. => [1, 3, 2]
     */

    public static void main(String[] args) {
        // 입출력 예
        int[] progresses = {93, 30, 55};    // 먼저 배포되어야 하는 순서대로 작업의 진도
        int[] speeds = {1, 30, 5};          // 각 작업의 개발 속도

        //int[] progresses = {95, 90, 99, 99, 80, 99};
        //int[] speeds = {1, 1, 1, 1, 1, 1};

        FuncDevelop funcDevelop = new FuncDevelop();
        int[] result = funcDevelop.solution2(progresses, speeds);
        System.out.println("각 배포마다 몇 개의 기능이 배포되는지: ");
        System.out.println(Arrays.toString(result));
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

        Math 클래스
        ceil(올림), floor(내림), round(반올림)
     */

    public int[] solution1(int[] progresses, int[] speeds) {

        // 기능의 갯수를 담을 ArrayList 선언
        // progress가 100%를 넘는 최소 일수를 담을 Queue 선언
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i=0; i<progresses.length; i++){
            // progresses의 길이만큼 for문을 돌면서 ,
            // progress가 100% 넘기 위한 최소 일수 계산 후 queue에 add 메소드로 넣기
            queue.add((int)Math.ceil((100.0-progresses[i])/speeds[i]));
        }

        //System.out.println(queue);
        //[7(일), 3(일), 9(일)]

        while(!queue.isEmpty()){
            // queue에서 꺼낸 값은 삭제되고 int형 변수 minDays에 저장한다.
            int minDays = queue.poll();

            // 해당 일자에 배포되는 총 기능의 수를 담기 위한 변수, int count를 1로 선언 및 초기화
            int count = 1;

            // queue가 비어있지 않고,
            // queue.peek()의 값이 이전에 poll()을 통해 얻은 minDays 보다 작은 동안 count 값을 추가한다.
            while(!queue.isEmpty() && queue.peek() <= minDays){
                queue.poll();
                count++;
            }

            // count의 값을 answer 배열에 추가
            list.add(count);
        }

        // Integer ArrayList -> int 배열로 변환
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).intValue();
        }

        return answer;

    }

    public int[] solution2(int[] progresses, int[] speeds) {
        // 제한사항에 따라 작업 진도 및 작업 속도는 100 이하의 자연수이다.
        int[] dayOfend = new int[100];

        // day가 -1인 이유는 dayOfend 배열의 0번째 index가 1일을 의미하기 때문이다.
        int day = -1;

        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }

        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}
