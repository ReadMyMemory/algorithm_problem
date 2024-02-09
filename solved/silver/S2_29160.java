package solved.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_29160 {

    static class Pair {
        int p, w;
        public Pair(int p, int w) {
            this.p = p;
            this.w = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /* 아이디어
        1년 기준으로
        포지션 중 선수 가치가 가장 높은 선수를 선발선수로. (각각의 포지션에 맞는 최대힙에서 맨 위를 빼냄)
        선발 선수들의 선수 가치를 1 감소(0보다 작아질 순 없다)
        다시 포지션 중 선수 가치가 가장 높은 선수를 선발선수로.
        그리고 12월에 이 선발선수들을 체크

        일단 K년동안 매년 선수 가치 가장 높은 애들 1만큼 감소시키면 된다.
        그다음 출력을 선수 가치 가장 높은 애들 기준으로 선수 가치 합 출력해주면 된다.
         */


        Queue<Pair> q = new LinkedList<Pair>();

        while(N > 0) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st2.nextToken());
            int W = Integer.parseInt(st2.nextToken());
            q.add(new Pair(P, W));
            N--;
        }

    }
}
