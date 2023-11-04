package programmers.cordingtest.level1.day13;

import java.util.*;

public class Sweatsuit {
    /*
        체육복

        # 문제설명
        점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.
        다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
        학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
        예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
        체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

        전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
        체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

        # 제한사항
        - 전체 학생의 수는 2명 이상 30명 이하입니다.
        - 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
        - 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
        - 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
        - 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
          이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int n = 5;                        // 전체 학생의 수 n
        int[] lost = {2, 4};              // 체육복을 도난당한 학생들의 번호가 담긴 배열 lost
        int[] reserve = {1, 3, 5};        // 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve

        //int n = 5;
        //int[] lost = {2, 4};
        //int[] reserve = {3};

        //int n = 3;
        //int[] lost = {3};
        //int[] reserve = {1};

        Sweatsuit sweatsuit = new Sweatsuit();
        int result = sweatsuit.solution(n, lost, reserve);
        System.out.println(result);
    }


    public int solution(int n, int[] lost, int[] reserve) {
        // 체육수업을 들을 수 있는 학생의 최댓값을 구해야 한다.
        int answer = 0;

        // lost, reserve 배열 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 도난 당하지 않은 학생 수 (전체 학생 수 - 도난 당한 학생 수)
        answer += n-lost.length;

        // 여벌 체육복을 가져왔지만 도난 당한 경우 (다른 학생에게 체육복을 빌려줄 수 없다.)
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;           // 체육복이 있어 체육수업을 들을 수 있는 학생이므로 answer++

                    // *배열은 이미 선언해버린 시점에서 삭제가 안되기 때문에, 제외할 원소를 음수로 변형(-1) 시킨다.
                    lost[i] = -1;       // 다른 학생에게 체육복을 빌릴 필요가 없으므로 lost[i]에 -1 저장
                    reserve[j] = -1;    // 다른 학생에게 빌려줄 수 없으므로 reserve[i]에 -1 저장
                    break;
                }
            }
        }

        // 도난당했지만 체육복을 빌릴 수 있는 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                // 체육복은 앞뒤 번호 학생에게만 빌려줄 수 있다.
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++;               // 체육복을 빌렸다면 answer++
                    reserve[j] = -1;        // 체육복을 빌려줬으므로 reserve[j]에 -1 저장
                    break;
                }
            }
        }

        return answer;
    }
}
