package solved.bronze.B4;
import java.io.*;
import java.util.*;

public class B4_24724 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());

            // A, B 읽기
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // A
            st.nextToken(); // B

            // N개의 (u_i, v_i) 입력 소비
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); // u_i
                st.nextToken(); // v_i
            }

            sb.append("Material Management ").append(tc).append("\n");
            sb.append("Classification ---- End!\n");
        }

        System.out.print(sb);
    }
}
