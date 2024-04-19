package solved_ac_step.class4;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 다익스트라(Djikstra) 알고리즘 적용
// 최단 거리를 먼저 탐색하여 계산 후

public class G4_1504 {
    static ArrayList<Node>[] list;

    public static class Node {
        int e, cost;
        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //N, E 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());


        //그래프 정보 기록
        list = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 방향성이 없으므로 둘 다 추가
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }



    }
}
