package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_2210 {
    static int[][] board = new int[5][5];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static HashSet<Integer> set = new HashSet<>();

    static void dfs(int x, int y, int depth, int val) {
        if (depth == 6) { // 6자리 완성
            set.add(val);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;

            dfs(nx, ny, depth + 1, val * 10 + board[nx][ny]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 1, board[i][j]); // 시작칸 포함: depth=1
            }
        }

        System.out.println(set.size());
    }
}