package solved.bronze.B4;
import java.io.*;

public class B4_21964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(N-5)).append(s.charAt(N-4)).append(s.charAt(N-3)).append(s.charAt(N-2)).append(s.charAt(N-1));
        System.out.println(sb.toString());
    }
}
