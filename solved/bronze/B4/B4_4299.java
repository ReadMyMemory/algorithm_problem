package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_4299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());
        // x y  x + y = sum x - y = diff
        int x, y;
        if((sum + diff) % 2 != 0 || (sum - diff) % 2 != 0)
            System.out.println(-1);
        else {
            x = (sum + diff) / 2;
            y = (sum - diff) / 2;
            if(y < 0)
                System.out.println(-1);
            else
                System.out.println(x + " " + y);
        }
    }
}
