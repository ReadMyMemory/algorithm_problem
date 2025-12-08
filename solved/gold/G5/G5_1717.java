package solved.gold.G5;
import java.io.*;
import java.util.*;

/*
유니온 파인드(분리 집합)
 */
public class G5_1717 {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i; // 처음엔 모두 자기 자신이 대표
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) { // 합집합
                union(a, b);
            } else {        // 같은 집합인지 확인
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.print(sb.toString());
    }

    // 경로 압축을 적용한 반복형 find
    static int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]]; // 경로 압축
            x = parent[x];
        }
        return x;
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        // 간단히 번호 작은 쪽을 대표로
        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }
    }
}
