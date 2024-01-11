package programmers.cordingtest.level2.day8;

import java.util.*;

public class Cash {
    /*
        캐시

        # 문제 설명
        지도개발팀에서 근무하는 제이지는 지도에서 도시 이름을 검색하면 해당 도시와 관련된 맛집 게시물들을
        데이터베이스에서 읽어 보여주는 서비스를 개발하고 있다.
        이 프로그램의 테스팅 업무를 담당하고 있는 어피치는 서비스를 오픈하기 전 각 로직에 대한 성능 측정을 수행하였는데,
        제이지가 작성한 부분 중 데이터베이스에서 게시물을 가져오는 부분의 실행시간이 너무 오래 걸린다는 것을 알게 되었다.
        어피치는 제이지에게 해당 로직을 개선하라고 닦달하기 시작하였고,
        제이지는 DB 캐시를 적용하여 성능 개선을 시도하고 있지만 캐시 크기를 얼마로 해야 효율적인지 몰라 난감한 상황이다.

        어피치에게 시달리는 제이지를 도와, DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램을 작성하시오.

        # 입력 형식
        · 캐시 크기(cacheSize)와 도시이름 배열(cities)을 입력받는다.
        · cacheSize는 정수이며, 범위는 0 ≦ cacheSize ≦ 30 이다.
        · cities는 도시 이름으로 이뤄진 문자열 배열로, 최대 도시 수는 100,000개이다.
        · 각 도시 이름은 공백, 숫자, 특수문자 등이 없는 영문자로 구성되며, 대소문자 구분을 하지 않는다.
          도시 이름은 최대 20자로 이루어져 있다.

        # 출력 형식
        · 입력된 도시이름 배열을 순서대로 처리할 때, "총 실행시간"을 출력한다.

        # 조건
        · 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
        · cache hit일 경우 실행시간은 1이다.
        · cache miss일 경우 실행시간은 5이다.
     */

    public static void main(String[] args) {
        // 입출력 예
        //int cashSize = 3;
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        //int cashSize = 3;
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        //int cashSize = 2;
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        //int cashSize = 5;
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        //int cashSize = 2;
        //String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};

        int cashSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        Cash cash = new Cash();
        int result = cash.solution(cashSize, cities);
        System.out.println("캐시 크기에 따른 실행시간 측정: "+result);
    }

    /*
        캐시 교체 알고리즘
        LRU(Least Recently Used)
        메모리 상에서 가장 최근에 사용된 적이 없는 캐시의 메모리부터 대체하며 새로운 데이터로 갱신

        LFU(Least Frequently Used)
        가장 적게 참조한 페이지를 캐시에서 교체

        *Cache Hit 이란?
        CPU가 참조하고자 하는 메모리가 캐시에 존재하고 있을 경우, Cache Hit이라고 한다.

        * Cache Miss란?
        CPU가 참조하고자 하는 메모리가 캐시에 존재하지 않을 떄는 Cache Miss라고 함.
     */

    static final int CACHE_HIT = 1;
    static final int CACHE_MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        // cashSize가 0인 경우도 고려해야 한다.
        // 모든 도시를 처음부터 읽어야 하므로 cities.length * 5를 반환한다.
        if(cacheSize == 0) {
            return cities.length * 5;
        }

        // Java에서는 LinkedList가 Queue의 구현체이므로 LinkedList를 사용한다.
        //Queue<String> cache = new LinkedList<>();
        LinkedList<String> cache = new LinkedList<>();

        for(int i = 0 ; i < cities.length ; ++i){
            // 각 도시들은 대소문자 구분 없이 저장되어있기 때문에 toUpperCase() 메서드를 통해 대문자로 변환한다.
            String city = cities[i].toUpperCase();

            // [ cache hit ]
            // city에 대하여 cache.remove()를 수행한 결과가 true인 경우,
            // 도시가 캐시에 존재했던 것으로 캐시에 다시 city를 추가하고 실행시간(answer)을 1 증가시킨다.
            if(cache.remove(city)){
                cache.addFirst(city);
                answer += CACHE_HIT;
            // [ cache miss ]
            } else {
                int currentSize = cache.size();
                // 캐시가 가득 찼는지 검사한다.
                if(currentSize == cacheSize){
                    // 캐시의 맨 앞의 요소 제거
                    cache.pollLast();
                }
                // 캐시에 city를 추가한다.
                cache.addFirst(city);
                // 실행시간(answer)을 5 증가시킨다.
                answer += CACHE_MISS;
            }
        }
        return answer;
    }
}
