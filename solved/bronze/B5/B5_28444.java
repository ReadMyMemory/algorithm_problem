package solved.bronze.B5;
import java.io.*;
import java.util.StringTokenizer;

public class B5_28444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first_term = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        int second_term = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        System.out.println(first_term - second_term);
    }
}
