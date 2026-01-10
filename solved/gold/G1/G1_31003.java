package solved.gold.G1;
import java.io.*;
import java.util.*;

/**
 * 문제 확인:
 * 인접한 두 원소가 서로소일 때만 swap 가능.
 * 횟수 제한은 없다.
 * 두 수 x y가 서로소가 아니라면 이 둘의 상대적 순서는 바뀔 수 없다
 * 해당 내용은 상대적 순서를 바꾸려면 언젠가 인접한 상태에서 swap을 해야하고,
 * 그 상태에서 서로소가 아니면 swap 불가능하고,
 * 다른 수를 사이에 끼워도 결국 직접 swap 해야 하므로 불가능하다.
 * 따라서 초기 배열에서 i < j이고 gcd(A[i],A[j])>1이면 모든 쌍 (i,j)에 대해 A[i]는 A[j]보다 앞에 있어야 한다.
 *
 * 아이디어:
 * gcd(a,b)>1 인 두 원소는 상대 순서가 절대 바뀌지 않는다.
 * => i<j, gcd(A[i],A[j])>1 이면 i -> j 제약 (DAG)
 * => 값 기준 사전순 최소 위상정렬을 구하면 될듯?
 * 하지만 값이 같은 경우가 문제인데,
 * [5(A), 5(B), 3] 같은 형태에서 A를 먼저 꺼내면 B가 막혀있을 수도 있고, B를 먼저 꺼내면 3이 빨리 풀릴 수도 있음.
 * 즉, 같은 값일 때 선택 순서에 따라 이후 사전순이 달라질 수 있음.
 * 따라서 값 기준으로 하되, 지금 이 노드를 제거했을 때 즉시 indegree=0이 되는 노드들 중 최소값을 두 번째 비교 기준을 사용해야 할 것.
 */
public class G1_31003 {

    static int N;
    static long[] A;
    static BitSet[] out;   // out[i]: i -> (j들)
    static int[] indeg;
    static boolean[] used;

    static final long INF = Long.MAX_VALUE / 4;

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    // 현재 상태에서 노드 u를 제거하면 "즉시 indeg==0이 되는 이웃들" 중 최소 A값
    static long computeNextMin(int u) {
        long mn = INF;
        BitSet bs = out[u];
        for (int v = bs.nextSetBit(0); v >= 0; v = bs.nextSetBit(v + 1)) {
            if (!used[v] && indeg[v] == 1) { // u를 제거하면 0이 됨
                if (A[v] < mn) mn = A[v];
            }
        }
        return mn;
    }

    static class Node {
        int id;
        long val;
        long nextMin; // lazy로 재검증
        Node(int id, long val, long nextMin) {
            this.id = id;
            this.val = val;
            this.nextMin = nextMin;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Long.parseLong(st.nextToken());

        out = new BitSet[N];
        for (int i = 0; i < N; i++) out[i] = new BitSet(N);
        indeg = new int[N];
        used = new boolean[N];

        // 간선 구성: i<j, gcd(A[i],A[j])>1 이면 i->j
        // N<=3000: O(N^2 logV) 가능
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (gcd(A[i], A[j]) != 1) {
                    out[i].set(j);
                    indeg[j]++;
                }
            }
        }

        // PriorityQueue: (val asc, nextMin asc, id asc)
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> {
            if (x.val != y.val) return Long.compare(x.val, y.val);
            if (x.nextMin != y.nextMin) return Long.compare(x.nextMin, y.nextMin);
            return Integer.compare(x.id, y.id);
        });

        // 초기 indeg 0 삽입
        for (int i = 0; i < N; i++) {
            if (indeg[i] == 0) {
                pq.add(new Node(i, A[i], computeNextMin(i)));
            }
        }

        long[] ans = new long[N];
        int idx = 0;

        while (idx < N) {
            Node cur = pq.poll();
            // lazy 재검증: nextMin이 변했으면 갱신해서 다시 넣기
            long realNextMin = computeNextMin(cur.id);
            if (cur.nextMin != realNextMin) {
                cur.nextMin = realNextMin;
                pq.add(cur);
                continue;
            }
            if (used[cur.id]) continue; // 혹시 중복 삽입 방지

            // 채택
            int u = cur.id;
            used[u] = true;
            ans[idx++] = A[u];

            // u 제거 -> out[u]의 indeg 감소
            BitSet bs = out[u];
            for (int v = bs.nextSetBit(0); v >= 0; v = bs.nextSetBit(v + 1)) {
                if (used[v]) continue;
                indeg[v]--;
                if (indeg[v] == 0) {
                    pq.add(new Node(v, A[v], computeNextMin(v)));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(ans[i]);
        }
        System.out.print(sb);
    }
}
