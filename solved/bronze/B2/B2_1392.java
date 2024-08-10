package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_1392 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] dp = new int[10001]; // 악보는 100개까지, 한 악보가 차지하는 시간은 100이하이므로, 이론적으로 10000초 이상을 넘길 수 없음.
        int pointer = 0;
        int score_point = 1;

        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            while(temp --> 0) {
                dp[pointer] = score_point;
                pointer++;
            }
            score_point++;
        }

        while(Q --> 0)
            bw.write(dp[Integer.parseInt(br.readLine())]+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
