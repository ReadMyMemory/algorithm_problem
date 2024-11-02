package solved_ac_step.class4;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
14003번을 dp로만 풀다가 시간초과가 나서 이분탐색법을 사용하는 식으로 변경했었는데,
dp로만 풀었을때의 풀이법이 14002에 그대로 적용가능할 것 같아서 그대로 풀었다.
 */

public class G4_14002 {
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = new ArrayList<>();
        int idx = 0;
        while(st.hasMoreTokens())
            seq[idx++] = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, seq));
        for(int i = answer.size() - 1; i >= 0; i--)
            bw.write(answer.get(i)+" ");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int solution(int N, int[] seq) throws IOException {
        int[] dp = new int[N]; //증가하는 부분수열 길이의 최댓값 계산
        int[] path = new int[N]; // 부모 인덱스 저장
        Arrays.fill(path, -1); // -1로 채우는 이유는 가장 긴 부분 수열을 찾은 뒤에 그 수열의 마지막에서부터 탐색하며 가장 첫번째 수를 찾기 위해서다.
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(seq[i] > seq[j]) {
                    if(dp[i] <= dp[j] + 1) // max 값이 갱신되는경우
                        path[i] = j; // 부모 인덱스(더 작은 인덱스)를 갱신한다.
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //N이 100만이라면, 시간복잡도 100만 * (1+2+...999999)

        int idx = -1; // 가장 긴 부분 수열의 마지막 인덱스를 기록하기 위함.
        int max = -1; // 본인을 빼고 계산하기 때문에 1만큼 빠져서 하나만 부분 수열에 포함되는 경우 0이 나와서 갱신이 안됐다.
        for(int i = 0; i < N; i++) {
            if(max < dp[i]) {
                idx = i;
                max = dp[i];
            }
        }
        while(true) {
            if(idx == -1)
                break;
            answer.add(seq[idx]);
            idx = path[idx]; // 부모 인덱스(더 작은 인덱스)로 갱신
        }
        return max + 1; // 본인 포함이라
    }
}
