package solved.bronze.B4;
import java.io.*;
import java.util.*;

public class B4_30999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 문제 후보의 수
        int M = Integer.parseInt(st.nextToken()); // 출제위원의 수

        int majority = M / 2 + 1; // 과반수 기준 (M이 홀수이므로 M/2 + 1이 과반수)
        int count = 0; // 출제될 문제의 수

        for (int i = 0; i < N; i++) {
            String votes = br.readLine();
            int yesVotes = 0;

            // 각 문제에 대한 찬성표 개수 계산
            for (int j = 0; j < M; j++) {
                if (votes.charAt(j) == 'O') {
                    yesVotes++;
                }
            }

            // 과반수 이상이면 출제 문제로 카운트
            if (yesVotes >= majority) {
                count++;
            }
        }
        System.out.println(count);
    }
}