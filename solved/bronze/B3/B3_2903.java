package solved.bronze.B3;
import java.io.*;

public class B3_2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int side = (1 << n) + 1;
        int answer = side * side;
        System.out.println(answer);
    }
}