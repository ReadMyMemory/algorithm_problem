package solved.silver.S4;
import java.io.*;
import java.util.StringTokenizer;

public class S4_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Jimin = Integer.parseInt(st.nextToken());
        int Hansu = Integer.parseInt(st.nextToken());

        int count = 1;
        while(N > 0) {

            // https://www.acmicpc.net/board/view/134344 를 참고하여 해결.
            if(Math.max(Jimin, Hansu) % 2 == 0 & Math.abs(Jimin - Hansu) == 1)
                break;

            if(Jimin % 2 != 0)
                Jimin = (Jimin + 1) / 2;
            else
                Jimin /= 2;

            if(Hansu % 2 != 0)
                Hansu = (Hansu + 1) / 2;
            else
                Hansu /= 2;

            count++;
            N /= 2;
        }
        System.out.println(count);
    }
}
