package programmers.cordingtest.level2.day9;

import java.util.*;

public class StockDevelop {
    /*
        주식가격

        # 문제 설명
        초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
        가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

        # 제한사항
        · prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
        · prices의 길이는 2 이상 100,000 이하입니다.

        # 입출력 예 설명
        1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
        2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
        3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
        4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
        5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        int[] prices = {1, 2, 3, 2, 3}; // 초 단위로 기록된 주식가격

        StockDevelop stockDevelop = new StockDevelop();
        int[] result = stockDevelop.solution2(prices);
        System.out.println("가격이 떨어지지 않은 기간은 몇 초인지: ");
        System.out.println(Arrays.toString(result));
    }

    public int[] solution1(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++; // 뒤에 있는 값들 보다 작거나 같을 때 인덱스 값 하나씩 추가
                if (prices[i] > prices[j]) { // 크면 다음 인데스 비교
                    break;
                }
            }
        }
        return answer;
    }

    /*
        Stack(스택)과 큐(Queue)

        Stack : LIFO(Last In First Out) 후입선출 구조, 마지막에 저장된 것을 제일 먼저 꺼냅니다.
        Queue : FIFO(First IN First Out) 선입선출 구조, 제일 먼저 저장한 것을 제일 먼저 꺼냅니다.

        stack.empty() : Stack이 비어있는지 확인한다.
        stack.peek() : Stack의 맨 위에 저장된 객체를 반환한다.
                       pop()과 달리 Stack에서 객체를 꺼내지 않는다. ( 비었다면 EmptyStackException 발생 )
        stack.pop() : Stack의 맨 위에 저장된 객체를 꺼낸다.( 비었다면 EmptyStackException발생 )
        stack.push(Object item) : Stack에 객체(item)을 저장한다.
        stack.search(Object o) : Stack에 주어진 객체(o)를 찾아서 그 위치를 반환한다.
     */

    public int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        // for문 돌면서 주식이 떨어졌을 경우 answer에 넣고, 증가하거나 동일할 경우 stack에 넣는다.
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        // stack에 있는 값은 끝까지 주식 가격이 떨어지지 않은 경우이므로,
        // stack이 비어있을 때까지 prices.length - index -1을 넣어준다.
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        return answer;
    }
}
