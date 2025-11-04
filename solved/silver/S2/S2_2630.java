package solved.silver.S2;
import java.io.*;
import java.util.*;

public class S2_2630 {
    static int N;
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken()); // 0: white, 1: blue
            }
        }

        divide(0, 0, N);

        StringBuilder sb = new StringBuilder();
        sb.append(white).append('\n').append(blue).append('\n');
        System.out.print(sb);
    }

    // (r, c)에서 시작하는 size x size 정사각형 처리
    static void divide(int r, int c, int size) {
        if (isUniform(r, c, size)) {
            if (paper[r][c] == 0) white++;
            else blue++;
            return;
        }

        int half = size / 2;
        divide(r, c, half);                 // 좌상
        divide(r, c + half, half);          // 우상
        divide(r + half, c, half);          // 좌하
        divide(r + half, c + half, half);   // 우하
    }

    // 해당 구간이 단색인지 검사
    static boolean isUniform(int r, int c, int size) {
        int color = paper[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (paper[i][j] != color) return false;
            }
        }
        return true;
    }
}
