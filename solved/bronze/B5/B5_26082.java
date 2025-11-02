package solved.bronze.B5;
import java.io.*;
import java.util.*;

public class B5_26082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 경쟁사 제품의 가격
        int B = Integer.parseInt(st.nextToken()); // 경쟁사 제품의 성능
        int C = Integer.parseInt(st.nextToken()); // WARBOY의 가격

        // WARBOY 성능 = 3 * B * C / A
        int warboyPerformance = 3 * B * C / A;

        System.out.println(warboyPerformance);
    }
}