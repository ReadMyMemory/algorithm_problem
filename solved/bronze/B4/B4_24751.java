package solved.bronze.B4;
import java.io.*;

public class B4_24751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        float ratio = 1 + (float) (100 - a) / a;
        float ratio2 = 1  + (float) a / (100 - a);
        System.out.println(ratio);
        System.out.println(ratio2);

    }
}
