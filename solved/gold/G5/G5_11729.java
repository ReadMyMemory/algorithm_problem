package solved.gold.G5;
import java.io.*;

public class G5_11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 이동 횟수는 2^n - 1
        long count = (1L << n) - 1;
        sb.append(count).append("\n");

        // n개의 원판을 1번 기둥에서 3번 기둥으로 옮김
        hanoi(n, 1, 3, 2);
        System.out.print(sb);
    }

    // n개의 원판을 from에서 to로 옮김 (aux를 보조로 사용)
    static void hanoi(int n, int from, int to, int aux) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        // 1. 위의 (n-1)개를 from에서 aux로 옮김 (to를 보조로 사용)
        hanoi(n - 1, from, aux, to);

        // 2. 가장 큰 원판을 from에서 to로 옮김
        sb.append(from).append(" ").append(to).append("\n");

        // 3. (n-1)개를 aux에서 to로 옮김 (from을 보조로 사용)
        hanoi(n - 1, aux, to, from);
    }
}