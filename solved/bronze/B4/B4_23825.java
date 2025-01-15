package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_23825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(Math.min(Integer.parseInt(st.nextToken()) / 2, Integer.parseInt(st.nextToken()) / 2));
    }
}
