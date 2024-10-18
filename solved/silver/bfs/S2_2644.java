package solved.silver.bfs;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_2644 {
    static ArrayList<Integer>[] list;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력부
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int Q1 = Integer.parseInt(st.nextToken());
        int Q2 = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();
        visited = new int[n+1];

        int relations = Integer.parseInt(br.readLine());
        for(int i = 0; i < relations; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            list[parent].add(child);
            list[child].add(parent);
        }
        bfs(Q1, Q2);
        if(visited[Q2] > 0)
            System.out.println(visited[Q2]);
        else
            System.out.println(-1);
    }

    private static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            int r = queue.poll();

            if(r==end)
                return;

            for(int k : list[r]) {
                if(visited[k] == 0) {
                    visited[k] = visited[r] + 1;
                    queue.offer(k);
                }
            }
        }
    }
}
