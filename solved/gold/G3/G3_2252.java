package solved.gold.G3;
import java.io.*;
import java.util.*;

public class G3_2252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        int[] indeg = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            indeg[B]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(' ');

            for (int nxt : graph[cur]) {
                if (--indeg[nxt] == 0) q.add(nxt);
            }
        }
        System.out.print(sb.toString().trim());
    }
}
