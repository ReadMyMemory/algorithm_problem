package solved.silver.S5;
import java.io.*;
import java.util.*;

public class S5_15905 {
    static class Participant implements Comparable<Participant> {
        int solved, penalty;
        Participant(int s, int p) {
            this.solved = s;
            this.penalty = p;
        }
        @Override
        public int compareTo(Participant o) {
            // 문제 많이 푼 순(내림차순), 패널티 적은 순(오름차순)
            if (this.solved != o.solved) {
                return o.solved - this.solved;
            }
            return this.penalty - o.penalty;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Participant> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int solved = Integer.parseInt(st.nextToken());
            int penalty = Integer.parseInt(st.nextToken());
            list.add(new Participant(solved, penalty));
        }

        Collections.sort(list);
        // 5등(0-based index 4)이 푼 문제 수
        int fifthSolved = list.get(4).solved;

        // 6등 이후에서 동일한 문제 수를 푼 사람 수 세기
        int count = 0;
        for (int i = 5; i < N; i++) {
            if (list.get(i).solved == fifthSolved) {
                count++;
            }
        }
        System.out.println(count);
    }
}
