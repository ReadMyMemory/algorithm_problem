package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_12970 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        for (int a = 0; a <= N; a++) {
            int b = N - a;
            long maxPairs = (long) a * b;
            if (K > maxPairs) continue;

            // a개 A, b개 B로 K를 만들 수 있음 -> 그리디 구성임
            StringBuilder sb = new StringBuilder();
            int A = a, B = b;
            long need = K;

            for (int i = 0; i < N; i++) {
                if (A == 0) {
                    sb.append('B');
                    B--;
                } else if (B == 0) {
                    sb.append('A');
                    A--;
                } else {
                    if (need >= B) {
                        sb.append('A');
                        need -= B;
                        A--;
                    } else {
                        sb.append('B');
                        B--;
                    }
                }
            }
            System.out.println(sb.toString());
            return;
        }
        System.out.println("-1");
    }
}
