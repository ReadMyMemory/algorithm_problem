package solved.bronze.B2;
import java.io.*;
import java.util.StringTokenizer;

public class B2_11094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(N --> 0) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append(st.nextToken());
            if(st.hasMoreTokens()) { // 명령이 한단어인 경우, 추가로 받아올 token이 없어 여기서 error가 났다.
                sb.append(st.nextToken());
                String s = sb.toString();
                sb.setLength(0); // sb 초기화
                if(s.equals("Simonsays")) {
                    while(st.hasMoreTokens())
                        sb.append(st.nextToken()).append(" ");
                    if(sb.length() != 0)
                        bw.write(" " + sb.toString()+"\n");
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
