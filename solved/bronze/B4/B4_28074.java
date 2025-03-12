package solved.bronze.B4;
import java.io.*;

public class B4_28074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (input.contains("M") && input.contains("O") && input.contains("B") && input.contains("I") && input.contains("S")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
