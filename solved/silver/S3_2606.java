package solved.silver;
import java.io.*;
import java.util.StringTokenizer;

/*
풀이 방식. dfs
bfs와 인접 리스트를 사용한 dfs로도 풀 수 있음
 */

public class S3_2606 {
    static boolean[] infection;
    static int[][] map;
    static int node;
    static int edge;
    static int virus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        map = new int[node + 1][node + 1];
        infection = new boolean[node + 1];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map[A][B] = map[B][A] = 1;
        }
        System.out.println(dfs(1));
    }

    private static int dfs(int n) {
        infection[n] = true;

        for (int i = 1; i <= node; i++) {
            if (map[n][i] == 1 && !infection[i]) {
                virus++;
                dfs(i);
            }
        }
        return virus;
    }
}

