package solved_ac_step.class4;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G5_12865 {

    private static class Item {
        int weight, value;
        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Item> list = new ArrayList<>();
        int[][] dp = new int[N+1][K+1]; // dp[물건개수][무게] = 물건의 가치합

        int idx = 0;
        while(idx != N) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Item(w, v));
            idx++;
        }

        for(int i = 1; i <= N; i++) { // 배낭에 넣을 물건을 순차적으로
            for(int j = 1; j <= K; j++) { // 1부터 배낭의 capacity까지 순회
                if(list.get(i-1).weight > j) // 물건의 무게가 현재 capacity보다 크다면? 넣을 수 없으니 넘어가기
                    dp[i][j] = dp[i-1][j];
                else // 현재 무게에서의 가치가, 새로 넣는 물건을 넣었을 때 더 높은 가치값을 가질 수 있는지를 체크해 갱신한다.
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - list.get(i-1).weight] + list.get(i-1).value);
            }
        }
        System.out.println(dp[N][K]);
    }
}
