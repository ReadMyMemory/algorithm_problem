package solved_ac_step.class5;
import java.io.*;
import java.util.*;

/*
처음에 이거 왜 플래티넘일까 생각해봤다.
보니까 가장 긴 증가하는 부분 수열의 길이 뿐만 아니라 그 수열도 출력해야 했었다.
또한 dp로 풀기에 메모리제한에 비해 크기 N이 너무 커보였다.
한편으론 가장 긴 바이토닉 부분 수열을 출력하라는 문제가 아니여서 다행이다.

dp만을 사용해서 풀면 최악의 상황에서 O(N^2)의 시간복잡도가 발생한다.
따라서 이분탐색법을 추가로 사용해야한다.

부분 수열 출력을 위해선 동적계획법 역추적을 사용하면 좋다. 아래 링크를 참고했다.
https://velog.io/@flowersayo/%EB%8F%99%EC%A0%81%EA%B3%84%ED%9A%8D%EB%B2%95-%EC%97%AD%EC%B6%94%EC%A0%81
 */

public class P5_14003 {
    static ArrayList<Long> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] seq = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = new ArrayList<>();
        int idx = 0;
        while(st.hasMoreTokens())
            seq[idx++] = Long.parseLong(st.nextToken());

        System.out.println(solution(N, seq));
        //시간 초과로 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for(int i = answer.size() - 1; i >= 0; i--)
            sb.append(answer.get(i)).append(" ");
        System.out.println(sb.toString());
        br.close();
    }

    private static long solution(int N, long[] seq) throws IOException {
        long[] dp = new long[N]; //증가하는 부분수열 길이의 최댓값 계산
        int[] path = new int[N]; // 부모 인덱스 저장
        Arrays.fill(path, -1); // -1로 채우는 이유는 가장 긴 부분 수열을 찾은 뒤에 그 수열의 마지막에서부터 탐색하며 가장 첫번째 수를 찾기 위해서다.
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(seq[i] > seq[j]) {
                    if(dp[i] < dp[j] + 1) // max 값이 갱신되는경우
                        path[i] = j; // 부모 인덱스(더 작은 인덱스)를 갱신한다.
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //N이 100만이라면, 시간복잡도 100만 * (1+2+...999999)

        int idx = -2; // 가장 긴 부분 수열의 마지막 인덱스를 기록하기 위함.
        long max = 0;
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
