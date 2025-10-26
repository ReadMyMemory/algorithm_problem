package solved.gold.G5;
import java.io.*;
import java.util.*;

public class G5_14671 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken(); // 사용 안하는 값
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // parity[px][py] : px = x%2 (0=even,1=odd), py = y%2
        boolean[][] parity = new boolean[2][2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            parity[x & 1][y & 1] = true;
        }

        boolean status = parity[0][0] && parity[0][1] && parity[1][0] && parity[1][1];
        System.out.println(status? "YES" : "NO");
    }
}
