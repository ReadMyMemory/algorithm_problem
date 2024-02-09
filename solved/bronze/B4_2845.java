package solved.bronze;
import java.io.*;
import java.util.StringTokenizer;

public class B4_2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int value = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++)
            bw.write(String.valueOf(Integer.parseInt(st.nextToken()) - value)+" ");
        bw.flush();
        br.close();
        bw.close();

    }
}
