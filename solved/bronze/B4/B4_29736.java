package solved.bronze.B4;
import java.io.*;

public class B4_29736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int A = Integer.parseInt(firstLine[0]);
        int B = Integer.parseInt(firstLine[1]);

        String[] secondLine = br.readLine().split(" ");
        int K = Integer.parseInt(secondLine[0]);
        int X = Integer.parseInt(secondLine[1]);

        int lowerBound = K - X;
        int upperBound = K + X;

        int count = 0;
        for (int i = A; i <= B; i++) {
            if (i >= lowerBound && i <= upperBound) {
                count++;
            }
        }

        if (count > 0) {
            System.out.println(count);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

}
