package solved.gold;
import java.io.*;

public class G4_10915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        System.out.println(countWires(N));
    }

    static long countWires(long N) {
        // 패턴 분석 결과:
        // - N이 홀수일 때: 철사의 개수 = (N-1)/2
        // - N이 짝수일 때: 철사의 개수 = N-1

        if (N % 2 == 1) {
            // N이 홀수
            return (N - 1) / 2;
        } else {
            // N이 짝수
            return N - 1;
        }
    }
}