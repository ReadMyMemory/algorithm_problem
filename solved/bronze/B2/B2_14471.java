package solved.bronze.B2;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


/*
2N개 중 N개 이상이면 경품 교환 가능
각각의 카드에는 A개의 당첨과 B개의 꽝 도장이 찍혀있음
꽝 도장은 1엔을 내고 다른 도장으로 바꿀 수 있음.
M-1개의 경품을 가지려고 한다. 즉 일단 모든 경품을 가질 수 있도록 카드마다 비용을 계산한 후 가장 비싼 값을 빼면 되겠다.
 */
public class B2_14471 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> costs = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // A
            int diff = Integer.parseInt(st.nextToken()) - N;
            if(diff > 0) // B
                costs.add(diff);
        }
        costs.sort(Collections.reverseOrder()); // 내림차순 정렬. 가장 앞에 오는 값이 가장 큰 값 이겠다. 이를 전체 비용에서 빼주면 된다.
        int sum = 0;
        for(int a : costs)
            sum += a;
        System.out.println(sum - costs.get(0));
    }
}
