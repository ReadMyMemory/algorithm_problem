package solved_ac_step.class4;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
가장 긴 증가하는 부분 수열의 응용문제다.
이번엔 증가했다가, 감소하는 수열의 전체 길이를 계산해야한다.
 */

/*
앞에서 한번, 뒤에서 한번 방향이 다르게 증가하는 수열을 체크한 뒤에
각각의 dp 값에 있는 값을 더하면, 그것이 바이토닉 부분 수열의 값이 아닐까?
그렇게 해봤다.
 */

public class G4_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];
        int[] dp_front = new int[N + 1];
        int[] dp_rear = new int[N + 1];

        // 원래 증가하는 부분 수열 문제라면 초기값은 1이여야하는데(본인포함이라) 나중에 값에 1을 더하는 것으로 대신했다.
        // 그래서 Arrays.fill(dp, 1)은 사용하지 않았다.

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        //앞에서 체크하는 증가하는 부분 수열
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                if(num[i] > num[j]) // 1 ~ i-1
                    dp_front[i] = Math.max(dp_front[i], dp_front[j] + 1);
            }
        }

        //뒤에서 체크하는 증가하는 부분 수열(앞 기준으론 감소하는 수열)
        for(int i = N; i >= 1; i--) {
            for(int j = N; j > i; j--) {
                if(num[i] > num[j])
                    dp_rear[i] = Math.max(dp_rear[i], dp_rear[j] + 1);
            }
        }

        //확인용 출력
//        for(int i = 1; i <= N; i++)
//            System.out.println(dp[i] + " " + dp2[i]);

        //바이토닉 부분 수열의 값을 구하기 위해 같은 인덱스끼리 더한다.
        for(int i = 1; i <= N; i++)
            dp_front[i] += dp_rear[i];

        Arrays.sort(dp_front); // 최댓값 출력을 위한 정렬

        System.out.println(dp_front[N] + 1);
        // 1을 더하는 이유는 결국 그거다.
        //우리는 초기값이 1이 아닌 0이기 때문에 증가하는 부분 수열을 셀때 1번씩 빈다.
        //우리는 앞에서 1번, 뒤에서 1번 세기 때문에 2번의 횟수가 빈다.
        //다만 앞에서 세고, 뒤에서 세다보면 끝부분에서 맞물리는 수가 하나가 겹친다.
        //따라서 이를 빼줘야 하기 때문에 1만 더하면 된다.
    }
}
