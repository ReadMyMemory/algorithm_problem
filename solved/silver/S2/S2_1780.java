package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_1780 {
    static int N;
    static int[][] a;
    static int cntNeg1 = 0, cnt0 = 0, cnt1 = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        a = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);

        StringBuilder sb = new StringBuilder();
        sb.append(cntNeg1).append('\n');
        sb.append(cnt0).append('\n');
        sb.append(cnt1).append('\n');
        System.out.print(sb);
    }

    static void solve(int r, int c, int size) {
        if (isUniform(r, c, size)) {
            int v = a[r][c];
            if (v == -1) cntNeg1++;
            else if (v == 0) cnt0++;
            else cnt1++;
            return;
        }

        int next = size / 3;
        for (int dr = 0; dr < 3; dr++) {
            for (int dc = 0; dc < 3; dc++) {
                solve(r + dr * next, c + dc * next, next);
            }
        }
    }

    static boolean isUniform(int r, int c, int size) {
        int v = a[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (a[i][j] != v) return false;
            }
        }
        return true;
    }
}
