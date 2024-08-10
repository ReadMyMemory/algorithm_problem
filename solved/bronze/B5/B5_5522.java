package solved.bronze.B5;
import java.io.*;

public class B5_5522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int temp = 5;
        int sum = 0;
        while(temp --> 0)
            sum += Integer.parseInt(br.readLine());
        System.out.println(sum);

    }
}
