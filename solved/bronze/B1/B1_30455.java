package solved.bronze.B1;
import java.io.*;

public class B1_30455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N % 2 == 0)
            System.out.println("Duck");
        else
            System.out.println("Goose");
    }
}
