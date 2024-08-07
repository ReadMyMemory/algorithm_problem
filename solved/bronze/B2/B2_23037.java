package solved.bronze.B2;
import java.io.*;

public class B2_23037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int temp = 5;
        String s = br.readLine();
        while(temp --> 0)
            sum += multiple(s.charAt(temp) - '0');
        System.out.println(sum);
    }

    static int multiple(int n) {
        return n * n * n * n * n;
    }
}
