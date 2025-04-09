package solved.bronze.B3;
import java.io.*;
import java.util.StringTokenizer;

public class B3_10833 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int totalLeft = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int students = Integer.parseInt(st.nextToken());
            int apples = Integer.parseInt(st.nextToken());

            totalLeft += apples % students;
        }

        System.out.println(totalLeft);
    }
}
