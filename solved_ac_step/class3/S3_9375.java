package solved_ac_step.class3;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S3_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcase; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                if(map.containsKey(type))
                    map.put(type, map.get(type) + 1);
                else
                    map.put(type, 1);
            }
            //종류별로 생각하면 된다.
            //모자 : A모자 B모자 안씀
            //바지 : A바지 B바지 안입음
            //이런 경우 3C1 * 3C1 - 1을 해주면 되는 것이다. -1은 아무것도 안입는 경우를 제하는거다.
            //종류별로 몇개든 조합의 결과 값이 곧 종류의 개수 + 1 이므로 이걸 곱해주면 된다.
            int answer = 1;
            for(int a : map.values())
                answer *= (a + 1);
            System.out.println(answer-1);
        }
    }
}
