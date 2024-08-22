package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_17496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 여름의 일 수 N, 수확일은 N을 넘길 수 없음.
        int T = Integer.parseInt(st.nextToken()); // 자라는데 걸리는 일 수 T
        int C = Integer.parseInt(st.nextToken()); // 심을 수 있는 칸의 수 C
        int P = Integer.parseInt(st.nextToken()); // 개당 가격 P
        // 시작 일은 1부터 시작, 즉 1일 ~ N일 인거다.
        int day = (N-1) / T;
        System.out.println(day * C * P);

    }
}
