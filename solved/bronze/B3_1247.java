package solved.bronze;
import java.io.*;
import java.math.BigInteger;

public class B3_1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int repeat = 3;

        while(repeat --> 0) {
            int number = Integer.parseInt(br.readLine());
            BigInteger b = new BigInteger("0");

            for(int i = 0; i < number; i++)
                b = b.add(new BigInteger(br.readLine()));

            switch (b.compareTo(BigInteger.ZERO)) {
                case 0:
                    bw.write("0\n");
                    break;
                case -1:
                    bw.write("-\n");
                    break;
                case 1:
                    bw.write("+\n");
                    break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

