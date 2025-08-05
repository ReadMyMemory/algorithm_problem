package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_16918 {
    static int R, C, N;
    static char[][] grid;
    static int[][] bombTime;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grid = new char[R][C];

        // 초기 상태 입력
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        // N이 0 또는 1일 때는 초기 상태 그대로
        if (N == 0 || N == 1) {
            printGrid();
            return;
        }

        // N이 짝수일 때는 모든 칸이 폭탄
        if (N % 2 == 0) {
            printAllBombs();
            return;
        }

        // N이 3 이상 홀수일 때
        // 시뮬레이션을 통해 상태 계산
        char[][] state3 = simulate(grid, 3);

        if (N % 4 == 3) {
            // N = 3, 7, 11, ...
            grid = state3;
        } else {
            // N = 5, 9, 13, ...
            // state3에서 한 번 더 시뮬레이션
            grid = simulate(state3, 3);
        }

        printGrid();
    }

    // 3초 시뮬레이션 함수
    static char[][] simulate(char[][] initial, int time) {
        char[][] current = new char[R][C];
        bombTime = new int[R][C];

        // 초기 상태 복사 및 폭탄 시간 설정
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                current[i][j] = initial[i][j];
                if (initial[i][j] == 'O') {
                    bombTime[i][j] = 3; // 3초 후 폭발
                }
            }
        }

        // 1초: 아무것도 하지 않음

        // 2초: 빈 칸에 폭탄 설치
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (current[i][j] == '.') {
                    current[i][j] = 'O';
                    bombTime[i][j] = 5; // 2초에 설치, 5초에 폭발
                }
            }
        }

        // 3초: 초기 폭탄들이 폭발
        boolean[][] exploded = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bombTime[i][j] == 3) {
                    exploded[i][j] = true;
                }
            }
        }

        // 폭발 처리
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (exploded[i][j]) {
                    current[i][j] = '.';
                    // 인접한 칸도 파괴
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
                            current[ni][nj] = '.';
                        }
                    }
                }
            }
        }

        return current;
    }

    static void printGrid() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(grid[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void printAllBombs() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append('O');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}