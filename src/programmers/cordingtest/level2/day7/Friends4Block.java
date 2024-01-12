package programmers.cordingtest.level2.day7;

import java.util.*;

public class Friends4Block {
    /*
        프렌즈4블록

        # 문제 설명
        블라인드 공채를 통과한 신입 사원 라이언은 신규 게임 개발 업무를 맡게 되었다. 이번에 출시할 게임 제목은 "프렌즈4블록".
        같은 모양의 카카오프렌즈 블록이 2×2 형태로 4개가 붙어있을 경우 사라지면서 점수를 얻는 게임이다.

        만약 판이 위와 같이 주어질 경우, 라이언이 2×2로 배치된 7개 블록과 콘이 2×2로 배치된 4개 블록이 지워진다.
        같은 블록은 여러 2×2에 포함될 수 있으며, 지워지는 조건에 만족하는 2×2 모양이 여러 개 있다면 한꺼번에 지워진다.
        블록이 지워진 후에 위에 있는 블록이 아래로 떨어져 빈 공간을 채우게 된다.
        만약 빈 공간을 채운 후에 다시 2×2 형태로 같은 모양의 블록이 모이면 다시 지워지고 떨어지고를 반복하게 된다.

        위 초기 배치를 문자로 표시하면 아래와 같다.
        TTTANT
        RRFACC
        RRRFCC
        TRRRAA
        TTMMMF
        TMMTTJ
        각 문자는 라이언(R), 무지(M), 어피치(A), 프로도(F), 네오(N), 튜브(T), 제이지(J), 콘(C)을 의미한다
        입력으로 블록의 첫 배치가 주어졌을 때, 지워지는 블록은 모두 몇 개인지 판단하는 프로그램을 제작하라.

        # 입력 형식
        · 입력으로 판의 높이 m, 폭 n과 판의 배치 정보 board가 들어온다.
        · 2 ≦ n, m ≦ 30
        · board는 길이 n인 문자열 m개의 배열로 주어진다. 블록을 나타내는 문자는 대문자 A에서 Z가 사용된다.

        # 출력 형식
        · 입력으로 주어진 판 정보를 가지고 몇 개의 블록이 지워질지 출력하라.

        # 예제에 대한 설명
        · 입출력 예제 1의 경우,
          첫 번째에는 A 블록 6개가 지워지고, 두 번째에는 B 블록 4개와 C 블록 4개가 지워져, 모두 14개의 블록이 지워진다.
        · 입출력 예제 2는 본문 설명에 있는 그림을 옮긴 것이다.
          11개와 4개의 블록이 차례로 지워지며, 모두 15개의 블록이 지워진다.
     */

    public static void main(String[] args) {
        // 입출력 예
        //int m = 4;
        //int n = 5;
        //String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        Friends4Block friends4Block = new Friends4Block();
        int result = friends4Block.solution(m, n, board);
        System.out.println("지워지는 블록: "+result+"개");
    }

    static int M;
    static int N;
    static char[][] map;

    /**
     * 몇 개의 블록이 지워질지 출력
     *
     * @param m     판의 높이
     * @param n     판의 폭
     * @param board 판의 배치 정보
     * @return
     */
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        M = m;  // 판의 높이
        N = n;  // 판의 폭

        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            // 글자 수 만큼 배열로 지정해서 2차원 배열로 넣어준다.
            map[i] = board[i].toCharArray();
        }

        while (true) {
            int cnt = checkBlock();
            if (cnt > 0) {
                answer += cnt;
            } else {
                break;
            }
        }

        return answer;

    }

    /**
     * 4개 씩 모여 있는 블록인지 체크
     * @param m 폭
     * @param n 높이
     * @return
     */
    static int checkBlock() {
        boolean[][] chk = new boolean[M][N];

        for (int i = 0; i < M - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                char c = map[i][j];
                // c가 블록이 내려 가서 없는 경우에는 다음 문자로 넘어간다
                if (c == '0') {
                    continue;
                }
                // 2 * 2 의 범위가 현재의 index 문자와 같은 경우 체크
                if (c == map[i + 1][j + 1] && c == map[i][j + 1] && c == map[i + 1][j]) {
                    chk[i][j] = true;
                    chk[i + 1][j + 1] = true;
                    chk[i][j + 1] = true;
                    chk[i + 1][j] = true;
                }
            }
        }
        return fallblock(chk);
    }

    /**
     * 블록 떨어뜨리고 떨어뜨린 블록 맞추기
     * @param n 높이
     * @param m 폭
     * @param chk
     * @return
     */
    static int fallblock(boolean[][] chk) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            List<Character> temp = new ArrayList<>(); // 새로 갱신될 열
            for (int j = M - 1; j >= 0; j--) { // 가장 마지막 행부터 탐색한다
                if (chk[j][i] == true) {
                    cnt++;
                    continue;
                }
                temp.add(map[j][i]);
            }

            for (int j = M - 1, k = 0; j >= 0; j--, k++) {
                /**
                 * k : 현재의 행
                 * temp.size() : 블록이 떨어져 생긴 열의 리스트 개수
                 * 문자를 맵에 갱신 해준다
                 */
                if (k < temp.size())
                    map[j][i] = temp.get(k);
                else
                    map[j][i] = '0'; // 떨어져서 문자가 없다
            }
        }
        return cnt;
    }

}
