package solved_ac_step.class3;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S4_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //저장된 사이트 주소의 수, 비밀번호를 찾으려는 사이트 주소의 수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();

        //저장
        while(N > 0) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
            N--;
        }

        //비밀번호 찾기
        while(M > 0) {
            bw.write(map.get(br.readLine())+"\n");
            M--;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
