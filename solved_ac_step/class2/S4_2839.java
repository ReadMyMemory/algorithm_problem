package solved_ac_step.class2;
import java.io.*;

public class S4_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //5로 가져갈 때, 3으로 가져갈 때 두가지 방향으로 생각.
        int amount = Integer.parseInt(br.readLine());
        int[] dp = new int[5001]; // amount+1로 사이즈 해도 되긴 한데, 아래 dp[3], dp[5]에 조건문 달기 귀찮아서
        dp[3] = 1;
        dp[5] = 1;
        for(int i = 6; i <= amount; i++) {
            if(i % 5 == 0) //5로 나눠지면
                dp[i] = dp[i-5] + 1;
            else if(i % 3 == 0) //5로 안나눠지고 3으로 나눠지면
                dp[i] = dp[i-3] + 1;
            else { // 5, 3 둘 다 나눠지지 않는다면(3이랑 5랑 섞였을 가능성을 생각한다.)
                if(dp [i - 3] != 0 && dp [i - 5] != 0) // 이전 분기가 배달 가능한 설탕 양이었다면
                    dp[i] = Math.min(dp[i-3], dp[i-5]) + 1; // 이전 분기 중 봉지 갯수 적은 걸 선택한다.
            }
        }
        if(dp[amount] == 0)
            System.out.println(-1);
        else
            System.out.println(dp[amount]);
    }
}
