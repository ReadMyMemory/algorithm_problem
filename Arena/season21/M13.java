package Arena.season21;
import java.io.*;
import java.util.StringTokenizer;

public class M13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int friends = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] track_info = new int[4];
        while(friends --> 0) {
            String track = st.nextToken();
            track_info[validation(track)]++;
        }
        System.out.println(track_info[validation(br.readLine())]);
    }
    static int validation(String s) {
        if(s.equals("C"))
            return 0;
        else if(s.equals("S"))
            return 1;
        else if(s.equals("I"))
            return 2;
        else if(s.equals("A"))
            return 3;
        return 4;
    }
}
