package solved.gold.G4;
import java.io.*;
import java.util.*;

public class G4_29768 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 결과를 저장할 StringBuilder
        StringBuilder sb = new StringBuilder();

        if (K == 1) {
            // K가 1이면 모든 위치를 'a'로 채움
            for (int i = 0; i < N; i++) {
                sb.append('a');
            }
        } else {
            // K가 2 이상이면:
            // 1. 앞쪽을 'a'로 최대한 채움 (N - (K-1)개)
            // 2. 뒤쪽에 나머지 문자들을 하나씩 배치

            // 'a'를 N - (K-1)개 배치
            int aCount = N - (K - 1);
            for (int i = 0; i < aCount; i++) {
                sb.append('a');
            }

            // 나머지 K-1개 문자를 'b'부터 순서대로 하나씩 배치
            for (int i = 1; i < K; i++) {
                sb.append((char)('a' + i));
            }
        }
        System.out.println(sb.toString());
    }
}