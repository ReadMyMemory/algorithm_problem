package solved.silver.S3;
import java.io.*;
import java.util.*;

public class S3_16712 {

    /**
     * Fenwick Tree (Binary Indexed Tree)
     * - 전역 순위(1 ~ N)에 대해
     * - 현재 대회에 참가 중인 사람 수를 관리
     * - k번째로 잘하는 사람(= k번째로 작은 rank)을 빠르게 찾기 위해 사용
     */
    static class Fenwick {
        int n;
        int[] tree;

        Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        // idx 위치에 delta만큼 값 추가
        void add(int idx, int delta) {
            for (int i = idx; i <= n; i += i & -i) {
                tree[i] += delta;
            }
        }

        // 1 ~ idx 까지의 누적합
        int sum(int idx) {
            int s = 0;
            for (int i = idx; i > 0; i -= i & -i) {
                s += tree[i];
            }
            return s;
        }

        // 누적합이 k 이상이 되는 최소 인덱스 찾기
        // 즉, 현재 참가자 중 k등의 전역 순위
        int kth(int k) {
            int idx = 0;
            int bitMask = Integer.highestOneBit(n);

            for (int step = bitMask; step != 0; step >>= 1) {
                int next = idx + step;
                if (next <= n && tree[next] < k) {
                    k -= tree[next];
                    idx = next;
                }
            }
            return idx + 1;
        }
    }

    // 참가자 정보 클래스
    static class Person {
        int idx; // 원래 줄에서의 위치
        int a;   // 정보 실력

        Person(int idx, int a) {
            this.idx = idx;
            this.a = a;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 참가자 수
        int M = Integer.parseInt(st.nextToken()); // 한 번에 겨루는 인원 수

        // 정보 실력 입력
        int[] a = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        // 각 라운드에서 탈락할 순위
        int rounds = N - M + 1;
        int[] V = new int[rounds + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= rounds; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * 전역 순위 계산
         * - 정보 실력 오름차순
         * - 실력이 같으면 앞에 서 있던 사람이 더 높은 순위
         */
        Person[] persons = new Person[N];
        for (int i = 1; i <= N; i++) {
            persons[i - 1] = new Person(i, a[i]);
        }

        Arrays.sort(persons, (p1, p2) -> {
            if (p1.a != p2.a) return Integer.compare(p1.a, p2.a);
            return Integer.compare(p1.idx, p2.idx);
        });

        // 각 사람의 전역 순위
        int[] rankOfIdx = new int[N + 1];
        // 전역 순위 → 사람 인덱스
        int[] idxOfRank = new int[N + 1];

        for (int r = 1; r <= N; r++) {
            int idx = persons[r - 1].idx;
            rankOfIdx[idx] = r;
            idxOfRank[r] = idx;
        }

        Fenwick fw = new Fenwick(N);

        // 처음 대회에 참가하는 M명 등록
        for (int i = 1; i <= M; i++) {
            fw.add(rankOfIdx[i], 1);
        }

        // 다음으로 들어올 사람 인덱스
        int nextIdx = M + 1;

        /**
         * 대회 진행
         * - 현재 참가자 중 V[t]등 탈락
         * - 줄에 남아 있으면 다음 사람 투입
         */
        for (int t = 1; t <= rounds; t++) {
            int k = V[t];

            // k등의 전역 순위 찾기
            int rankToRemove = fw.kth(k);

            // 탈락 처리
            fw.add(rankToRemove, -1);

            // 다음 대기자 투입
            if (nextIdx <= N) {
                fw.add(rankOfIdx[nextIdx], 1);
                nextIdx++;
            }
        }

        /**
         * 최종 생존자 M-1명 수집
         */
        ArrayList<Integer> result = new ArrayList<>();
        for (int r = 1; r <= N; r++) {
            // 현재 남아있는 전역 순위인지 확인
            if (fw.sum(r) - fw.sum(r - 1) == 1) {
                int idx = idxOfRank[r];
                result.add(a[idx]);
            }
        }

        // 정보 실력 오름차순 출력
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(result.get(i));
        }
        System.out.println(sb);
    }
}
