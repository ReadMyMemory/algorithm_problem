package solved_ac_step.class3;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G3_31230 {
    static int N, M, A, B, start;
    static ArrayList<ArrayList<Node>> graph;


    static class Node {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //아레나 17에서 풀다가 막혔던 문제
        //다익스트라 알고리즘을 적용하는 것까진 좋았는데, 역추적에 대한 부분(경로 기록)을 해결하지 못하고, 메모리 초과가 나서 못풀었었다.
        /* 다익스트라의 기본 원리
        2차원 배열을 사용하여 보통 O(n^2)의 복잡도를 가지는 방법이 있고
        우선순위 큐를 이용하여 O(nlogn)의 복잡도를 가지는 방법이 존재한다.
        둘의 차이는 갱신하는 주변 노드를 선택할 때 다음 최소 비용을 갖는 노드만 선택함으로써 갱신하지 않는 불필요한 경우를 줄이는 것이다.
        그러면 우선순위큐에 주변 노드는 어떻게 넣어야 하느냐?
        1. 다익스트라 알고리즘의 최소 비용을 기준으로 우선순위 큐에 넣어야 한다.
        2. 방문한 노드는 방문 처리하여 중복 노드 방문을 방지한다.
         */

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 개수 N = 노드의 개수 V
        M = Integer.parseInt(st.nextToken()); // 도로의 개수 M = 간선의 개수 E
        A = Integer.parseInt(st.nextToken()); // 민겸이의 도시 A = 다익스트라 알고리즘 수행을 위한 시작 노드 선택
        B = Integer.parseInt(st.nextToken()); // 시은이의 도시 B

        ArrayList<Integer>[] parents = new ArrayList[N+1]; // 부모 노드를 저장할 딕셔너리 배열.
        for(int i = 0; i < N + 1; i++)
            parents[i] = new ArrayList<>();

        graph = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<Node>());

        //그래프 입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 시작 노드 ->
            int b = Integer.parseInt(st.nextToken()); // -> 끝 노드
            int cost = Integer.parseInt(st.nextToken()); // 가중치(weight)
            graph.get(a).add(new Node(b, cost));
        }

        //다익스트라 알고리즘 초기화
        int[] dist = new int[N + 1]; // 최소 비용을 저장할 배열
        for(int i = 0; i < N+1; i++)
            dist[i] = Integer.MAX_VALUE; // 처음엔 연결이 되어 있지 않다고 생각하고 무한대로

        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.offer(new Node(A, 0)); // A = start, 도착 노드가 start 본인이라 비용은 0이다.
        dist[A] = 0;
        while(!q.isEmpty()) {
            Node curNode = q.poll();
            //해당 노드의 비용이 현재 dist 배열에 기록된 내용보다 크다면 고려할 필요가 없으므로 스킵
            if(dist[curNode.idx] < curNode.cost)
                continue;
            // 선택된 노드의 모든 주변 노드 고려
            for(int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nxtNode = graph.get(curNode.idx).get(i);
                parents[i+1].add(curNode.idx); // 이전 노드 저장.
//                System.out.println("*in*"+parents[i]);

                if(dist[nxtNode.idx] == curNode.cost + nxtNode.cost)
                    parents[nxtNode.idx].add(curNode.idx);

                if (dist[nxtNode.idx] > curNode.cost + nxtNode.cost) {
                    parents[nxtNode.idx].remove(parents[nxtNode.idx].size() - 1); // 리스트의 가장 마지막 값 제거.
                    parents[nxtNode.idx].add(curNode.idx); // 이전 노드 저장.
                    dist[nxtNode.idx] = curNode.cost + nxtNode.cost;
//                    System.out.println("*ch*"+parents[nxtNode.idx]);
                    // 갱신된 경우에만 큐에 넣는다.
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }

        //각각 노드의 이전 노드 저장했으니, 경로를 역추적한다.
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(B); // 시은이 도시 추가
        for(int i = 0; i < parents[B].size(); i++) {
            int temp = parents[B].get(i);
            while()
        }


        bw.write(B+" ");
        bw.write()
        int count = 1;

        while(path != parents[A]) {
            int temp = parents[path];
//            bw.write(temp+" ");
            path = parents[temp];
            count++;
//            bw.write(path+" ");
        }
//        System.out.println(count);
//        bw.flush();
        for(int a : parents)
            System.out.print(a+" ");
        br.close();
        bw.close();
    }
}