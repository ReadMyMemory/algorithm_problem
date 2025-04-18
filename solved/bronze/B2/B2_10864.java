package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_10864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 각 학생의 친구 수를 저장할 배열
        int[] friendCount = new int[N + 1];

        // 친구 관계 입력 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            friendCount[A]++;
            friendCount[B]++;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(friendCount[i]).append('\n');
        }
        System.out.print(sb);
    }
}
