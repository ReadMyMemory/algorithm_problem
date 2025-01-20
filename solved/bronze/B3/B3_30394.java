package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_30394 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // x는 필요없음
            int y = Integer.parseInt(st.nextToken());
            max = Math.max(max, y);
            min = Math.min(min, y);
        }
        System.out.println(max - min);
    }
}
