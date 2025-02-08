package solved.bronze.B2;
import java.io.*;

public class B2_2154 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= input; i++) sb.append(i);

        System.out.print(sb.toString().indexOf(String.valueOf(input)));
    }
}