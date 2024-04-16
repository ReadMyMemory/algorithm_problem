package solved_ac_step.class4;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2_11725 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parents = new int[N + 1];

        for(int i = 0; i < N+1; i++)
            list[i] = new ArrayList<>();

        while(N --> 1) { // 2번째 줄부터 N-1번째 줄 입력이라
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for(int i = 2; i < parents.length; i++)
            bw.write(parents[i]+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int index) {
        visited[index] = true;
        for(int i : list[index]) {
            if(!visited[i]) {//방문하지 않은 곳의 노드에 부모를 명시.
                parents[i] = index;
                dfs(i);
            }
        }
    }
}
