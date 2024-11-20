package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_14924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); // 기차의 속도
        int T = Integer.parseInt(st.nextToken()); // 파리의 속도
        int D = Integer.parseInt(st.nextToken()); // 두 기차 사이의 거리

        int time = D / (2 * S);
        System.out.println(T * time);
    }
}
