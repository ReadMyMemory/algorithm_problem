package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_1598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());
        if(N2 % 4 == 0) {
            if(N1 % 4 == 0)
                System.out.println(Math.abs(N1 / 4 - N2 / 4));
            else
                System.out.println(Math.abs((N1 + 4) / 4  - N2 / 4) + Math.abs(4 - N1 % 4));
        } else { // N2 % 4 != 0
            if(N1 % 4 == 0)
                System.out.println(Math.abs(N1 / 4 - (N2 + 4) / 4) + Math.abs(4 - N2 % 4));
            else
                System.out.println(Math.abs(N1 / 4 - N2 / 4) + Math.abs(N1 % 4 - N2 % 4));
        }
    }
}
