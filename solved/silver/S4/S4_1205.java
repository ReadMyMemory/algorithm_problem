package solved.silver.S4;
import java.io.*;
import java.util.*;

public class S4_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 현재 리스트에 있는 점수 개수
        int newScore = Integer.parseInt(st.nextToken()); // 태수의 새로운 점수
        int P = Integer.parseInt(st.nextToken()); // 랭킹 리스트 최대 크기

        // N이 0인 경우 (리스트가 비어있음)
        if (N == 0) {
            System.out.println(1);
            return;
        }

        // 현재 랭킹 리스트 읽기
        int[] scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        // 새로운 점수의 등수 찾기
        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (newScore < scores[i]) {
                rank++;
            } else {
                break;
            }
        }

        // 리스트가 꽉 찼고, 새 점수가 마지막 점수보다 작거나 같은 경우
        if (N == P && newScore <= scores[N - 1]) {
            System.out.println(-1);
            return;
        }

        // 등수가 P를 초과하는 경우
        if (rank > P) {
            System.out.println(-1);
            return;
        }
        System.out.println(rank);
    }
}