package solved.bronze.B1;
import java.io.*;
import java.util.StringTokenizer;

/*
원의 두 직선이 내부에서 교차할 때, 한 직선의 두 분할된 구간의 길이의 곱이 다른 직선의 두 분할된 구간의 길이의 곱과 같다는 성질을 이용
p_ab * p_cd = p_bc * p_da 성질에서
p_da = p_ab * p_cd / p_bc 이용
 */

public class B1_16478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double p_ab = Double.parseDouble(st.nextToken());
        double p_bc = Double.parseDouble(st.nextToken());
        double p_cd = Double.parseDouble(st.nextToken());

        double p_da = p_ab * p_cd / p_bc;

        System.out.printf("%.6f\n", p_da);
    }
}
