package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_3076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()); // 체스판 행 개수
        int C = Integer.parseInt(st.nextToken()); // 체스판 열 개수

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 각 칸의 높이
        int B = Integer.parseInt(st.nextToken()); // 각 칸의 너비

        StringBuilder sb = new StringBuilder();

        // 전체 출력 행 수는 R * A
        for (int i = 0; i < R * A; i++) {
            // 현재 출력 행이 체스판의 몇 번째 행에 속하는지
            int boardRow = i / A;

            // 전체 출력 열 수는 C * B
            for (int j = 0; j < C * B; j++) {
                // 현재 출력 열이 체스판의 몇 번째 열에 속하는지
                int boardCol = j / B;

                // 체스판의 (0,0)은 검정색('X')으로 시작
                // 행과 열의 합이 짝수면 검정색, 홀수면 흰색
                if ((boardRow + boardCol) % 2 == 0) {
                    sb.append('X');
                } else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}