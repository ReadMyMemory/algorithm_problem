package solved;
import java.io.*;

public class B5_10872 {
    public static int fibonacci(int n) {
        if(n == 0 || n == 1)
            return 1;
        else
            return n * fibonacci(n-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write(Integer.toString(fibonacci(N)));
        bw.flush();
        br.close();
        bw.close();
    }
}
