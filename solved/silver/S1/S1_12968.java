package solved.silver.S1;
import java.io.*;
import java.util.*;

/*
R과 C가 모두 홀수: 전체 칸 수가 홀수 → 체스판 색칠시 흑백 칸 개수가 1개 차이 → 해밀턴 사이클 불가능 → K=1일 때만 가능
R이나 C 중 하나라도 짝수: 해밀턴 경로를 구성할 수 있는 구조 → 모든 K값에 대해 가능
*/

public class S1_12968 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // R과 C가 모두 홀수인 경우
        if (R % 2 == 1 && C % 2 == 1) {
            // K=1일 때만 가능
            if (K == 1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else {
            // R이나 C 중 하나라도 짝수인 경우
            // 모든 K에 대해 가능
            System.out.println(1);
        }
    }
}