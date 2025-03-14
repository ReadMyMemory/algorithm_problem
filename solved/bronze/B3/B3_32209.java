package solved.bronze.B3;
import java.io.*;
import java.util.*;

public class B3_32209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        int problemCount = 0;
        boolean dissolved = false;

        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (type == 1) {
                problemCount += num;
            } else if (type == 2) {
                if (problemCount < num) {
                    dissolved = true;
                    break;
                }
                problemCount -= num;
            }
        }

        if (dissolved) {
            System.out.println("Adios");
        } else {
            System.out.println("See you next month");
        }
    }
}
