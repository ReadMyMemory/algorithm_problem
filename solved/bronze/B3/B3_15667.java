package solved.bronze.B3;
import java.io.*;

/*
1 + K + K * K 값이 주어지고 K를 구하라는 얘기다.
N = K * K + K + 1
총 불꽃 개수가 그렇게 크지 않으니 K를 1부터 늘려가면서 대조해봐도 가능할 것 같다.
 */

public class B3_15667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int i = 1;
        while(true) {
            if(N == i + i * i + 1) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
