package solved.bronze.B5;
import java.io.*;
import java.util.StringTokenizer;

public class B5_27957 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        if(Integer.parseInt(st.nextToken()) * 100 >= Integer.parseInt(st.nextToken()))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
