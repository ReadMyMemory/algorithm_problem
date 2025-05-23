package solved.gold;
import java.io.*;
import java.util.*;
/*

국회의원 명예 점수를 오름차순 정렬
가장 작은 명예부터 차례대로, 각 사람이 1, 2, ..., N이 되도록 박탈
각 명예가 최소로 맞춰질 때까지 차감한 누적 합이 해커 수
 */

public class G5_16678 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] honors = new int[N];
        for (int i = 0; i < N; i++) {
            honors[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(honors);

        int maxHonor = 1;
        long action = 0;

        for (int i = 0; i < N; i++) {
            if (honors[i] >= maxHonor) {
                action += honors[i] - maxHonor;
                maxHonor++;
            }
        }
        System.out.println(action);
    }
}
