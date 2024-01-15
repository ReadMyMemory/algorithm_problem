package solved_ac_step.class3;
import java.io.*;

public class S3_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] stairs = new int[number + 1]; // 계단 기록, 배열 인덱스 맞추려고
        for(int i = 1; i <= number; i++)
            stairs[i] = Integer.parseInt(br.readLine());
        //앞에서부터 세는 게 맞을까 뒤에서부터 세는 게 맞을까?
        //바로 이전 칸을 밟고 마지막 칸을 밟는다면 dp[n] = dp[n-1] + stairs[n]
        //전전 칸을 밟고 마지막 칸을 밟는다면 dp[n] =  dp[n-2] + stairs[n]
        //다만 1칸씩 밟는 걸 3번 반복할 순 없다.
        int[] dp = new int[number + 1];
        int count = 0;

        dp[1] = stairs[1];
        if(number >= 2)
            dp[2] = Math.max(stairs[1]+stairs[2], stairs[2]); // 1칸 1칸(0 > 1 > 2), 2칸(0 > 2) 물론 당연히 1칸 1칸이 더 크다고 생각한다.
        if(number >= 3)
            dp[3] = Math.max(stairs[2]+stairs[3], stairs[1]+stairs[3]); // 2칸 1칸(0 > 2 > 3), 1칸 2칸(0 > 1 > 3)
        if(number >= 4) {
            for (int i = 4; i <= number; i++) {
                //1. 2칸 전에서 오기. 2. 1칸 전에서 오기.
                // 다만, 3칸 전에서 1칸 1칸 1칸 이렇게 올 순 없고 무조건 2칸 1칸 와야 한다. 따라서 이를 명시.
                dp[i] = Math.max(dp[i - 2] + stairs[i], stairs[i - 1] + stairs[i] + dp[i - 3]);
            }
        }
        System.out.println(dp[number]);
    }
}
