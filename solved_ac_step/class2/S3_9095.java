package solved_ac_step.class2;
import java.io.*;
import java.util.*;

public class S3_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int num = Integer.parseInt(br.readLine());
                int max = 0;
                ArrayList<Integer> list = new ArrayList<>();

                for (int i = 0; i < num; i++) {
                    int input = Integer.parseInt(br.readLine());
                    list.add(input);
                    if (input > max)
                        max = input;
                }

                int[] dp = new int[max + 1];

                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;

                for (int i = 4; i <= max; i++) {
                    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
                }

                for (int a : list) {
                    System.out.println(dp[a]);
                }
    }
}
