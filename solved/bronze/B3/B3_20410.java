package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_20410 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int m = Integer.parseInt(st.nextToken());
        int seed = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());

        // 가능한 모든 a, c 탐색
        for (int a = 0; a < m; a++) {
            for (int c = 0; c < m; c++) {
                if ((a * seed + c) % m == x1 && (a * x1 + c) % m == x2) {
                    System.out.println(a + " " + c);
                    return;
                }
            }
        }
    }
}
