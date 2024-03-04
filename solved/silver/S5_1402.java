package solved.silver;
import java.io.*;
import java.util.StringTokenizer;

public class S5_1402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /*
        이 문제를 푸는데 있어 핵심은 그걸 깨닫는 것이다.
        A = a_1 * a_2 ... a_n 일 때, a_1과 같은 값들은 1또는 -1이 될 수 있고
        이를 통해 원하는 B의 값을 맞출 수 있다.
        1은 곱해도 A의 값에 아무런 영향을 주지 않기 때문에 얼마든지 더할 수 있다.
        따라서 -1을 몇 개를 쓰든 1을 써서 -1의 개수를 맞출 수도 있다. 따라서 값이 무엇이든 yes가 출력되는 것이 정답이다.
         */

        while(T --> 0) {
            br.readLine(); // 범위가 -2^31 ~ 2^31 - 1 이라서 그냥 안받는 게 낫다고 판단했다.
            System.out.println("yes");
        }
    }
}
