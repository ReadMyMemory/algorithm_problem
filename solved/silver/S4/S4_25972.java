package solved.silver.S4;
import java.io.*;
import java.util.*;

public class S4_25972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] domino = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            domino[i][0] = Integer.parseInt(st.nextToken()); // x좌표
            domino[i][1] = Integer.parseInt(st.nextToken()); // 길이
        }

        // x좌표 기준 정렬 - 해당 문제 게시판 참고
        Arrays.sort(domino, Comparator.comparingInt(a -> a[0]));

        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            // i번째 도미노가 i+1번째 도미노까지 닿지 못하면, 새로운 시작점임
            if (domino[i][0] + domino[i][1] < domino[i + 1][0]) {
                count++;
            }
        }
        // 마지막 덩어리는 무조건 한 번 필요
        System.out.println(count + 1);
    }
}
