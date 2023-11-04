package programmers.cordingtest.level1.day13;

import java.util.*;

public class PracticeTest {
    /*
        모의고사

        # 문제설명
        수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
        수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

        1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
        가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

        # 제한조건
        - 시험은 최대 10,000 문제로 구성되어있습니다.
        - 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
        - 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

        # 입출력예 1
        수포자 1은 모든 문제를 맞혔습니다.
        수포자 2는 모든 문제를 틀렸습니다.
        수포자 3은 모든 문제를 틀렸습니다.
        따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

        # 입출력예 2
        모든 사람이 2문제씩을 맞췄습니다.
     */

    public static void main(String[] args) {
        // 입력 예
        //int[] answers = {1,2,3,4,5};
        int[] answers = {1,3,2,4,2};

        PracticeTest practiceTest = new PracticeTest();
        int[] result = practiceTest.solution1(answers);
        System.out.println(Arrays.toString(result));

        // 출력 예
        // [1]
        // [1,2,3]
    }

    public int[] solution1(int[] answers) {
        int[] man1 = {1, 2, 3, 4, 5};
        int[] man2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] man3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int score1 = 0;
        int score2 = 0;
        int score3 = 0;

        // 수포자들의 정답 체크
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == man1[i]) {
                score1++;
            }
            if(answers[i] == man2[i]) {
                score2++;
            }
            if(answers[i] == man3[i]) {
                score3++;
            }
        }

        int[] score = {score1, score2, score3};
        int max = 0;

        // 배열에서 최댓값 찾기
        for(int i=1 ; i<score.length ; i++) {
            if(score[i]>max) {
                max = score[i];
            }
        }
        System.out.println("max : "+max);

        // 최댓값과 일치하는 수포자
        List<Integer> scores = new ArrayList<Integer>();
        for(int i=0; i<score.length; i++) {
            if(max == score[i]) scores.add(i+1);
        }

        // List -> 배열에 옮겨 담기.
        int[] answer = new int[scores.size()];
        for(int i=0; i<scores.size(); i++){
            answer[i] = scores.get(i);
        }

        return answer;
    }


    public int[] solution2(int[] answers) {
        int[] first = {1,2,3,4,5};                  // 수포자1 (5개 반복)
        int[] second = {2,1,2,3,2,4,2,5};           // 수포자2 (8개 반복)
        int[] third = {3,3,1,1,2,2,4,4,5,5};        // 수포자3 (10개 반복)
        int[] score = {0,0,0};                      // 각 수포자들의 점수

        // 수포자들의 점수 계산
        for(int i=0; i<answers.length; i++) {
            // 5개를 기준으로 답이 반복되므로 first[a]의 값은 first[a%5]의 값과 같다.
            if(answers[i] == first[i%5]) score[0]++;
            if(answers[i] == second[i%8]) score[1]++;
            if(answers[i] == third[i%10]) score[2]++;
        }

        // Math.max() 메소드를 이중으로 사용하여 배열 중 최댓값을 찾는다.
        // Math.max(int a , int b) : 두 인자 값 중 큰 값을 리턴
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        // 최대 점수를 가진 수포자 List 생성 (List는 크기를 할당할 필요가 없다.)
        List<Integer> scores = new ArrayList<Integer>();
        for(int i=0; i<score.length; i++) {
            if(max == score[i]) scores.add(i+1);
        }

        // ArrayList → Array 형변환
        // 리스트에서 int 값을 꺼내서 배열로 저장해야 한다. 이 때 사용하는 것이 stream이다.
        // .stream(): Stream<Integer>을 반환한다.
        // .mapToInt(Integer::intValue): Integer의 intValue() 메서드를 참조해서 값타입인 int로 언박싱한다.
        // toArray(): IntStream의 원소를 배열로 변환한다.
        int[] answer = scores.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
