package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_17466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, P));
    }
    private static long solution(int N, int P) {
        //N!를 구하고 P로 나눌 순 없으니, 순서대로 곱하면서 나누자.
        long answer = 1L;
        for(int i = 1; i <= N; i++) {
            answer *= i;
            if(answer > P)
                answer %= P;
        }
        return answer;
    }
}
