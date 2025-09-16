package solved.silver.S5;
import java.io.*;
import java.util.*;

public class S5_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 좌표를 저장할 2차원 배열
        int[][] points = new int[n][2];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken()); // x좌표
            points[i][1] = Integer.parseInt(st.nextToken()); // y좌표
        }

        // 정렬 - y좌표 우선, y좌표가 같으면 x좌표로 정렬
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[1] == p2[1]) { // y좌표가 같으면
                    return p1[0] - p2[0]; // x좌표로 비교
                }
                return p1[1] - p2[1]; // y좌표로 비교
            }
        });

        // 출력
        for (int i = 0; i < n; i++) {
            sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
        }
        System.out.print(sb);
    }
}