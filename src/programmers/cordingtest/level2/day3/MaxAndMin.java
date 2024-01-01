package programmers.cordingtest.level2.day3;

import java.util.*;

public class MaxAndMin {
    /*
        최댓값과 최솟값

        # 문제 설명
        문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
        str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
        예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

        제한 조건
        · s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
     */

    public static void main(String[] args) {
        // 입출력 예
        String s = "1 2 3 4";
        //String s = "-1 -2 -3 -4";
        //String s = "-1 -1";

        MaxAndMin maxAndMin = new MaxAndMin();
        String result = maxAndMin.solution1(s);
        System.out.println("(최소값)(최대값) 형태의 문자열 반환: "+result);
    }

    public String solution1(String s) {
        // 문자열 배열로 저장
        String[] strArr = s.split(" ");

        int[] intArr = new int[strArr.length];
        for(int i=0; i<strArr.length; i++){
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        int min, max, n;
        min = max = Integer.parseInt(strArr[0]);

        for (int i = 1; i < strArr.length; i++) {
            n = Integer.parseInt(strArr[i]);
            if(min > n) min = n;
            if(max < n) max = n;
        }

        String answer = min + " " + max;
        return answer;
    }

    /*
        Collections 함수를 이용하여 최대값 최솟값을 구할 수 있다.
     */
    public String solution2(String s) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String[] str = s.split(" ");

        for(int i=0; i<str.length; i++) {
            arr.add(Integer.parseInt(str[i]));
        }

        String answer = Collections.min(arr) + " " + Collections.max(arr);
        return answer;
    }
}
