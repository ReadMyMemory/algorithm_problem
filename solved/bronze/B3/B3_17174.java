package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_17174 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = N;
        while(N >= M) { // 처음에 while 조건에서, N == M의 경우을 빼먹었다.
            N /= M;
            sum += N;
        }
        System.out.println(sum);
    }
}
