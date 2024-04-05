package solved.bronze;
import java.io.*;
public class B4_6749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        System.out.println(B+(B-A));
    }
}
