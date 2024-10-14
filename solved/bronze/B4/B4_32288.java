package solved.bronze.B4;
import java.io.*;

public class B4_32288 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for(int i = 0; i < N; i++) {
            if(s.charAt(i) == 'I')
                sb.append("i");
            else
                sb.append("L");
        }
        System.out.println(sb.toString());
    }
}
