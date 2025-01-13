package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

/*
카드가 5개 있으면
O O O X X 이렇게 있다고 하자.
여기에 K개만큼 O를, N-K만큼 X를 하면
O의 경우 원래 O의 개수와 K 중 작은 값을 가질 것이다. X도 마찬가지.
따라서 Math.min(M, K) + Math.min(N-M, N-K)가 될듯?
 */

public class B4_16204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(Math.min(M, K) + Math.min(N-M, N-K)));
        bw.flush();
        br.close();
        bw.close();
    }
}
