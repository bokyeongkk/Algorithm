package programmers.cordingtest.level1.day14;

import java.util.*;

public class PressKeypad {
    /*
        키패드 누르기

        # 문제설명
        스마트폰 전화 키패드의 각 칸에 다음과 같이 숫자들이 적혀 있습니다.
        1   2   3
        4   5   6
        7   8   9
        *   0   #
        이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
        맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.
        엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
        왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
        오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
        가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
        만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.

        순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
        각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

        # 제한사항
        - numbers 배열의 크기는 1 이상 1,000 이하입니다.
        - numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
        - hand는 "left" 또는 "right" 입니다.
        - "left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
        - 왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
     */

    public static void main(String[] args) {
        // 입력 예
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};  // 순서대로 누를 번호가 담긴 배열
        String hand = "right";                              // 왼손잡이인지 오른손잡이인지를 나타내는 문자열

        //int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        //String hand = "left";

        //int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        //String hand = "right";

        PressKeypad pressKeypad = new PressKeypad();
        String result = pressKeypad.solution(numbers, hand);
        System.out.println(result);

        // 출력 예
        // LRLLLRLLRRL
        // LRLLRRLLLRR
        // LLRLLRLLRL
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";

        /*
              *    0    #
             (10) (11) (12)
         */
        // 맨처음 엄지손가락 위치
        int left = 10;
        int right = 12;

        for(int temp: numbers){
            if(temp==1||temp==4||temp==7){ // 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용
                answer+="L";
                left = temp;
            }else if(temp==3||temp==6||temp==9){ // 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용
                answer+="R";
                right = temp;
            }else {
                // 키패드 숫자 0은 위치 11로 조정
                if(temp==0) temp=11;

                // 줄마다 숫자가 3씩 차이나고 왼쪽 오른쪽으로는 1씩 차이나니까
                // 현재 위치에서 누를 위치까지의 거리를 3으로 나눈 몫과 3으로 나눈 나머지를 더해주면 된다.
                // Ex) 1번에서 8번을 누른다면 8-3=5 이고 (5/3)+(5%3) = 1+2 = 3이므로 거리는 3이 된다.

                // 위아래 거리 = (눌러야 할 숫자(n) - 현재 손가락 위치)  / 3
                // 좌우 거리 = (눌러야 할 숫자(n) - 현재 손가락 위치) % 3

                // Math.abs() : 주어진 숫자의 절대값을 반환
                int leftdist = (Math.abs(temp-left)/3) + (Math.abs(temp-left)%3);
                int rightdist = (Math.abs(temp-right)/3) + (Math.abs(temp-right)%3);

                if(leftdist<rightdist){
                    answer+="L";
                    left = temp;
                }else if(leftdist>rightdist){
                    answer+="R";
                    right = temp;
                }else{ // 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용
                    if(hand.equals("left")){
                        answer+="L";
                        left = temp;
                    }else{
                        answer+="R";
                        right = temp;
                    }
                }
            }
        }
        return answer;
    }


}
