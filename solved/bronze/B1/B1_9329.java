package solved.bronze.B1;
import java.io.*;

public class B1_9329 {
    static class FastReader {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            do c = read(); while (c <= ' ');        // skip spaces
            if (c == '-') { s = -1; c = read(); }
            while (c > ' ') {
                x = x * 10 + (c - '0');
                c = read();
            }
            return x * s;
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();

        int T = fr.nextInt();
        while (T-- > 0) {
            int n = fr.nextInt();   // 상금 종류 수
            int m = fr.nextInt();   // 스티커 종류 수 (1..m)

            // 각 상금: 필요한 스티커 목록과 상금액
            int[][] need = new int[n][];
            int[] prize = new int[n];

            for (int i = 0; i < n; i++) {
                int k = fr.nextInt();           // 필요한 스티커 개수
                int[] list = new int[k];
                for (int j = 0; j < k; j++) {
                    list[j] = fr.nextInt();     // 스티커 종류 번호 (1..m)
                }
                int p = fr.nextInt();           // 상금액
                need[i] = list;
                prize[i] = p;
            }

            int[] cnt = new int[m + 1];
            for (int i = 1; i <= m; i++) cnt[i] = fr.nextInt();

            long sum = 0;
            for (int i = 0; i < n; i++) {
                int minSet = Integer.MAX_VALUE;
                for (int t : need[i]) {
                    minSet = Math.min(minSet, cnt[t]);
                    if (minSet == 0) break;
                }
                if (minSet > 0 && minSet != Integer.MAX_VALUE) {
                    sum += (long) minSet * prize[i];
                }
            }

            sb.append(sum).append('\n');
        }
        System.out.print(sb.toString());
    }
}
