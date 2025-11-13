package solved.bronze.B3;
import java.io.*;
import java.util.*;

public class B3_26145 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N: 출제자 수, M: 검수자 수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int total = N + M;

        long[] money = new long[total + 1]; // 1 ~ N+M

        // 출제비 S_i 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            long s = Long.parseLong(st.nextToken());
            money[i] += s;
        }

        // T_i,j 입력 및 송금 처리
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= total; j++) {
                long t = Long.parseLong(st.nextToken());
                if (t == 0) continue; // 0이면 변동 없음
                money[i] -= t;
                money[j] += t;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= total; i++) {
            sb.append(money[i]);
            if (i < total) sb.append(' ');
        }

        System.out.println(sb.toString());
    }
}
