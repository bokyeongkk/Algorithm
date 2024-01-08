package programmers.cordingtest.level2.day5;

import java.util.*;

public class RemoveInPairs {
    /*
        짝지어 제거하기

        # 문제 설명
        짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다.
        먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다.
        그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다.
        이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다.
        문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요.
        성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.

        예를 들어, 문자열 S = baabaa 라면
        b aa baa → bb aa → aa →
        의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.

        # 제한사항
        · 문자열의 길이 : 1,000,000이하의 자연수
        · 문자열은 모두 소문자로 이루어져 있습니다.

        # 입출력 예 2
        문자열이 남아있지만 짝지어 제거할 수 있는 문자열이 더 이상 존재하지 않기 때문에 0을 반환합니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        String s = "baabaa";
        //String s = "cdcd";

        RemoveInPairs removeInPairs = new RemoveInPairs();
        int result = removeInPairs.solution(s);
        System.out.println("짝지어 제거하기를 성공적으로 수행할 수 있는지: "+result);
    }

    /*
        자바에서 짝이라는 단어는 'stack'을 의마하는 경우가 많다.
        peek() : 스택의 최상단에 있는 원소 값을 반환한다. (단, 원소를 제거하지는 않는다.)
        pop() : 스택의 최상단에 있는 원소를 제거하고, 그 값을 반환한다.
        push(E item) : 스택의 상단에 item 원소를 삽입한다.
     */

    public int solution(String s)
    {
        int answer = -1;

        char[] arrChar = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i=0;i<arrChar.length;i++) {
            char c = arrChar[i];
            // 스택이 비어있다면 현재 문자는 반복될 일이 없으므로 push 한다.
            if (stack.isEmpty()) stack.push(c);
            // 스택이 비어있지 않다면
            else {
                // 스택 확인 (peek) - 만약 현재 문자와 같다면 반복이므로 스택에서 pop하고 현재 문자도 스택에 넣지 않는다.
                if (stack.peek() == c) {
                    stack.pop();
                // 스택의 현재 문자와 다르다면 반복이 아니므로 push 한다.
                } else {
                    stack.push(c);
                }
            }
        }

        // 스택에 남아있는 값들은 반복되지 않는 값이 된다. ->  즉, 비어있다면 모두 짝지어 반복된 것
        return stack.isEmpty() ? 1 : 0;
    }
}
