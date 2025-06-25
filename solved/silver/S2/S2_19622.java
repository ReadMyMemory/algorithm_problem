import java.io.*;
import java.util.*;

public class S2_19622 {
    static class Meeting implements Comparable<Meeting> {
        int start, end, people;
        Meeting(int start, int end, int people) {
            this.start = start;
            this.end = end;
            this.people = people;
        }
        public int compareTo(Meeting o) {
            return Integer.compare(this.end, o.end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end, people);
        }

        Arrays.sort(meetings);

        // dp[i]: i번째(0-based)까지 고려했을 때 최대 인원수
        long[] dp = new long[N];
        dp[0] = meetings[0].people;

        for (int i = 1; i < N; i++) {
            // 이전에 겹치지 않는 마지막 회의 찾기 (끝나는 시간 < 현재 시작 시간)
            int l = 0, r = i - 1, idx = -1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (meetings[m].end <= meetings[i].start) {
                    idx = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            if (idx == -1) {
                dp[i] = Math.max(dp[i-1], meetings[i].people);
            } else {
                dp[i] = Math.max(dp[i-1], dp[idx] + meetings[i].people);
            }
        }
        System.out.println(dp[N-1]);
    }
}
