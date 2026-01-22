package solved.silver.S2;
import java.io.*;

public class S2_6542 {
    static final int NEED = 3000;
    static final int MAX = 200000;

    public static void main(String[] args) throws Exception {
        int[] lucky = precomputeLucky();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            int n = Integer.parseInt(line.trim());
            if (n == 0) break;

            sb.append(lucky[n - 1]).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static int[] precomputeLucky() {
        int[] cur = new int[MAX - 1];
        int[] next = new int[MAX - 1];

        // 초기 수열: 2, 3, 4, ...
        for (int i = 0; i < cur.length; i++) {
            cur[i] = i + 2;
        }

        int len = cur.length;

        for (int i = 0; i < NEED; i++) {
            int step = cur[i];

            // i까지는 그대로 유지
            System.arraycopy(cur, 0, next, 0, i + 1);
            int newLen = i + 1;

            // i 뒤에서 step번째마다 제거
            int removeIdx = i + step;
            for (int j = i + 1; j < len; j++) {
                if (j == removeIdx) {
                    removeIdx += step;
                } else {
                    next[newLen++] = cur[j];
                }
            }

            // swap
            int[] tmp = cur;
            cur = next;
            next = tmp;
            len = newLen;
        }

        int[] lucky = new int[NEED];
        System.arraycopy(cur, 0, lucky, 0, NEED);
        return lucky;
    }
}
