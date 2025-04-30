package solved.bronze.B3;
import java.io.*;

public class B3_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        String reversed = new StringBuilder(s).reverse().toString();
        System.out.println(s.equals(reversed) ? 1 : 0);
    }
}
