package solved.bronze.B3;
import java.io.*;

/*
N이 2이면

XX
OX

이런식이여야 대각선에 최소 하나 이상이 색칠되는 경우가 나온다. 그래서 N = 2라면 최소 3칸 칠해야한다.
 */

public class B3_32246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 2)
            System.out.println(3);
        else
            System.out.println(N);
    }
}
