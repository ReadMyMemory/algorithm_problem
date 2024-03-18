package solved.bronze;
import java.io.*;

public class B4_9316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine());
        for(int i = 0; i < number; i++)
            bw.write("Hello World, Judge "+(i+1)+"!\n");

        bw.flush();
        br.close();
        bw.close();


    }
}
