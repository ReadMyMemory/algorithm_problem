package solved.bronze.B4;
import java.io.*;

public class B4_11282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(Character.toChars(44031 + N));
    }
}
