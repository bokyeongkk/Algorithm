package programmers.cordingtest.level1.day21;

import java.util.*;

public class MakingHamburger {
    /*
        햄버거 만들기

        # 문제 설명
        햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다.
        함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고,
        상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다.

        상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다.
        상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며,
        재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.

        예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때,
        상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고,
        아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다.
        즉, 2개의 햄버거를 포장하게 됩니다.

        상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.

        # 제한사항
        1 ≤ ingredient의 길이 ≤ 1,000,000
        ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.

        # 입출력 예 1
        문제 예시와 같습니다.

        # 입출력 예 2
        상수가 포장할 수 있는 햄버거가 없습니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        // 상수에게 전해지는 재료의 정보 (1:빵, 2:야채, 3:고기)
        //int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};

        MakingHamburger makingHamburger = new MakingHamburger();
        int result = makingHamburger.solution2(ingredient);
        System.out.println("상수가 포장하는 햄버거의 개수: "+result);
    }

    public int solution1(int[] ingredient) {
        int answer = 0;

        // 배열 -> List로 변경 (가변길이 사용)
        List<Integer> list = new ArrayList<>();

        for(int i :ingredient) {
            list.add(i);

            // 재료가 4개가 되면
            while(list.size() >= 4) {
                int n = list.size();

                // 뒤에서부터 1,3,2,1 순인지 확인한다.
                if(!(list.get(n-1) == 1
                        && list.get(n-2)==3
                        && list.get(n-3)==2
                        && list.get(n-4)==1)) break;

                // 뒤에서부터 값을 배열에서 삭제한다.
                for(int j=0; j<4; j++) {
                    // remove(int index) : remove() 메소드의 파라미터로 전달한 해당 index의 값 삭제
                    list.remove(list.size() -1);
                }

                answer++;
            }
        }

        return answer;
    }

    /*
        [Stack이란?]
        자료 구조 중 하나인 Stack의 사전적 정의는 '쌓다', '더미' 이다.
        Stack의 가장 큰 특징은 나중에 들어간 것이 먼저 나오는 (Last In First Out)의 형태를 띈다는 것이다.
     */

    public int solution2(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int n : ingredient) {
            stack.push(n);

            if (stack.size() >= 4) {
                int size = stack.size();
                if(stack.get(size - 1) == 1
                        && stack.get(size - 2) == 3
                        && stack.get(size - 3) == 2
                        && stack.get(size - 4) == 1) {
                    answer++;
                    // pop(): stack에서 가장 위쪽에 있는 원소의 값 제거
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }

        return answer;
    }
}
