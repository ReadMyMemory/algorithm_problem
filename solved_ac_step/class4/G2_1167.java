package solved_ac_step.class4;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
문제를 보면서 생각한 것.
결국 트리의 지름은
임의의 점에서 가장 먼 점을 지정했을 때, 그 경로가 최장 거리인 지름의 일부분일 수 있다는 점을 깨닫는 게 포인트인 것 같다.
예를 들어 1-2-3-4-5가 최장거리인 트리의 지름이었다면, 2에서 가장 먼 곳의 점은 5다.
그리고 5에서 가장 먼 곳의 점은? 1이다.
트리는 순환 구조가 없고 단일 연결 구조이기 때문에 다익스트라와 같은 과정이 필요 없다.
따라서 2번의 탐색을 거치면 될 듯 하다.
1. 일단 아무 점에서 가장 먼 정점을 찾는다.
2. 그 정점에서 가장 먼 정점을 찾는다.
3. 둘 사이의 거리를 구하면 그것이 최장 거리이자 트리의 지름이다.
검색 대상 노드가 리프쪽 이니 만큼 dfs를 사용하겠다.
 */

public class G2_1167 {
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int max = 0;
    static int node;

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

        int tempN = 0;
        int N = tempN = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++)
            tree[i] = new ArrayList<>();

        while (tempN --> 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true) {
                int e = Integer.parseInt(st.nextToken());
                if(e == -1)
                    break;
                int cost = Integer.parseInt(st.nextToken());
                tree[s].add(new Node(e, cost));
            }
        }

        //1. dfs 함수를 통해 1에서 가장 먼 노드 찾기. 그리고 그 노드 값 x를 node에 저장함.
        visited = new boolean[N + 1];
        dfs(1, 0);

        //2. 이전에 저장한 node에서 부터 가장 먼 노드 찾기.
        visited = new boolean[N + 1];
        dfs(node ,0);

        //3. 최대 거리인 지름 출력
        System.out.println(max);
    }

    public static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;

        for(int i = 0; i < tree[x].size(); i++) {
            Node node = tree[x].get(i);
            if(visited[node.e] == false) {
                dfs(node.e, node.cost + len);
                visited[node.e] = true;
            }
        }
    }
}
