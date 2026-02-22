package solved.gold.G5;
import java.io.*;

/*
맨 처음 틀린 이유
전파 방식은 losing 상태만 기준으로 퍼뜨려야 하는데, 나는 1을 losing으로 잘못 판단했다.
실제로 1은 제곱수이므로 winning 상태인데, 초기값을 세팅하지 않아 기본값(false)로 처리됨.
그 결과 2부터 전부 잘못 마킹되면서 전체 DP가 틀어졌다.
*/

public class G5_16888 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        int[] qs = new int[T];
        int maxN = 0;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            qs[i] = n;
            if (n > maxN) maxN = n;
        }

        boolean[] win = new boolean[maxN + 1];

        if (maxN >= 1) win[1] = true;
        if (maxN >= 2) win[2] = false;

        // 제곱수는 바로 승리 (n 자체를 빼서 0 만들 수 있음)
        for (int i = 1; i * i <= maxN; i++) {
            win[i * i] = true;
        }

        // losing 상태를 발견하면 i + j^2 를 전부 winning으로 마킹
        for (int i = 2; i <= maxN; i++) {
            if (!win[i]) { // losing
                for (int j = 1; ; j++) {
                    int s = j * j;
                    int nxt = i + s;
                    if (nxt > maxN) break;
                    win[nxt] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : qs) {
            sb.append(win[n] ? "koosaga" : "cubelover").append('\n');
        }
        System.out.print(sb.toString());
    }
}