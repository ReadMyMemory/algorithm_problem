package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_31922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 케이스로 분류하자
        System.out.println(Math.max(A+C, P));
    }
}
