package solved.silver.S4;
import java.io.*;
import java.util.*;

public class S4_33257 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[] D = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        // 밀도값 정렬
        Arrays.sort(D);

        // 최소 1개
        int count = 1;

        for (int i = 1; i < N; i++) {
            if (D[i] - D[i-1] >= E) {  // 바로 이전 값과 비교
                count++;
            }
        }
        System.out.println(count);
    }
}