package solved.bronze.B4;
import java.io.*;
import java.util.StringTokenizer;

public class B4_25238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int defense = Integer.parseInt(st.nextToken());
        int ignore = Integer.parseInt(st.nextToken());
        if(defense * (100 - ignore) < 10000) // 가급적 소수 계산을 지양하기 위해 100을 나누는 과정을 없애고 양변에 100을 곱했다.
            System.out.println(1);
        else
            System.out.println(0);
    }
}
