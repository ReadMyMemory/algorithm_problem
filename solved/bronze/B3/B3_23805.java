package solved.bronze.B3;
import java.io.*;

public class B3_23805 {
    static void appendRepeat(StringBuilder sb, char ch, int cnt) {
        for (int i = 0; i < cnt; i++) sb.append(ch);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int N = n;
        StringBuilder sb = new StringBuilder();

        // 1) 위쪽 N줄: 3N '@' + N ' ' + N '@'
        for (int i = 0; i < N; i++) {
            appendRepeat(sb, '@', 3 * N);
            appendRepeat(sb, ' ', N);
            appendRepeat(sb, '@', N);
            sb.append('\n');
        }

        // 2) 가운데 3N줄: N '@' + N ' ' + N '@' + N ' ' + N '@'
        for (int i = 0; i < 3 * N; i++) {
            appendRepeat(sb, '@', N);
            appendRepeat(sb, ' ', N);
            appendRepeat(sb, '@', N);
            appendRepeat(sb, ' ', N);
            appendRepeat(sb, '@', N);
            sb.append('\n');
        }

        // 3) 아래쪽 N줄: N '@' + N ' ' + 3N '@'
        for (int i = 0; i < N; i++) {
            appendRepeat(sb, '@', N);
            appendRepeat(sb, ' ', N);
            appendRepeat(sb, '@', 3 * N);
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
