package solved.silver;
import java.io.*;
import java.util.StringTokenizer;

public class S2_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        int[] dp = new int[number+1];
        int[] num = new int[number+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 1;
        while(st.hasMoreTokens()) {
            num[index] = Integer.parseInt(st.nextToken());
            index++;
        }
        int max = 0;
        for(int i = 1; i <= number; i++) {
            dp[i] = 1;
            for(int j = i-1; j >=1; j--) {
                if(num[i] > num[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
        br.close();
    }
}
