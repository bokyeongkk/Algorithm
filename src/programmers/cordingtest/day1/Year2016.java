package programmers.cordingtest.day1;

import java.time.*;

public class Year2016 {

    /*
        2016년

        # 문제설명
        2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
        두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
        요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다.
        예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.

        # 제한조건
        - 2016년은 윤년입니다.
        - 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
     */

    public static void main(String[] args) {
        // 입출력 예
        int a = 5;
        int b = 24;
        Year2016 year2016 = new Year2016();
        String result = year2016.solution1(a, b);
        System.out.println(result);
    }

    public String solution1(int a, int b) {
        // 2016년 1월 1일은 금요일이므로, 금요일로 시작하는 배열을 작성한다.
        String[] day = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        // 2016년은 윤년이므로, 2월의 마지막 일자는 29일이다.
        int[] lastDate = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int sumDate = 0;
        for(int i = 0; i < a-1; i++) {
            sumDate += lastDate[i];
        }
        // 입력받은 월의 전월까지의 일수를 구한다. =>(31+29+31+30=121)

        sumDate += b-1;
        String answer = day[sumDate % 7];
        return answer;
    }

    public String solution2(int a, int b) {
        // LocalDate 인스턴스 생성
        LocalDate localDate = LocalDate.of(2016, a, b);

        // LocalDate에서 제공하는 메서드
        int year = localDate.getYear();                     // 연도(2016)
        Month monthInstance = localDate.getMonth();         // 월(May)
        int month = monthInstance.getValue();               // 월(5)
        int date = localDate.getDayOfMonth();               // 일(24)
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();     // 요일(TuesDay)

        // Object 클래스 : 모든 클래스의 가장 최상위 클래스
        // 자바 컴파일러는 일반 클래스를 Object 하위 클래스로 자동 설정하게 되어 있다.
        // toString() 메서드 : 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드

        // java.lang.String 클래스 (java.lang 패키지에 포함되어 제공)
        // substring(int beginIndex, int endIndex)
        String answer = dayOfWeek.toString().substring(0, 3);
        return answer;
    }

    public String solution3(int a, int b) {
        return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
    }
}
