package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_24460 {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(divide(0, 0, N));
    }

    // (r, c)를 시작으로 하는 size x size 구역의 최종 후보 번호 반환
    static int divide(int r, int c, int size) {
        if (size == 1) {
            return arr[r][c];
        }
        int half = size / 2;

        int[] picked = new int[4];
        picked[0] = divide(r, c, half);                 // 왼쪽 위
        picked[1] = divide(r, c + half, half);          // 오른쪽 위
        picked[2] = divide(r + half, c, half);          // 왼쪽 아래
        picked[3] = divide(r + half, c + half, half);   // 오른쪽 아래

        Arrays.sort(picked);
        return picked[1]; // 두 번째로 작은 값
    }
}
