package solved.silver.S3;
import java.io.*;

public class S3_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[][] map = new int[N][M];

        // 입력 받기
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int maxSize = 1; // 최소 한 변의 길이 1

        // 모든 좌표 (i, j)에서 출발
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 가능한 정사각형 한 변의 최대 길이
                for (int size = 1; i + size < N && j + size < M; size++) {
                    // 네 꼭짓점의 값이 같은지 확인
                    int v1 = map[i][j];
                    int v2 = map[i][j + size];
                    int v3 = map[i + size][j];
                    int v4 = map[i + size][j + size];
                    if (v1 == v2 && v1 == v3 && v1 == v4) {
                        int area = (size + 1) * (size + 1);
                        if (area > maxSize) maxSize = area;
                    }
                }
            }
        }
        System.out.println(maxSize);
    }
}
