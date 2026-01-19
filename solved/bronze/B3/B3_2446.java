import java.io.*;

public class B3_2446 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        // 위쪽 (i = 0 .. N-1)
        for (int i = 0; i < N; i++) {
            int spaces = i;
            int stars = 2 * (N - i) - 1;

            for (int s = 0; s < spaces; s++) sb.append(' ');
            for (int k = 0; k < stars; k++) sb.append('*');
            sb.append('\n');
        }

        // 아래쪽 (i = N-2 .. 0)  -> 별 3개부터 다시 증가
        for (int i = N - 2; i >= 0; i--) {
            int spaces = i;
            int stars = 2 * (N - i) - 1;

            for (int s = 0; s < spaces; s++) sb.append(' ');
            for (int k = 0; k < stars; k++) sb.append('*');
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}
