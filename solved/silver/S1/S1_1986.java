package solved.silver.S1;
import java.io.*;
import java.util.*;

public class S1_1986 {
    static int n, m;
    static boolean[][] attacked;
    static boolean[][] occupied;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        attacked = new boolean[n + 1][m + 1];
        occupied = new boolean[n + 1][m + 1];

        // Queen 입력 및 처리
        st = new StringTokenizer(br.readLine());
        int queenCount = Integer.parseInt(st.nextToken());
        int[][] queens = new int[queenCount][2];
        for (int i = 0; i < queenCount; i++) {
            queens[i][0] = Integer.parseInt(st.nextToken());
            queens[i][1] = Integer.parseInt(st.nextToken());
            occupied[queens[i][0]][queens[i][1]] = true;
        }

        // Knight 입력 및 처리
        st = new StringTokenizer(br.readLine());
        int knightCount = Integer.parseInt(st.nextToken());
        int[][] knights = new int[knightCount][2];
        for (int i = 0; i < knightCount; i++) {
            knights[i][0] = Integer.parseInt(st.nextToken());
            knights[i][1] = Integer.parseInt(st.nextToken());
            occupied[knights[i][0]][knights[i][1]] = true;
        }

        // Pawn 입력 및 처리
        st = new StringTokenizer(br.readLine());
        int pawnCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < pawnCount; i++) {
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            occupied[r][c] = true;
        }

        // Queen 공격 범위 표시
        for (int i = 0; i < queenCount; i++) {
            markQueenAttack(queens[i][0], queens[i][1]);
        }

        // Knight 공격 범위 표시
        for (int i = 0; i < knightCount; i++) {
            markKnightAttack(knights[i][0], knights[i][1]);
        }

        // 안전한 칸 세기
        int safeCount = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!attacked[i][j] && !occupied[i][j]) {
                    safeCount++;
                }
            }
        }

        System.out.println(safeCount);
    }

    static void markQueenAttack(int r, int c) {
        // 8방향 (상, 하, 좌, 우, 대각선 4방향)
        int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int dir = 0; dir < 8; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            // 해당 방향으로 계속 이동
            while (nr >= 1 && nr <= n && nc >= 1 && nc <= m) {
                // 다른 기물이 있으면 그 칸까지만 공격하고 멈춤
                if (occupied[nr][nc]) {
                    attacked[nr][nc] = true;
                    break;
                }
                attacked[nr][nc] = true;
                nr += dr[dir];
                nc += dc[dir];
            }
        }
    }

    static void markKnightAttack(int r, int c) {
        // Knight의 8가지 이동 경로
        int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 체스판 범위 내에 있으면 공격 가능
            if (nr >= 1 && nr <= n && nc >= 1 && nc <= m) {
                attacked[nr][nc] = true;
            }
        }
    }
}