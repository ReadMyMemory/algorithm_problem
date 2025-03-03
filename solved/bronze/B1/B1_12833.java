package solved.bronze.B1;
import java.io.*;
public class B1_12833 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        int result = (C % 2 == 0) ? A : (A ^ B);
        System.out.println(result);
    }
}
