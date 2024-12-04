package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

// 4개 중 2개를 뽑는 것. 4C2 = 3
// 따라서 3가지 경우만 체크해주면 되는 간단한 문제다.

public class B4_13866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int min = 10001;
        if(Math.abs((A + B) - (C + D)) < min)
            min = Math.abs((A + B) - (C + D));
        if(Math.abs((A + C) - (B + D)) < min)
            min = Math.abs((A + B) - (C + D));
        if(Math.abs((A + D) - (C + B)) < min)
            min = Math.abs((A + D) - (C + B));
        System.out.println(min);
    }
}
