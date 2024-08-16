package solved.bronze.B3;
import java.io.*;

public class B3_27465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if(N == 2)
            System.out.println(4);
        else if(N == 1)
            System.out.println(1);
        else {
            if ((N + 1) % 2 == 0)
                System.out.println(N + 1);
            else
                System.out.println(N);
        }
    }
}
