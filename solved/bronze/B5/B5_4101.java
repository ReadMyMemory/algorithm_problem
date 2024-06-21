package solved.bronze.B5;
import java.io.*;
import java.util.StringTokenizer;

public class B5_4101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());

            if(temp1 > temp2)
                bw.write("Yes\n");
            else if(temp1 == 0 && temp2 == 0)
                break;
            else
                bw.write("No\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
