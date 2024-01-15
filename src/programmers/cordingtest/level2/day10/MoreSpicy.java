package programmers.cordingtest.level2.day10;

import java.util.*;

public class MoreSpicy {
    /*
        더 맵게

        # 문제 설명
        매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
        모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을
        아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.

        섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

        Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
        Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
        모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

        # 제한 사항
        · scoville의 길이는 2 이상 1,000,000 이하입니다.
        · K는 0 이상 1,000,000,000 이하입니다.
        · scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
        · 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.

        # 입출력 예 설명
        1. 스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
           새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
           가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]

        2. 스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
           새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
           가진 음식의 스코빌 지수 = [13, 9, 10, 12]

        모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int[] scoville = {1, 2, 3, 9, 10, 12};  // 음식의 스코빌 지수
        int K = 2;                              // 원하는 스코빌 지수

        MoreSpicy moreSpicy = new MoreSpicy();
        int result = moreSpicy.solution(scoville, K);
        System.out.println("모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수: "+result);
    }

    /*
        Heap (using array)
        최솟값 또는 최댓값을 빠르게 찾아내기 위해 완전이진트리 형태로 만들어진 자료구조
     */

    public int solution(int[] scoville, int K) {
        int answer = 0;

        // 힙을 선언 후 scoville 배열의 원소를 넣어준다.
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int i=0; i<scoville.length; i++) {
            heap.add(scoville[i]);
        }

        // heap에서 제일 작은 값(minHeap.peek())이 K보다 작을 때 while문을 반복한다.
        while(heap.peek()<K){
            int min1=heap.poll();
            int min2=heap.poll();

            // 작은 값 두 개를 꺼내 스코빌 지수를 계산한 후 힙에 넣고 answer값을 1 증가시킨다.
            int scov = min1+min2*2;
            heap.add(scov);
            answer++;

            // 제일 작은 값이 K 이상이면 break;
            if(heap.peek()>=K) break;

            // 마지막수가 K보다 작고 heap의 크기가 1일 때 answer=1 반환
            if(heap.size()==1&&heap.peek()<K) {
                answer=-1; break;
            }
        }


        return answer;
    }
}
