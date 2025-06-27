package solved.bronze.B1;
import java.io.*;

public class B1_30289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int result = 0;
        for (int i = 0; i <= n + m; i++) {
            result += count(n, m, i);
        }
        System.out.println(result);
    }

    // f(a, b, c): 0 <= x <= a, 0 <= y <= b, x + y == c 인 (x, y) 쌍의 개수
    private static int count(int a, int b, int c) {
        int cnt = 0;
        // x = 0 ~ a
        for (int x = 0; x <= a; x++) {
            int y = c - x;
            if (y >= 0 && y <= b) cnt++;
        }
        return cnt;
    }
}
