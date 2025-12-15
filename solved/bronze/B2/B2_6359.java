package solved.bronze.B2;
import java.io.*;
import java.util.*;

public class B2_6359 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine().trim());

            // 최종적으로 열려있는 방 개수 = 1..n 사이의 완전제곱수 개수 = floor(sqrt(n))
            int answer = (int) Math.floor(Math.sqrt(n));

            sb.append(answer).append('\n');
        }
        System.out.print(sb.toString());
    }
}
