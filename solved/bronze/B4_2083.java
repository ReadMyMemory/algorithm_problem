package solved.bronze;
import java.io.*;
import java.util.StringTokenizer;

public class B4_2083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("#")) {
                st.nextToken();
                st.nextToken();
                break;
            }
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(age > 17) {
                bw.write(str+" Senior"+"\n");
            } else if(weight >= 80) {
                bw.write(str+" Senior"+"\n");
            } else {
                bw.write(str+" Junior"+"\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
